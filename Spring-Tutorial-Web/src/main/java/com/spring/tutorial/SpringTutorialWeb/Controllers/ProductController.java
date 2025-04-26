package com.spring.tutorial.SpringTutorialWeb.Controllers;

import com.spring.tutorial.SpringTutorialWeb.Models.Product;
import com.spring.tutorial.SpringTutorialWeb.Models.ResponseObject;
import com.spring.tutorial.SpringTutorialWeb.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    // DI = Dependency Injection
    @Autowired
    private ProductRepository repository;

    @GetMapping("")
        // This request is: http://localhost:8081/api/v1/products
    List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Let's return an object: data, message, status, using ternary operator
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Product> foundProduct = repository.findById(id);
        return ResponseEntity.status(foundProduct.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(new ResponseObject(
                        foundProduct.isPresent() ? "ok" : "false",
                        foundProduct.isPresent() ? "Query product successfully" : "Cannot find product with id = " + id,
                        foundProduct.isPresent() ? foundProduct.get() : ""
                ));
    }
    // Insert new Product with POST method
    // Postman: Raw, JSON
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        // 2 Product must not have the same name. !
        List<Product> foundProduct = repository.findByNameProduct(newProduct.getNameProduct().trim());
        if(foundProduct.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Product name already taken.", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Insert product successfully", repository.save(newProduct))
        );
    }
    // update, upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@PathVariable Long id, @RequestBody Product newProduct) {
        Product updatedProduct = repository.findById(id)
                .map(product -> {
                    product.setNameProduct(newProduct.getNameProduct().trim());
                    product.setProductYear(newProduct.getProductYear());
                    product.setPrice(newProduct.getPrice());
                    return repository.save(product);
                }).orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Update product successfully", updatedProduct)
        );
    }

    // Delete a Product => DELETE method.
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id) {
        boolean exist = repository.existsById(id);
        if(exist) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Delete product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ResponseObject("failed", "Cannot find product to delete = " + id, "")
        );
    }
}
package com.spring.tutorial.SpringTutorialWeb.Repositories;

import com.spring.tutorial.SpringTutorialWeb.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameProduct(String nameProduct);

}

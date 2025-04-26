package com.spring.tutorial.SpringTutorialWeb.Models;

import jakarta.persistence.*;

import java.util.Calendar;

@Entity
@Table(name="tblProduct")
public class Product {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO) // auto-increment
    // You can also use "sequence"
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1 // increment by 1
    )


    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    // validate = constraint
    @Column(nullable = false, unique = true, length = 300)
    private String nameProduct;
    private int productYear;
    private double price;
    private String url;
    // default constructor
    public Product() {}
    // Calculated field = transient, not exist in MySql
    @Transient
    private int age; // age is calculated from "year"
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - productYear;
    }
    public Product(String nameProduct, double price, int productYear, String url) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.productYear = productYear;
        this.url = url;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getProductYear() { return productYear; }
    public void setProductYear(int productYear) { this.productYear = productYear; }
    public String getNameProduct() { return nameProduct; }
    public void setNameProduct(String nameProduct) { this.nameProduct = nameProduct; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", productYear=" + productYear +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product other = (Product) obj;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


}
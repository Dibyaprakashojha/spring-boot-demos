package com.productapp.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private String name;
    private Integer productId;
    private double price;
    private String category;
    private String brand;
    private LocalDate expiryDate;

    public Product(String name, double price, String category, String brand, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.expiryDate = expiryDate;
    }
}

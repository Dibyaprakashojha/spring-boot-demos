package com.productapp.model;

public class Product {
    private String name;
    private Integer productId;
    private double price;
    private String category;
    private String brand;

    public Product() {
        super();
    }
    public Product(String name, Integer productId, double price, String category, String brand) {
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.category = category;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String
    toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productId=" + productId +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}

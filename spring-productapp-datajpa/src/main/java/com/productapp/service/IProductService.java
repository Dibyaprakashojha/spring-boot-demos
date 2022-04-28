package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Category;
import com.productapp.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> getAll();

    //derived queries
    List<Product> getByCategory(Category category) throws ProductNotFoundException;
    List<Product> getByBrand(String brand) throws ProductNotFoundException;
    Product getById(int id);
    List<Product> getByLesserPrice(double price);
    List<Product> getByBrandStarting(String brand) throws ProductNotFoundException;
    List<Product> getByExpiryDate(LocalDate expiryDate);

    //custom queries
    List<Product> getByNewBrands(String brand);
    List<Product> getByBrandCost(String brand, double cost);
    List<Product> getByCatExpiry(Category category, LocalDate date);
    List<Product> getByBrandExpiry(String brand, LocalDate date);
    List<Product> getByCatBrand(Category category,String brand);
    List<Product> getByBrandName(String brand, String name);
    List<Product> getByBetweenPrice(double minPrice, double maxPrice);
    void updateProductCost(double price, int productId);




}

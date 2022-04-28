package com.productapp.dao;

import com.productapp.model.Product;

import java.util.List;

public interface IProductDao {
    List<Product> findAll();
    List<Product> findByCategory(String category);
    List<Product> findByBrand(String brand);
    Product findById(int id);
}

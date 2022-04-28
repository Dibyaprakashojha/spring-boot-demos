package com.productapp.service;

import com.productapp.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    List<Product> getByCategory(String category);
    List<Product> getByBrand(String brand);
    Product getById(int id);

}

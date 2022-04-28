package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements IProductService {
    IProductRepository iProductRepository;

    @Autowired
    public void setiProductRepository(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public void addProduct(Product product) {
        iProductRepository.addProduct(product);
    }

    @Override
    public void updateProduct(int productId, double price) {
        iProductRepository.updateProduct(productId, price);
    }

    @Override
    public void deleteProduct(int productId) {
        iProductRepository.deleteProduct(productId);

    }

    @Override
    public List<Product> getAll() {
        System.out.println("Product Details: ");
        return iProductRepository.findAll().stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByCategory(String category) {
        List<Product> products = iProductRepository.findByCategory(category);
        if (products.isEmpty())
            throw new ProductNotFoundException("Category Not Found..!!");
        System.out.println("Products By Category: ");
        return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByBrand(String brand) {
        List<Product> products = iProductRepository.findByBrand(brand);
        if (products.isEmpty())
            throw new ProductNotFoundException("Product Not Found..!!");
        System.out.println("Products By Brand: ");
        return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    @Override
    public Product getById(int id) {
        System.out.println("Product By ID: ");
        Product product = iProductRepository.findById(id);
        if (product != null)
            return product;
        throw new ProductNotFoundException("Id not Found");
    }

    @Override
    public List<Product> getByLesserPrice(double price) {
        System.out.println("Products By Lesser than " + price + ": ");
        List<Product> products = iProductRepository.findByLesserPrice(price).stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
        if (products.isEmpty())
            throw new ProductNotFoundException("Product Not Found..!!");
        return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByBrandStarting(String brand) {
        System.out.println("Products By Brand Starting with " + brand + ": ");
        List<Product> products = iProductRepository.findByBrandStarting(brand);
        if (products.isEmpty())
            throw new ProductNotFoundException("Brand Not Found..!!");
        return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());

    }

    @Override
    public List<Product> getByExpiryDate(LocalDate expiryDate) {
        System.out.println("Products By expiryDate " + expiryDate + ": ");
        List<Product> products = iProductRepository.findByExpiryDate(expiryDate);
        if (products.isEmpty())
            throw new ProductNotFoundException("Product Not Found..!!");
        return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());

    }
}

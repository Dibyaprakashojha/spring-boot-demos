package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Category;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class ProductServiceImpl implements IProductService {
    IProductRepository iProductRepository;

    @Autowired
    public void setiProductRepository(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public void addProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        iProductRepository.deleteById(productId);
    }

    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public List<Product> getByCategory(Category category) throws ProductNotFoundException {
        return iProductRepository.findByCategory(category);
    }

    @Override
    public Product getById(int id) {
        return iProductRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Invalid Id"));
    }


    @Override
    public List<Product> getByBrand(String brand) throws ProductNotFoundException {
        return iProductRepository.getByBrand(brand);
    }


    @Override
    public List<Product> getByLesserPrice(double price) {
        return iProductRepository.readByPriceLessThan(price);
    }

    @Override
    public List<Product> getByBrandStarting(String brand) throws ProductNotFoundException {
        return iProductRepository.findByBrandStartingWith(brand);
    }

    @Override
    public List<Product> getByExpiryDate(LocalDate expiryDate) {
        return iProductRepository.findByExpiryDateLessThan(expiryDate);
    }

    @Override
    public List<Product> getByNewBrands(String brand) {
        return iProductRepository.getByNewBrands(brand);
    }

    @Override
    public List<Product> getByBrandCost(String brand, double cost) {
        return iProductRepository.getByBrandCost(brand,cost);
    }

    @Override
    public List<Product> getByCatExpiry(Category category, LocalDate date) {
        return iProductRepository.getByCatExpiry(category, date);
    }

    @Override
    public List<Product> getByBrandExpiry(String brand, LocalDate date) {
        return iProductRepository.getByBrandExpiry(brand,date);
    }

    @Override
    public List<Product> getByCatBrand(Category category, String brand) {
        return iProductRepository.getByCatBrand(category,brand);
    }

    @Override
    public List<Product> getByBrandName(String brand, String name) {
        return iProductRepository.getByBrandName(brand, name);
    }

    @Override
    public List<Product> getByBetweenPrice(double minPrice, double maxPrice) {
        return iProductRepository.getByBetweenPrice(minPrice, maxPrice);
    }

    @Override
    @Transactional
    public void updateProductCost(double price, int productId) {
        iProductRepository.updateProductCost(price, productId);
    }
}

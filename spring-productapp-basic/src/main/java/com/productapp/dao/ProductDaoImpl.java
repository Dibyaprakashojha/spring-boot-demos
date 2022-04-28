package com.productapp.dao;

import com.productapp.model.Product;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDaoImpl implements IProductDao{
    @Override
    public List<Product> findAll() {
        return showProducts();
    }

    @Override
    public List<Product> findByCategory(String category) {
        return showProducts().stream().filter(product -> product.getCategory().equalsIgnoreCase(category)).sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    @Override
    public List<Product> findByBrand(String brand) {
        return showProducts().stream().filter(product -> product.getBrand().equalsIgnoreCase(brand)).sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    @Override
    public Product findById(int id) {
        return showProducts().stream().filter(product -> product.getProductId().equals(id)).findAny().get();
    }

    private List<Product> showProducts() {
        List<Product> products = Arrays.asList(new Product("Shampoo",1,5.0,"Cosmetics","SunSilk"),
                new Product("Shampoo & Conditioner",2,17.0,"Cosmetics","Pantene"),
                new Product("Conditioner",3,8.0,"Cosmetics","Clinic PLus"),
                new Product("Pen",4,50.0,"Stationary","Parker"),
                new Product("Pencil",5,15.0,"Stationary","Parker"));
        return products;
    }
}

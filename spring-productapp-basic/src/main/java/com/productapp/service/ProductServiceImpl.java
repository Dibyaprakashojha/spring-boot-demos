package com.productapp.service;

import com.productapp.dao.IProductDao;
import com.productapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductServiceImpl implements IProductService {
    IProductDao iProductDao;
    @Autowired
    public void setiProductDao(IProductDao iProductDao) {
        this.iProductDao = iProductDao;
    }

    @Override
    public List<Product> getAll() {
        return iProductDao.findAll();
    }

    @Override
    public List<Product> getByCategory(String category) {
        return iProductDao.findByCategory(category);
    }

    @Override
    public List<Product> getByBrand(String brand) {
        return iProductDao.findByBrand(brand);
    }

    @Override
    public Product getById(int id) {
        return iProductDao.findById(id);
    }
}

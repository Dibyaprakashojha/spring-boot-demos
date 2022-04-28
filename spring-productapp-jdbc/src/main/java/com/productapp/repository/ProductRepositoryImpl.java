package com.productapp.repository;

import com.productapp.model.Product;
import com.productapp.util.AllQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addProduct(Product product) {
        //convert LocalDate to sql date for saving in DB
        Date expiryDate = Date.valueOf(product.getExpiryDate());
        Object[] productArray = {product.getName(),product.getBrand(),product.getCategory(),product.getPrice(),expiryDate};
        jdbcTemplate.update(AllQueries.INSERTQUERY,productArray);
    }

    @Override
    public void updateProduct(int productId, double price) {
        jdbcTemplate.update(AllQueries.UPDATEQUERY, price,productId);
    }

    @Override
    public void deleteProduct(int productId) {
        jdbcTemplate.update(AllQueries.DELETEQUERY,productId);
    }

    @Override
    public List<Product> findAll() {
        RowMapper<Product> productRowMapper = new ProductMapper();
        List<Product> products = jdbcTemplate.query(AllQueries.SELECTQUERY,productRowMapper);
        return products;
    }

    @Override
    public List<Product> findByCategory(String category) {
        RowMapper<Product> productRowMapper = new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setProductId(rs.getInt("productid"));
                product.setBrand(rs.getString("brand"));
                product.setPrice(rs.getDouble("price"));
                Date date = rs.getDate("expirydate");
                product.setExpiryDate(date.toLocalDate());
                product.setCategory(rs.getString("category"));
                return product;
            }
        };
        return jdbcTemplate.query(AllQueries.CATEGORYQUERY,productRowMapper,category);
    }

    @Override
    public List<Product> findByBrand(String brand) {
        return jdbcTemplate.query(AllQueries.BRANDQUERY, new ProductMapper(), brand);
    }

    @Override
    public Product findById(int id) {
        return jdbcTemplate.queryForObject(AllQueries.IDQUERY, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setProductId(rs.getInt("productid"));
                product.setBrand(rs.getString("brand"));
                product.setPrice(rs.getDouble("price"));
                Date date = rs.getDate("expirydate");
                product.setExpiryDate(date.toLocalDate());
                product.setCategory(rs.getString("category"));
                return product;
            }
        },id);
    }

    @Override
    public List<Product> findByLesserPrice(double price) {
        return jdbcTemplate.query(AllQueries.PRICEQUERY, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setProductId(rs.getInt("productid"));
                product.setBrand(rs.getString("brand"));
                product.setPrice(rs.getDouble("price"));
                Date date = rs.getDate("expirydate");
                product.setExpiryDate(date.toLocalDate());
                product.setCategory(rs.getString("category"));
                return product;
            }
        },price);
    }

    @Override
    public List<Product> findByBrandStarting(String brand) {
        return jdbcTemplate.query(AllQueries.BRANDSTARTINGQUERY,(rs,rowNum)->{
            Product product = new Product();
            product.setName(rs.getString("name"));
            product.setProductId(rs.getInt("productid"));
            product.setBrand(rs.getString("brand"));
            product.setPrice(rs.getDouble("price"));
            Date date = rs.getDate("expirydate");
            product.setExpiryDate(date.toLocalDate());
            product.setCategory(rs.getString("category"));
            return product;
        },brand+"%");
    }

    @Override
    public List<Product> findByExpiryDate(LocalDate expiryDate) {
        return jdbcTemplate.query(AllQueries.DATEQUERY,(rs,rowNum)->{
            Product product = new Product();
            product.setName(rs.getString("name"));
            product.setProductId(rs.getInt("productid"));
            product.setBrand(rs.getString("brand"));
            product.setPrice(rs.getDouble("price"));
            Date date = rs.getDate("expirydate");
            product.setExpiryDate(date.toLocalDate());
            product.setCategory(rs.getString("category"));
            return product;
        },expiryDate);
    }

}

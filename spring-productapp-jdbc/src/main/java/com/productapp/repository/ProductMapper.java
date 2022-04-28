package com.productapp.repository;

import com.productapp.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setName(rs.getString("name"));
        product.setProductId(rs.getInt("productid"));
        product.setBrand(rs.getString("brand"));
        product.setPrice(rs.getDouble("price"));
        Date date = rs.getDate("expirydate");
        LocalDate expiryDate = date.toLocalDate();
        product.setExpiryDate(expiryDate);
        product.setCategory(rs.getString("category"));
        return product;
    }
}

package com.productapp.util;

public class AllQueries {
    public static final String INSERTQUERY = "INSERT INTO PRODUCT(name,brand,category,price,expirydate) VALUES(?,?,?,?,?)";
    public static final String DELETEQUERY = "DELETE FROM PRODUCT WHERE productid =?";
    public static final String UPDATEQUERY = "UPDATE PRODUCT SET price=? WHERE productid = ?";
    public static final String SELECTQUERY = "SELECT * FROM PRODUCT";
    public static final String IDQUERY = "SELECT * FROM PRODUCT WHERE productid = ?";
    public static final String BRANDQUERY = "SELECT * FROM PRODUCT WHERE brand = ?";
    public static final String CATEGORYQUERY = "SELECT * FROM PRODUCT WHERE category = ?";
    public static final String PRICEQUERY = "SELECT * FROM PRODUCT WHERE price <= ?";
    public static final String BRANDSTARTINGQUERY = "SELECT * FROM PRODUCT WHERE brand like ?";
    public static final String DATEQUERY = "SELECT * FROM PRODUCT WHERE expirydate < ?";
}

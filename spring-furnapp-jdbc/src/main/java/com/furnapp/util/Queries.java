package com.furnapp.util;

public class Queries {
    public static final String INSERTQUERY = "INSERT INTO FURNITURE(name,brand,category,price,style,room_type,material,storage_available) VALUES(?,?,?,?,?,?,?,?)";
    public static final String DELETEQUERY = "DELETE FROM FURNITURE WHERE furnitureId =?";
    public static final String UPDATEQUERY = "UPDATE FURNITURE SET price=? WHERE furnitureId = ?";
    public static final String CATEGORYQUERY = "SELECT * FROM FURNITURE  WHERE category = ?";
    public static final String IDQUERY = "SELECT * FROM FURNITURE WHERE furnitureId = ?";
    public static final String BRANDQUERY = "SELECT * FROM FURNITURE WHERE brand = ?";
    public static final String MATERIALQUERY = "SELECT * FROM FURNITURE WHERE material = ?";
    public static final String PRICEQUERY = "SELECT * FROM FURNITURE WHERE price BETWEEN ? AND ? ";
    public static final String STYLEQUERY = "SELECT * FROM FURNITURE WHERE style = ?";
    public static final String ROOMTYPEQUERY = "SELECT * FROM FURNITURE WHERE room_type = ?";
    public static final String STORAGEQUERY = "SELECT * FROM FURNITURE WHERE storage_available = ?";
}

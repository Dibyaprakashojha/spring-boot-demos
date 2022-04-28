package com.furnapp.repository;

import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FurnitureMapper implements RowMapper<Furniture> {
    @Override
    public Furniture mapRow(ResultSet rs, int rowNum) throws SQLException {
        Furniture furniture = new Furniture();
        furniture.setName(rs.getString("name"));
        furniture.setFurnitureId(rs.getInt("furnitureId"));
        furniture.setBrand(rs.getString("brand"));
        furniture.setPrice(rs.getDouble("price"));
        furniture.setCategory(Category.valueOf(rs.getString("category")));
        furniture.setMaterial(rs.getString("material"));
        furniture.setRoomType(rs.getString("room_type"));
        furniture.setStyle(Style.valueOf(rs.getString("style")));
        furniture.setStorageAvailable(rs.getBoolean("storage_available"));
        return furniture;
    }
}

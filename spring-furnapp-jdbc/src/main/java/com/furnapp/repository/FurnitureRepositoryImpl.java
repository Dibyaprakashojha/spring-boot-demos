package com.furnapp.repository;

import com.furnapp.model.Furniture;
import com.furnapp.util.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.desktop.QuitEvent;
import java.util.List;

@Repository
public class FurnitureRepositoryImpl implements IFurnitureRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addFurniture(Furniture furniture) {
        Object[] furnitureArray = {furniture.getName(),furniture.getBrand(),
                furniture.getCategory().name(),furniture.getPrice(),
                furniture.getStyle().name(), furniture.getRoomType(),
                furniture.getMaterial(),furniture.isStorageAvailable()};
        jdbcTemplate.update(Queries.INSERTQUERY,furnitureArray);
    }

    @Override
    public void updateFurniture(int furnitureId, double price) {
        jdbcTemplate.update(Queries.UPDATEQUERY,price,furnitureId);
    }

    @Override
    public void deleteFurniture(int furnitureId) {
        jdbcTemplate.update(Queries.DELETEQUERY,furnitureId);
    }

    @Override
    public List<Furniture> getByCategory(String category) {
        return jdbcTemplate.query(Queries.CATEGORYQUERY,new FurnitureMapper(),category);
    }

    @Override
    public List<Furniture> getByBrand(String brand) {
        return jdbcTemplate.query(Queries.BRANDQUERY,new FurnitureMapper(),brand);
    }

    @Override
    public List<Furniture> getByMaterial(String material) {
        return jdbcTemplate.query(Queries.MATERIALQUERY,new FurnitureMapper(),material);
    }

    @Override
    public List<Furniture> getByStyle(String style) {
        return jdbcTemplate.query(Queries.STYLEQUERY,new FurnitureMapper(),style);
    }

    @Override
    public List<Furniture> getByPriceRange(int minPrice, double maxPrice) {
        return jdbcTemplate.query(Queries.PRICEQUERY,new FurnitureMapper(),minPrice,maxPrice);
    }

    @Override
    public List<Furniture> getByRoomType(String roomType) {
        return jdbcTemplate.query(Queries.ROOMTYPEQUERY,new FurnitureMapper(),roomType);
    }

    @Override
    public Furniture getById(int furnitureId) {
        return jdbcTemplate.queryForObject(Queries.IDQUERY,new FurnitureMapper(),furnitureId);
    }

    @Override
    public List<Furniture> getByStorageAvailable(boolean storageAvailable) {
        return jdbcTemplate.query(Queries.STORAGEQUERY,new FurnitureMapper(),storageAvailable);
    }
}

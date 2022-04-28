package com.furnapp.service;


import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFurnitureService {

    void addFurniture(Furniture furniture);
    void updateFurniture(Furniture furniture);
    void deleteFurniture(int furnitureId);
    Furniture findById(int furnitureId);

    // derived query
    List<Furniture> findByCategory(Category category);
    List<Furniture> findByBrand(String brand);
    List<Furniture> findByMaterial(String material);
    List<Furniture> findByStyle(Style style);
    List<Furniture> findByRoomType(String roomType);
    List<Furniture> findByStorageAvailable(boolean storageAvailable);

    //native query
    List<Furniture> findByPriceRange(int minPrice, double maxPrice);
    List<Furniture> findByMatAndBrand(String material, String brand);
    List<Furniture> findByRoomAndCategory(String roomType, String category);
    Integer findTotal();

    //named query
    Integer findCategoryCost(Category category);

}

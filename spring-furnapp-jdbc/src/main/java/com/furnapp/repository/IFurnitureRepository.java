package com.furnapp.repository;


import com.furnapp.model.Furniture;

import java.util.List;

public interface IFurnitureRepository {
    void addFurniture(Furniture furniture);
    void updateFurniture(int furnitureId, double price);
    void deleteFurniture(int furnitureId);

    List<Furniture> getByCategory(String category);
    List<Furniture> getByBrand(String brand);
    List<Furniture> getByMaterial(String material);
    List<Furniture> getByStyle(String style);
    List<Furniture> getByPriceRange(int minPrice, double maxPrice);
    List<Furniture> getByRoomType(String roomType);
    Furniture getById(int furnitureId);
    List<Furniture> getByStorageAvailable(boolean storageAvailable);
}

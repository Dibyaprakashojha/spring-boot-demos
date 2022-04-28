package com.furnapp.service;


import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Furniture;

import java.util.List;

public interface IFurnitureService {
    void addFurniture(Furniture furniture);
    void updateFurniture(int furnitureId, double price);
    void deleteFurniture(int furnitureId);

    List<Furniture> getByCategory(String category) throws FurnitureNotFoundException;
    List<Furniture> getByBrand(String brand) throws FurnitureNotFoundException;
    List<Furniture> getByMaterial(String material) throws FurnitureNotFoundException;
    List<Furniture> getByStyle(String style) throws FurnitureNotFoundException;
    List<Furniture> getByPriceRange(int minPrice, double maxPrice) throws FurnitureNotFoundException;
    List<Furniture> getByRoomType(String roomType) throws FurnitureNotFoundException;
    Furniture getById(int furnitureId) throws FurnitureNotFoundException;
    List<Furniture> getByStorageAvailable(boolean storageAvailable) throws FurnitureNotFoundException;


}

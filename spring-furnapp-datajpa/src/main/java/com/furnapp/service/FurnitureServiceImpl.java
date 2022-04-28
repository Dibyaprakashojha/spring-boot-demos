package com.furnapp.service;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import com.furnapp.repository.IFurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FurnitureServiceImpl implements IFurnitureService {

    IFurnitureRepository iFurnitureRepository;
    @Autowired
    public void setiFurnitureRepository(IFurnitureRepository iFurnitureRepository) {
        this.iFurnitureRepository = iFurnitureRepository;
    }

    @Override
    public void addFurniture(Furniture furniture) {
        iFurnitureRepository.save(furniture);
    }

    @Override
    public void updateFurniture(Furniture furniture) {
        iFurnitureRepository.save(furniture);
    }

    @Override
    public void deleteFurniture(int furnitureId) {
        iFurnitureRepository.deleteById(furnitureId);
    }

    @Override
    public Furniture findById(int furnitureId) {
        return iFurnitureRepository.findById(furnitureId).get();
    }

    @Override
    public List<Furniture> findByCategory(Category category) {
        return iFurnitureRepository.findByCategory(category);
    }

    @Override
    public List<Furniture> findByBrand(String brand) {
        return iFurnitureRepository.findByBrand(brand);
    }

    @Override
    public List<Furniture> findByMaterial(String material) {
        return iFurnitureRepository.findByMaterial(material);
    }

    @Override
    public List<Furniture> findByStyle(Style style) {
        return iFurnitureRepository.findByStyle(style);
    }

    @Override
    public List<Furniture> findByRoomType(String roomType) {
        return iFurnitureRepository.findByRoomType(roomType);
    }



    @Override
    public List<Furniture> findByStorageAvailable(boolean storageAvailable) {
        return iFurnitureRepository.findByStorageAvailable(storageAvailable);
    }

    @Override
    public List<Furniture> findByPriceRange(int minPrice, double maxPrice) {
        return iFurnitureRepository.findByPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<Furniture> findByMatAndBrand(String material, String brand) {
        return iFurnitureRepository.findByMatAndBrand(material, brand);
    }

    @Override
    public List<Furniture> findByRoomAndCategory(String roomType, String category) {
        return iFurnitureRepository.findByRoomAndCategory(roomType, category);
    }

    @Override
    public Integer findTotal() {
        return iFurnitureRepository.findTotal();
    }

    @Override
    public Integer findCategoryCost(Category category) {
        return iFurnitureRepository.findCategoryCost(category);
    }
}

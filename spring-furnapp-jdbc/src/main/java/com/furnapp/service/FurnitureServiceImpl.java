package com.furnapp.service;

import com.furnapp.repository.IFurnitureRepository;
import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Furniture;
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
    iFurnitureRepository.addFurniture(furniture);
    }

    @Override
    public void updateFurniture(int furnitureId, double price) {
        iFurnitureRepository.updateFurniture(furnitureId,price);
    }

    @Override
    public void deleteFurniture(int furnitureId) {
        iFurnitureRepository.deleteFurniture(furnitureId);
    }

    @Override
    public List<Furniture> getByCategory(String category) throws FurnitureNotFoundException {
        return iFurnitureRepository.getByCategory(category);
    }

    @Override
    public List<Furniture> getByBrand(String brand) throws FurnitureNotFoundException {
        return iFurnitureRepository.getByBrand(brand);
    }

    @Override
    public List<Furniture> getByMaterial(String material) throws FurnitureNotFoundException {
        return iFurnitureRepository.getByMaterial(material);
    }

    @Override
    public List<Furniture> getByStyle(String style) throws FurnitureNotFoundException {
        return iFurnitureRepository.getByStyle(style);
    }

    @Override
    public List<Furniture> getByPriceRange(int minPrice, double maxPrice) throws FurnitureNotFoundException {
        return iFurnitureRepository.getByPriceRange(minPrice,maxPrice);
    }

    @Override
    public List<Furniture> getByRoomType(String roomType) throws FurnitureNotFoundException {
        return iFurnitureRepository.getByRoomType(roomType);
    }

    @Override
    public Furniture getById(int furnitureId) throws FurnitureNotFoundException {
        return iFurnitureRepository.getById(furnitureId);
    }

    @Override
    public List<Furniture> getByStorageAvailable(boolean storageAvailable) throws FurnitureNotFoundException {
        return iFurnitureRepository.getByStorageAvailable(storageAvailable);
    }
}

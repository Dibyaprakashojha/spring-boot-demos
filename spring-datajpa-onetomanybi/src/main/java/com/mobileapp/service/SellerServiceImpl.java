package com.mobileapp.service;

import com.mobileapp.model.Camera;
import com.mobileapp.model.Seller;
import com.mobileapp.repository.ISellerRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements ISellerService{
    private ISellerRepository iSellerRepository;

    public SellerServiceImpl(ISellerRepository iSellerRepository) {
        this.iSellerRepository = iSellerRepository;
    }

    @Override
    public Seller addSeller(Seller mobile) {
        return iSellerRepository.save(mobile);
    }

    @Override
    public void updateSeller(Seller restaurant) {
        iSellerRepository.save(restaurant);
    }

    @Override
    public void deleteSeller(int restaurantId) {
        iSellerRepository.deleteById(restaurantId);
    }

    @Override
    public Seller getById(int sellerId) {
        return iSellerRepository.findById(sellerId).get();
    }

    @Override
    public List<Seller> getAll() {
        return iSellerRepository.findAll();
    }

    @Override
    public List<Seller> getByCity(String city) {
        return iSellerRepository.findByCity(city);
    }

    @Override
    public List<Seller> getByRatings(double ratings) {
        return iSellerRepository.findByRating(ratings);
    }

    @Override
    public List<Seller> getByMobBrand(String brand) {
        return iSellerRepository.findByMobBrand(brand).stream().sorted(Comparator.comparing(Seller::getSellerName)).collect(Collectors.toList());
    }

    @Override
    public List<Seller> getByMobCamera(Camera cameraType) {
        return iSellerRepository.findByMobCamera(cameraType);
    }

    @Override
    public List<Seller> getByMobOsMem(String os, String memory) {
        return iSellerRepository.findByMobOsMem(os, memory);
    }

    @Override
    public List<Seller> getByMobBrandPrice(String brand, double price) {
        return iSellerRepository.findByMobBrandPrice(brand, price);
    }
}

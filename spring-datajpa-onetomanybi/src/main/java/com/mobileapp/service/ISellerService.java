package com.mobileapp.service;

import com.mobileapp.model.Camera;
import com.mobileapp.model.Seller;

import java.util.List;

public interface ISellerService {
    Seller addSeller(Seller seller);
    void updateSeller(Seller seller);
    void deleteSeller(int sellerId);
    Seller getById(int sellerId);
    List<Seller> getAll();

    //derived queries

    // custom queries
    List<Seller> getByCity(String city);
    List<Seller> getByRatings(double ratings);
    List<Seller> getByMobBrand(String brand);
    List<Seller> getByMobCamera(Camera cameraType);
    List<Seller> getByMobOsMem(String os, String memory);
    List<Seller> getByMobBrandPrice(String brand, double price);


}

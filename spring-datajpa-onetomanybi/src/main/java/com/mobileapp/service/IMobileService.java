package com.mobileapp.service;

import com.mobileapp.model.Mobile;
import com.mobileapp.model.Processor;

import java.util.List;

public interface IMobileService {
    List<Mobile> getAll();

    //derived queries
    List<Mobile> getByBrand(String brand);
    List<Mobile> getByProcessor(Processor processor);
    List<Mobile> getByCamera(String cameraType);

    // custom queries

    List<Mobile> getByOs(String operatingSystem);
    List<Mobile> getByOsAndMemory(String operatingSystem, String memory);
    List<Mobile> getByProcessorAndMem(Processor processor,String memory);
    List<Mobile> getByStorage(String storage);
    List<Mobile> getByBrandAndCam(String brand, String camera);
    List<Mobile> getSellerName(String sellerName);
    List<Mobile> getSellerCity(String sellerName,String city);

}

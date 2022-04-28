package com.mobileapp.service;

import com.mobileapp.model.Camera;
import com.mobileapp.model.Mobile;
import com.mobileapp.model.Processor;
import com.mobileapp.repository.IMobileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MobileServiceImpl implements IMobileService{
    private IMobileRepository iMobileRepository;

    public MobileServiceImpl(IMobileRepository iMobileRepository) {
        this.iMobileRepository = iMobileRepository;
    }

    @Override
    public List<Mobile> getAll() {
        return iMobileRepository.findAll();
    }

    @Override
    public List<Mobile> getByBrand(String brand) {
        return iMobileRepository.findByBrand(brand);
    }

    @Override
    public List<Mobile> getByProcessor(Processor processor) {
        return iMobileRepository.findByProcessor(processor);
    }

    @Override
    public List<Mobile> getByCamera(String cameraType) {
        return iMobileRepository.findByCamera(cameraType);
    }

    @Override
    public List<Mobile> getByOs(String operatingSystem) {
        return iMobileRepository.findByOs(operatingSystem);
    }

    @Override
    public List<Mobile> getByOsAndMemory(String operatingSystem, String memory) {
        return iMobileRepository.findByOsAndMemory(operatingSystem, memory);
    }

    @Override
    public List<Mobile> getByProcessorAndMem(Processor processor, String memory) {
        return iMobileRepository.findProcessorAndMemory(processor, memory);
    }

    @Override
    public List<Mobile> getByStorage(String storage) {
        return iMobileRepository.findByStorage(storage);
    }

    @Override
    public List<Mobile> getByBrandAndCam(String brand, String camera) {
        return iMobileRepository.findByBrandAndCamera(brand, camera);
    }

    @Override
    public List<Mobile> getSellerName(String sellerName) {
        return iMobileRepository.findSellerName(sellerName);
    }

    @Override
    public List<Mobile> getSellerCity(String sellerName, String city) {
        return iMobileRepository.findSellerCity(sellerName, city);
    }

}

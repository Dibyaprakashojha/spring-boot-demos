package com.mobileapp.repository;

import com.mobileapp.model.Camera;
import com.mobileapp.model.Mobile;
import com.mobileapp.model.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMobileRepository extends JpaRepository<Mobile,Integer> {
//
//    List<Mobile> findByBrand(String brand);
//    List<Mobile> findByFeaturesProcessor(Processor processor);
//    List<Mobile> findByFeaturesCameraType(String cameraType);
//
//    // custom queries
//    @Query("from Mobile m inner join m.seller s where m.processor=?1")
//    List<Mobile> findByOs(String operatingSystem);
//    @Query("from Mobile m inner join m.seller s where m.processor=?1 and m.memory=?2")
//    List<Mobile> findByOsAndMemory(String operatingSystem, String memory);
//    @Query("from Mobile m inner join m.seller s where m.processor=?1 and m.memory=?2")
//    List<Mobile> findByProcessorAndMem(Processor processor, String memory);
//    @Query("from Mobile m inner join m.seller s where m.storage=?1")
//    List<Mobile> findByStorage(String storage);
//    @Query("from Mobile m inner join m.seller s where m.brand=?1 and m.cameraType=?2")
//    List<Mobile> findByBrandAndCam(String brand, String cameraType);
//    @Query("from Mobile m inner join m.seller s where m.brand=?1 and m.price<=?2")
//    List<Mobile> findByBrandAndLessPrice(String brand, double price);

    List<Mobile> findByBrand(String brand);
    @Query("from Mobile m where m.processor=?1")
    List<Mobile> findByProcessor(Processor processor);
    @Query("from Mobile m where m.cameraType =?1")
    List<Mobile> findByCamera(String cameraType);
    @Query("from Mobile m where m.operatingSystem =?1")
    List<Mobile> findByOs(String os);
    @Query("from Mobile m  where m.operatingSystem=?1 and m.memory=?2")
    List<Mobile> findByOsAndMemory(String os,String memory);
    @Query("from Mobile m where m.processor=?1 and m.memory=?2")
    List<Mobile> findProcessorAndMemory(Processor processor,String memory);
    @Query("from Mobile m where m.storage=?1")
    List<Mobile> findByStorage(String storage);
    @Query("from Mobile m where m.brand=?1 and m.cameraType=?2")
    List<Mobile> findByBrandAndCamera(String brand, String cameraType);

    @Query("from Mobile m inner join m.sellers s where s.sellerName=?1")
    List<Mobile> findSellerName(String sellerName);

    @Query("from Mobile m inner join m.sellers s where s.sellerName=?1 and s.city=?2")
    List<Mobile> findSellerCity(String sellerName,String city);


}

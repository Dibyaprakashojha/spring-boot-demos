package com.mobileapp.repository;

import com.mobileapp.model.Camera;
import com.mobileapp.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISellerRepository extends JpaRepository<Seller,Integer> {

//    List<Seller> findByBrand(String brand);
//    List<Seller> findByFeaturesProcessor(String processor);
//    List<Seller> findByFeaturesCameraType(Camera cameraType);

    // custom queries
//    @Query("from Seller m inner join m.features f where f.processor=?1")
//    List<Seller> findByOs(String operatingSystem);
//    @Query("from Seller m inner join m.features f where f.processor=?1 and f.memory=?2")
//    List<Seller> findByOsAndMemory(String operatingSystem, String memory);
//    @Query("from Seller m inner join m.features f where f.processor=?1 and f.memory=?2")
//    List<Seller> findByProcessorAndMem(String processor,String memory);
//    @Query("from Seller m inner join m.features f where f.storage=?1")
//    List<Seller> findByStorage(String storage);
//    @Query("from Seller m inner join m.features f where m.brand=?1 and f.cameraType=?2")
//    List<Seller> findByBrandAndCam(String brand, String camera);
//    @Query("from Seller m inner join m.features f where m.brand=?1 and m.price<=?2")
//    List<Seller> findByBrandAndLessPrice(String brand, double price);


    List<Seller> findByCity(String city);
    List<Seller> findByRating(double ratings);


    @Query("from Seller s inner join s.mobiles m where m.brand=?1")
    List<Seller> findByMobBrand(String brand);

    @Query("from Seller s inner join s.mobiles m where m.cameraType=?1")
    List<Seller> findByMobCamera(Camera cameraType);

    @Query("from Seller s inner join s.mobiles m where m.operatingSystem=?1 and m.memory=?2")
    List<Seller> findByMobOsMem(String os, String memory);

    @Query("from Seller s inner join s.mobiles m where m.brand=?1 and m.price<=?2")
    List<Seller> findByMobBrandPrice(String brand, double price);

}

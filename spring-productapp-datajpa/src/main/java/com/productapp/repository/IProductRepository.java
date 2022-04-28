package com.productapp.repository;

import com.productapp.model.Category;
import com.productapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
        //derived queries
    List<Product> findByCategory(Category category);
    List<Product> getByBrand(String brand);
    List<Product> readByPriceLessThan(double price);
    List<Product> findByBrandStartingWith(String brand);
    List<Product> findByExpiryDateLessThan(LocalDate date);

    //custom query - JPQL
    @Query("from Product p where p.brand = ?1")
    List<Product> getByNewBrands(String brand);

    @Query("from Product p where p.brand = ?1 and p.price <?2")
    List<Product> getByBrandCost(String brand, double cost);

    @Query("from Product p where p.category = ?1 and p.expiryDate <= ?2")
    List<Product> getByCatExpiry(Category category, LocalDate date);

    //named query - call the named query by name
    @Query(name = "findByBrandExpiry")
    List<Product> getByBrandExpiry(String brand, LocalDate date);
    @Query(name = "findByCatBrand")
    List<Product> getByCatBrand(Category category,String brand);
    @Query(name = "findByBrandName")
    List<Product> getByBrandName(String brand, String name);

    //native query - using SQL statements
    @Query(value = "select * from newproduct where cost between ?1 and ?2",nativeQuery = true)
    List<Product> getByBetweenPrice(double minPrice, double maxPrice);

    // updating SQL Query
    @Modifying
    @Query(value="update newproduct set cost=?1 where product_id=?2",nativeQuery = true)
    void updateProductCost(double price, int productId);




}

package com.productapp;

import com.productapp.model.Category;
import com.productapp.model.Product;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringProductappDatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappDatajpaApplication.class, args);
	}

	@Autowired
	IProductService iProductService;

	@Override
	public void run(String... args) throws Exception {
		LocalDate expiryDate = LocalDate.of(2026,5,15);
//		iProductService.addProduct(new Product("Laptop",35000, Category.ELECTRONICS, "Dell",expiryDate));


		//update product
		Product nproduct = iProductService.getById(101);
		nproduct.setBrand("Hamleys");
//		iProductService.updateProduct(nproduct);
//		iProductService.getAll().forEach(System.out::println);
//		iProductService.getByExpiryDate(expiryDate).forEach(System.out::println);
//		iProductService.getByCategory(Category.ELECTRONICS).forEach(System.out::println);
//		iProductService.getByBrandStarting("A").forEach(System.out::println);
//		iProductService.getByLesserPrice(10000).forEach(System.out::println);
//		iProductService.getByNewBrands("Hamleys").forEach(System.out::println);
//		iProductService.getByBrandCost("Asus",60000).forEach(System.out::println);
//		iProductService.getByCatExpiry(Category.ELECTRONICS,expiryDate).forEach(System.out::println);
//		iProductService.getByBrandExpiry("Asus",expiryDate).forEach(System.out::println);
//		iProductService.getByCatBrand(Category.ELECTRONICS,"Asus").forEach(System.out::println);
		System.out.println();
//		iProductService.getByBetweenPrice(450,50000).forEach(System.out::println);
//		iProductService.getByBrandName("Asus","Laptop").forEach(System.out::println);
		iProductService.updateProductCost(28000,100);
	}
}

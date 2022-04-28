package com.productapp;

import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProductappBasicApplication implements CommandLineRunner {

	@Autowired
	IProductService iProductService;

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Product Details:");
		iProductService.getAll().forEach(System.out::println);
		System.out.println("Product By Category:");
		iProductService.getByCategory("Stationary").forEach(System.out::println);
		System.out.println("Product By Brand:");
		iProductService.getByBrand("Parker").forEach(System.out::println);
		System.out.println("Product By Id:");
		System.out.println(iProductService.getById(1));
	}
}

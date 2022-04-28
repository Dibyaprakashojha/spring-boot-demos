package com.furnapp;

import com.furnapp.model.*;
import com.furnapp.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFurnappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringFurnappJdbcApplication.class, args);
	}

	@Autowired
	IFurnitureService iFurnitureService;

	@Override
	public void run(String... args) throws Exception {
		Furniture furniture = new Furniture("Large Sofa",
				Category.SOFA, RoomType.LIVING.type,
				Material.FABRIC.type, Style.MODERN,
				"Mintwud",23000,false);
//		iFurnitureService.addFurniture(furniture);
//		iFurnitureService.updateFurniture(1,29000);
//		iFurnitureService.getByBrand("Mintwud").forEach(System.out::println);
		iFurnitureService.getByStyle(Style.MODERN.name()).forEach(System.out::println);
	}
}

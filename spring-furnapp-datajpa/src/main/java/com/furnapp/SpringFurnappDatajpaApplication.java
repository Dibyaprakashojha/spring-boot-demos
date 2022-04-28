package com.furnapp;

import com.furnapp.model.*;
import com.furnapp.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFurnappDatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringFurnappDatajpaApplication.class, args);
	}
	@Autowired
	private IFurnitureService iFurnitureService;
	@Override
	public void run(String... args) throws Exception {

//		iFurnitureService.addFurniture(new Furniture("Bed", Category.BED, Material.TWOOD.type, RoomType.LIVING.type, Style.CONTEMPORARY,"Dews",38000,true));
		Furniture furniture1 = iFurnitureService.findById(10);
		furniture1.setMaterial(Material.SWOOD.type);
//		iFurnitureService.updateFurniture(furniture1);
//		System.out.println(iFurnitureService.findById(10));
//		System.out.println("The cost of furniture is = "+iFurnitureService.findCategoryCost(Category.BED));
//		iFurnitureService.findByCategory(Category.BED).forEach(System.out::println);
//		iFurnitureService.findByBrand("Dews").forEach(System.out::println);
//		iFurnitureService.findByMaterial(Material.TWOOD.type).forEach(System.out::println);
//		iFurnitureService.findByStyle(Style.CONTEMPORARY).forEach(System.out::println);
//		iFurnitureService.findByRoomType(RoomType.LIVING.type).forEach(System.out::println);
//		iFurnitureService.findByStorageAvailable(true).forEach(System.out::println);

	}
}

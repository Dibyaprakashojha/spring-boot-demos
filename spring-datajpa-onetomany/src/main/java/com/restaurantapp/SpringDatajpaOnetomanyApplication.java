package com.restaurantapp;

import com.restaurantapp.model.*;
import com.restaurantapp.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringDatajpaOnetomanyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetomanyApplication.class, args);
	}
	@Autowired
	IRestaurantService iRestaurantService;
	@Override
	public void run(String... args) throws Exception {
		Item item1 = new Item("Masala Dosa",Category.BREAKFAST,Type.VEG,Cuisine.SOUTHINDIAN,120);
		Item item2 = new Item("Butter Chicken",Category.MAINCOURSE,Type.NONVEG,Cuisine.NOTHRINDIAN,200);
		Item item3 = new Item("Veg Burger",Category.FASTFOOD,Type.VEG,Cuisine.ITALIAN,150);
		Item item4 = new Item("Sweet Lassi",Category.DESSERTS,Type.VEG,Cuisine.CONTINENTIAL,90);

		Set<Item> items = new HashSet<>(Arrays.asList(item1,item2,item3,item4));
		Restaurant restaurant = new Restaurant("Mehfil",Type.NONVEG,"Hyderabad",3.5,items);
//		iRestaurantService.addRestaurant(restaurant);
//		iRestaurantService.getAll().forEach(System.out::println);
//		iRestaurantService.getByCategory(Category.FASTFOOD).forEach(System.out::println);
//		iRestaurantService.getByName("Masala Dosa").forEach(System.out::println);
//		iRestaurantService.getByNameCategory("Mehfil",Category.BREAKFAST).forEach(System.out::println);
//		iRestaurantService.getByCuisineAndType(Cuisine.ITALIAN,Type.VEG).forEach(System.out::println);
//		iRestaurantService.getByNameLessPrice("Butter Chicken",200).forEach(System.out::println);
		iRestaurantService.getByCuisineAndType(Cuisine.SOUTHINDIAN,Type.VEG).forEach(System.out::println);
	}
}

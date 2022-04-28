package com.productapp;

import com.productapp.model.Category;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringProductappJdbcApplication implements CommandLineRunner {

    @Autowired
    IProductService iProductService;

    public static void main(String[] args) {
        SpringApplication.run(SpringProductappJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDate expiryDate = LocalDate.of(2022, 10, 02);
        String category = Category.ELECTRONICS.type;
//		iProductService.addProduct(new Product("Mobile",5500.0,category,"Samsung",expiryDate));
//		iProductService.addProduct(new Product("Ball",400.0,Category.TOYS.name(), "Adidas",LocalDate.of(2022, Month.DECEMBER,18)));
//		iProductService.addProduct(new Product("Toy Train",499.0,Category.TOYS.type, "Hamley",LocalDate.of(2022, Month.MAY,25)));
//		iProductService.addProduct(new Product("iPad",69999.0,Category.ELECTRONICS.type, "Apple",LocalDate.of(2025, Month.DECEMBER,8)));

        // All product
        iProductService.getAll().forEach(System.out::println);
        //Product by brand
        iProductService.getByBrand("Apple").forEach(System.out::println);
        //Product by Id
        System.out.println(iProductService.getById(1));
        //Product by Category
        iProductService.getByCategory("TOYS").forEach(System.out::println);
		//Product staring with any Brand
        iProductService.getByBrandStarting("H").forEach(System.out::println);

        // take input as string and convert it into local_date
        LocalDate edate = LocalDate.parse("2022-10-02");
        iProductService.getByExpiryDate(edate).forEach(System.out::println);

        // take input as Local_date using LocalDate.of(YYYY,MM,DD)
        iProductService.getByExpiryDate(LocalDate.of(2022, 10, 02)).forEach(System.out::println);
    }
}

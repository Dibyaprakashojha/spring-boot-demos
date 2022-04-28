package com.mobileapp;

import com.mobileapp.model.*;
import com.mobileapp.service.IMobileService;
import com.mobileapp.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringDatajpaOnetomanybiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetomanybiApplication.class, args);
	}
	@Autowired
	private ISellerService iSellerService;
	@Autowired
	private  IMobileService iMobileService;
	@Override
	public void run(String... args) throws Exception {
		Mobile mobile = new Mobile("11 Ultimate", "Realme", 49999, Processor.SNAPDRAGON, Memory.MEMORY8.name(), Storage.STORAGE256.capacity, Camera.DUAL.getCamera(), OperatingSystem.ANDROID.name());

		Mobile mobile1 = new Mobile("M20", "Samsung", 23000, Processor.SNAPDRAGON, Memory.MEMORY6.name(), Storage.STORAGE64.capacity, Camera.REAR.getCamera(), OperatingSystem.ANDROID.name());

		Set<Mobile> mobileList = new HashSet<>(Arrays.asList(mobile1,mobile));

		Seller seller = new Seller("POORVIKA", "Bengaluru", 4.4,mobileList);

//		System.out.println(iSellerService.addSeller(seller));

//		iSellerService.getByMobBrand("Samsung").forEach(System.out::println);
		iSellerService.getByMobBrandPrice("Samsung", 23000).forEach(seller1 -> {
			System.out.println(seller1.getMobiles());
			System.out.println(seller1.getSellerName());
			System.out.println();
		});

		iMobileService.getAll().forEach(System.out::println);
		System.out.println();
		iMobileService.getByBrand("Apple").forEach(System.out::println);
		System.out.println();
		iMobileService.getByProcessor(Processor.SNAPDRAGON).forEach(System.out::println);
		System.out.println();
		iMobileService.getByCamera(Camera.DUAL.getCamera()).forEach(System.out::println);
		System.out.println();
		iMobileService.getByOsAndMemory(OperatingSystem.ANDROID.name(),Memory.MEMORY6.name()).forEach(System.out::println);
		System.out.println();
		iMobileService.getByProcessorAndMem(Processor.SNAPDRAGON,Memory.MEMORY6.name()).forEach(System.out::println);
		System.out.println();
		iMobileService.getByStorage(OperatingSystem.ANDROID.name()).forEach(System.out::println);
		System.out.println();
		iMobileService.getByBrandAndCam("Apple",Camera.DUAL.getCamera()).forEach(System.out::println);
		System.out.println();
		iMobileService.getSellerName("Croma").forEach(System.out::println);
		System.out.println();
		iMobileService.getSellerCity("Croma","Hyderabad").forEach(System.out::println);
		System.out.println();

	}
}

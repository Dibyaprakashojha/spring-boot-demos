package com.employeeapp;

import com.employeeapp.model.BiAddress;
import com.employeeapp.model.Employee;
import com.employeeapp.service.IBiAddressService;
import com.employeeapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDatajpaOnetoonebiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetoonebiApplication.class, args);
	}
	@Autowired
	private IEmployeeService iEmployeeService;
	@Autowired
	private IBiAddressService iBiAddressService;
	@Override
	public void run(String... args) throws Exception {
		BiAddress biAddress1 = new BiAddress("Ayodhya", "Uttar Pradhesh", 400051, "A256", "Awadh Street");
		Employee employee1 = new Employee("Awadhesh", "Developer", biAddress1);
		BiAddress biAddress2 = new BiAddress("Chennai", "Tamil Nadu", 500081, "C313", "Anjaneyar Street");
		Employee employee2 = new Employee("Abuthair", "Developer", biAddress2);

//		iEmployeeService.addEmployee(employee1);
//		iEmployeeService.addEmployee(employee2);

//		iEmployeeService.getAll().forEach(System.out::println);
//		iEmployeeService.getByCity("Chennai").forEach(System.out::println);
//		iEmployeeService.getByDeptAndCity("Developer", "Ayodhya").forEach(System.out::println);
//		System.out.println(iEmployeeService.getById(1));
//		iEmployeeService.getByDepartment("Developer").forEach(System.out::println);
//		iEmployeeService.getByFlatNumber("A256").forEach(System.out::println);
//		iEmployeeService.getByState("Uttar Pradhesh").forEach(System.out::println);



//		iBiAddressService.getByName("Awadhesh").forEach(System.out::println);
		iBiAddressService.getByCity("Chennai").forEach(biAddress -> {
			System.out.println(biAddress.getEmployee().getName());
			System.out.println(biAddress.getEmployee().getDepartment());
		});
//		iBiAddressService.getByDepartment("Developer").forEach(System.out::println);
//		iBiAddressService.getByNameAndCity("Awadhesh", "Ayodhya").forEach(System.out::println);
//		iBiAddressService.getByNameStreet("Abuthair","Anjaneyar Street").forEach(System.out::println);
//		System.out.println(iBiAddressService.getByEmpId(2));



	}
}

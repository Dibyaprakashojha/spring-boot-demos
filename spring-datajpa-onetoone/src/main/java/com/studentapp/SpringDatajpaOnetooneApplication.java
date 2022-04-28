package com.studentapp;

import com.studentapp.model.Address;
import com.studentapp.model.Student;
import com.studentapp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDatajpaOnetooneApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(SpringDatajpaOnetooneApplication.class, args);
	}

	@Autowired
	private IStudentService iStudentService;
	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("Ayodhya","Uttar Pradhesh");
		Student student = new Student("Awadhesh","CSE",address);
//		iStudentService.addStudent(student);

//		Student student1 = iStudentService.getById(1);
//		student1.setDepartment("EEE");
//		Address address1 = student1.getAddress();
//		address1.setCity("Hugli");
//		student1.setAddress(address1);
//		iStudentService.updateStudent(student1);
//		System.out.println("All details:");
//		iStudentService.getAll().forEach(System.out::println);
		System.out.println("CITY:");
		iStudentService.getByCity("Ayodhya").forEach(System.out::println);
	}
}

package com.courseapp;

import com.courseapp.model.Category;
import com.courseapp.model.Course;
import com.courseapp.model.TechStack;
import com.courseapp.model.Trainer;
import com.courseapp.repository.ICourseRepository;
import com.courseapp.service.ICourseService;
import com.courseapp.service.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringDatajpaManytomanyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaManytomanyApplication.class, args);
	}

	private ICourseService iCourseService;

	private ITrainerService iTrainerService;

	@Autowired
	public void setiTrainerService(ITrainerService iTrainerService) {
		this.iTrainerService = iTrainerService;
	}

	@Autowired
	public void setiCourseService(ICourseService iCourseService) {
		this.iCourseService = iCourseService;
	}

	@Override
	public void run(String... args) throws Exception {
		Trainer trainer1 = new Trainer("Helen",4.9,10,
				TechStack.CLOUD_COMPUTING.name(), LocalDate.of(2016,6,7));

		// create a new trainer also
		Trainer trainer2 = new Trainer("Awadhesh",4.0,5,
				TechStack.TESTING.name(), LocalDate.of(2018,10,12));
//		iTrainerService.addTrainer(trainer1);
//		iTrainerService.addTrainer(trainer2);

//		 get the trainer by id
//		Trainer trainer3 = iTrainerService.getById(12);
//		Trainer trainer4 = iTrainerService.getById(13);

		// create a set of trainers
//		Set<Trainer> trainers = new HashSet<>(Arrays.asList(trainer4,trainer3));

		Course course = new Course("Oracle in 10 days",10,4500, Category.TESTING.name());
		// set the trainer to the course
//		course.setTrainers(trainers);
//		iCourseService.addCourse(course);

//		iCourseService.getAll().forEach(course1 -> {
//			System.out.println(course1.getTrainers());
//			System.out.println(course1.getCourseName());
//		});
//		iCourseService.getByCourseNameContaining("F").forEach(System.out::println);
//		iCourseService.getByNameAndDuration("Full",30).forEach(System.out::println);
//		iCourseService.getByTrainerExperience("Sripriya", 10).forEach(System.out::println);

		iTrainerService.getAll().forEach(System.out::println);
		System.out.println();
		iTrainerService.getByTrainerNameContaining("Sri").forEach(System.out::println);
		System.out.println();

		iTrainerService.getByRatings(3.5).forEach(System.out::println);
		System.out.println();

		iTrainerService.getByJoiningDateBefore(LocalDate.of(2018,10,10)).forEach(System.out::println);
		System.out.println();

		iTrainerService.getByCourseNameContaining("30").forEach(System.out::println);
		System.out.println();

		iTrainerService.getByNameAndFees("Full", 1000).forEach(System.out::println);
		System.out.println();

		iTrainerService.getByTechStack(TechStack.FULLSTACK.name()).forEach(System.out::println);
		System.out.println();

		iTrainerService.getByCategoryRatings(Category.WEB.name(), 3.8).forEach(System.out::println);
		System.out.println();

		iTrainerService.getByCourseNameAndFees(Category.WEB.name(), 500).forEach(System.out::println);
		System.out.println();

		iTrainerService.getByCourseNameAndDuration("Full", 10).forEach(System.out::println);
	}
}

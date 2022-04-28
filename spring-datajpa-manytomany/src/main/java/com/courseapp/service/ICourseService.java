package com.courseapp.service;

import com.courseapp.model.Course;

import java.util.List;

public interface ICourseService {
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int courseId);
    Course getById(int courseId);
    List<Course> getAll();

    //derived queries
    List<Course> getByCategory(String category);
    List<Course> getByCourseNameContaining(String courseName); // course having java

    // custom queries
    List<Course> getByNameAndFees(String courseName, double fees);
    List<Course> getByTrainerName(String trainerName); // all course by this trainer
    List<Course> getByTrainerExpertise(String trainerName, String techStack);
    List<Course> getByTrainerRatings(String trainerName, double ratings);
    List<Course> getByTrainerExperience(String trainerName, int experience);
    List<Course> getByTrainerExpertiseCourseName(String trainerName, String courseName); //name containing
    List<Course> getByNameAndDuration(String courseName, int duration);




}

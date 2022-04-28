package com.courseapp.service;

import com.courseapp.model.Course;
import com.courseapp.model.Trainer;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ITrainerService {
    Trainer addTrainer(Trainer trainer);
    void updateTrainer(Trainer trainer);
    void deleteTrainer(int trainerId);
    Trainer getById(int trainerId);
    List<Trainer> getAll();

    List<Trainer> getByTrainerNameContaining(String trainerName); // trainer having S
    List<Trainer> getByRatings(double ratings);
    List<Trainer> getByJoiningDateBefore(LocalDate beforeDate);



    List<Trainer> getByCourseNameContaining(String courseName); // course having java
    List<Trainer> getByNameAndFees(String courseName, double fees);
    List<Trainer> getByTechStack(String techStack);
    List<Trainer> getByCategoryRatings(String category, double ratings);
    List<Trainer> getByCourseNameAndFees(String courseName, double fees); //name containing
    List<Trainer> getByCourseNameAndDuration(String courseName, int duration);


}

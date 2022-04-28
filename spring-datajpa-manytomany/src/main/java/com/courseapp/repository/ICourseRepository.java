package com.courseapp.repository;

import com.courseapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findByCategory(String category);
    List<Course> findByCourseNameContaining(String courseName); // course having java

    // custom queries
    @Query("from Course c where c.courseName=?1 and c.fees<=?2")
    List<Course> findByNameAndFees(String courseName, double fees);

    @Query("from Course c inner join c.trainers t where t.trainerName=?1")
    List<Course> findByTrainerName(String trainerName); // all course by this trainers

    @Query("from Course c inner join c.trainers t where t.trainerName=?1 and t.techStack=?2")
    List<Course> findByTrainerExpertise(String trainerName, String techStack);

    @Query("from Course c inner join c.trainers t where t.trainerName=?1 and t.ratings=?2")
    List<Course> findByTrainerRatings(String trainerName, double ratings);

    @Query("from Course c inner join c.trainers t where t.trainerName=?1 and t.experience=?2")
    List<Course> findByTrainerExperience(String trainerName, int experience);

    @Query("from Course c inner join c.trainers t where t.trainerName=?1 and t.techStack=?2")
    List<Course> findByTrainerExpertiseCourseName(String trainerName, String courseName); //name containing

    @Query("from Course c inner join c.trainers t where c.courseName=?1 and c.durationInDays=?2")
    List<Course> findByNameAndDuration(String courseName, int duration);



}

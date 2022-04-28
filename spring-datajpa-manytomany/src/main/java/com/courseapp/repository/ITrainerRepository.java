package com.courseapp.repository;
import com.courseapp.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ITrainerRepository extends JpaRepository<Trainer,Integer> {

    List<Trainer> findByTrainerNameContaining(String trainerName); // trainer having S
    List<Trainer> findByRatings(double ratings);
    List<Trainer> findByJoiningDateBefore(LocalDate beforeDate);



    @Query("from Trainer t inner join t.courses c where c.courseName=?1")
    List<Trainer> findByCourseNameContaining(String courseName); // course having java

    @Query("from Trainer t inner join t.courses c where c.courseName=?1 and c.fees<=?2")
    List<Trainer> findByNameAndFees(String courseName, double fees);

    @Query("from Trainer t where t.techStack=?1")
    List<Trainer> findByTechStack(String techStack);

//    @Query("from Trainer t inner join t.courses c where c.category=?1 and t.ratings=?2")
    List<Trainer> findByCoursesCategoryAndRatings(String category, double ratings);

    @Query("from Trainer t inner join t.courses c where c.courseName=?1 and c.fees<=?2")
    List<Trainer> findByCourseNameAndFees(String courseName, double fees); //name containing

    @Query("from Trainer t inner join t.courses c where t.trainerName=?1 and c.durationInDays>=?2")
    List<Trainer> findByCourseNameAndDuration(String courseName, int duration);


}

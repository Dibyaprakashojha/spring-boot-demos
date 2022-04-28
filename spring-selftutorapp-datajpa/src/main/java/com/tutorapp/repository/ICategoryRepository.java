package com.tutorapp.repository;

import com.tutorapp.model.Category;
import com.tutorapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

//
//    List<Category> getByTopic(String topic);
//    List<Category> getByLanguage(String language);
}

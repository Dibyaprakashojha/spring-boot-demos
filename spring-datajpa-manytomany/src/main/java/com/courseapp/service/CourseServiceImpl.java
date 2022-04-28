package com.courseapp.service;

import com.courseapp.model.Course;
import com.courseapp.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseRepository iCourseRepository;

    @Override
    @Transactional
    public void addCourse(Course course) {
        iCourseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        iCourseRepository.save(course);
    }

    @Override
    public void deleteCourse(int courseId) {
        iCourseRepository.deleteById(courseId);
    }

    @Override
    @Transactional
    public Course getById(int courseId) {
        return iCourseRepository.findById(courseId).get();
    }

    @Override
    public List<Course> getAll() {
        return iCourseRepository.findAll(Sort.by(Sort.Direction.DESC,"courseName"));
    }

    @Override
    public List<Course> getByCategory(String category) {
        return iCourseRepository.findByCategory(category);
    }

    @Override
    public List<Course> getByNameAndFees(String courseName, double fees) {
        return iCourseRepository.findByNameAndFees("%"+courseName+"%", fees);
    }

    @Override
    public List<Course> getByCourseNameContaining(String courseName) {
        return iCourseRepository.findByCourseNameContaining(courseName);
    }

    @Override
    public List<Course> getByTrainerName(String trainerName) {
        return iCourseRepository.findByTrainerName(trainerName);
    }

    @Override
    public List<Course> getByTrainerExpertise(String trainerName, String techStack) {
        return iCourseRepository.findByTrainerExpertise(trainerName, techStack);
    }

    @Override
    public List<Course> getByTrainerRatings(String trainerName, double ratings) {
        return iCourseRepository.findByTrainerRatings(trainerName, ratings);
    }

    @Override
    public List<Course> getByTrainerExperience(String trainerName, int experience) {
        return iCourseRepository.findByTrainerExperience(trainerName, experience);
    }

    @Override
    public List<Course> getByTrainerExpertiseCourseName(String trainerName, String courseName) {
        return iCourseRepository.findByTrainerExpertiseCourseName(trainerName, "%"+courseName+"%");
    }

    @Override
    public List<Course> getByNameAndDuration(String courseName, int duration) {
        return iCourseRepository.findByNameAndDuration("%"+courseName+"%", duration);
    }
}

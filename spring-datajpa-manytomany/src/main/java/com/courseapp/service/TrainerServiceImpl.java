package com.courseapp.service;

import com.courseapp.model.Trainer;
import com.courseapp.repository.ITrainerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TrainerServiceImpl implements ITrainerService {
    private ITrainerRepository iTrainerRepository;

    public TrainerServiceImpl(ITrainerRepository iTrainerRepository) {
        this.iTrainerRepository = iTrainerRepository;
    }


    @Override
    public Trainer addTrainer(Trainer trainer) {
        return iTrainerRepository.save(trainer);
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        iTrainerRepository.save(trainer);
    }

    @Override
    public void deleteTrainer(int trainerId) {
        iTrainerRepository.deleteById(trainerId);

    }

    @Override
    public Trainer getById(int trainerId) {
        return iTrainerRepository.findById(trainerId).get();
    }

    @Override
    public List<Trainer> getAll() {
        return iTrainerRepository.findAll(Sort.by(Sort.Direction.DESC,"trainerName"));
    }

    @Override
    public List<Trainer> getByTrainerNameContaining(String trainerName) {
        return iTrainerRepository.findByTrainerNameContaining(trainerName);
    }

    @Override
    public List<Trainer> getByRatings(double ratings) {
        return iTrainerRepository.findByRatings(ratings);
    }

    @Override
    public List<Trainer> getByJoiningDateBefore(LocalDate beforeDate) {
        return iTrainerRepository.findByJoiningDateBefore(beforeDate);
    }

    @Override
    public List<Trainer> getByCourseNameContaining(String courseName) {
        return iTrainerRepository.findByCourseNameContaining("%"+courseName+"%");
    }

    @Override
    public List<Trainer> getByNameAndFees(String courseName, double fees) {
        return iTrainerRepository.findByNameAndFees("%"+courseName+"%", fees);
    }

    @Override
    public List<Trainer> getByTechStack(String techStack) {
        return iTrainerRepository.findByTechStack(techStack);
    }

    @Override
    public List<Trainer> getByCategoryRatings(String category, double ratings) {
        return iTrainerRepository.findByCoursesCategoryAndRatings(category, ratings);
    }

    @Override
    public List<Trainer> getByCourseNameAndFees(String courseName, double fees) {
        return iTrainerRepository.findByCourseNameAndFees(courseName, fees);
    }

    @Override
    public List<Trainer> getByCourseNameAndDuration(String courseName, int duration) {
        return iTrainerRepository.findByCourseNameAndDuration("%"+courseName+"%", duration);
    }
}

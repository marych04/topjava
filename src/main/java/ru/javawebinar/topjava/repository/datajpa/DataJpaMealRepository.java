package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DataJpaMealRepository implements MealRepository {

    private final CrudMealRepository crudRepository;

    public DataJpaMealRepository(CrudMealRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Meal save(Meal meal, int userId) {

        return crudRepository.save(meal, userId);
    }

    @Override
    public boolean delete(int id, int userId) {

        return crudRepository.delete(id, userId) != 0;
    }

    @Override
    public Meal get(int id, int userId) {

        return crudRepository.findMealByIdAndUserId(id, userId);
    }

    @Override
    public List<Meal> getAll(int userId) {
        return crudRepository.findAllByUserId(userId);
    }

    @Override
    public List<Meal> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return crudRepository.findAllByDateTimeBetweenAndUserId(startDateTime, endDateTime, userId);
    }
}

package ru.parallelProject.parallel.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import ru.parallelProject.parallel.model.Meal;
import ru.parallelProject.parallel.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.List;

public class DateJpaMealRepositoryImpl implements MealRepository {

    @Autowired
    CrudMealRepository crudRepository;

    @Override
    public Meal save(Meal meal, int userId) {
        return meal;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public Meal get(int id, int userId) {
        return null;
    }

    @Override
    public List<Meal> getAll(int userId) {
        return null;
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}

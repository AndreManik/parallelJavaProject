package ru.parallelProject.parallel.service;

import ru.parallelProject.parallel.model.Meal;
import ru.parallelProject.parallel.repository.UserMealRepository;

import java.time.LocalTime;
import java.util.Collection;

public interface UserMealService {

    Meal get(int id, int userId);

    void delete(int id, int userId);

    Collection<Meal> getBetween(LocalTime startTime, LocalTime endTime, int userId);

    Collection<Meal> getAll(int userId);

    void deleteAll(int userId);

    Meal update(Meal meal, int userId);

    Meal save(Meal meal, int userId);


}

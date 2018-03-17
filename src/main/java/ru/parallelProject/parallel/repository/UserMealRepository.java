package ru.parallelProject.parallel.repository;

import ru.parallelProject.parallel.model.Meal;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

public interface UserMealRepository {
    Meal save(Meal meal, int userId);

    boolean delete (int id, int userId);

    Meal get (int id, int userId);

    Collection<Meal> getAll(int userId);

    Collection<Meal> getBetween(LocalTime startDate, LocalTime endDate, int userId);

}

package ru.parallelProject.parallel.repository;

import ru.parallelProject.parallel.model.Meal;

import java.util.List;

public interface UserMealRepository {
    Meal save(Meal meal);

    void delete (int id);

    Meal get (int id);

    List<Meal> getAll();

}

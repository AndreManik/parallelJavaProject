package ru.parallelProject.parallel.service;

import ru.parallelProject.parallel.model.Meal;
import ru.parallelProject.parallel.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface MealService {

    Meal get(int id, int userId) throws NotFoundException;
    void delete(int id, int userId) throws NotFoundException;
    List<Meal> getBetweenDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);
    List<Meal> getAll(int userId);
    Meal update(Meal meal, int userId) throws NotFoundException;
    Meal create(Meal meal, int userId);

    default List<Meal> getBetweenDates(LocalDate startDate, LocalDate endDate, int userId) {
        return getBetweenDateTime(LocalDateTime.of(startDate, LocalTime.MIN), LocalDateTime.of(endDate, LocalTime.MAX), userId);
    }
}

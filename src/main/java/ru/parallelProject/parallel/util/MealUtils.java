package ru.parallelProject.parallel.util;

import ru.parallelProject.parallel.model.Meal;
import ru.parallelProject.parallel.model.MealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class MealUtils {

    public static void main(String[] args) {
        List<Meal> mealList = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,10,20), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,13,20), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,20,20), "Ужин", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,10,20), "Завтрак", 2000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,13,20), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,20,20), "Ужин", 510)
        );

        getFilteredMealWithExceeded(mealList, LocalTime.of(7,0), LocalTime.of(12,0), 2000);
    }

    private static List<MealWithExceed> getFilteredMealWithExceeded(List<Meal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        System.out.println("new Branch");
        return null;
    }
}

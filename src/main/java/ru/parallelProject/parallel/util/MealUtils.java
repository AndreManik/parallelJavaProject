package ru.parallelProject.parallel.util;

import ru.parallelProject.parallel.model.Meal;
import ru.parallelProject.parallel.model.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MealUtils {

    public static List<Meal> MEAL_LIST = Arrays.asList(
            new Meal(LocalDateTime.of(2015, Month.MAY, 30,10,20), "Завтрак", 1000),
            new Meal(LocalDateTime.of(2015, Month.MAY, 30,13,20), "Обед", 500),
            new Meal(LocalDateTime.of(2015, Month.MAY, 30,20,20), "Ужин", 500),
            new Meal(LocalDateTime.of(2015, Month.MAY, 31,10,20), "Завтрак", 2000),
            new Meal(LocalDateTime.of(2015, Month.MAY, 31,13,20), "Обед", 500),
            new Meal(LocalDateTime.of(2015, Month.MAY, 31,20,20), "Ужин", 510)
    );

    public static void main(String[] args) {

        List<MealWithExceed> filteredMealWithExceeded = getFilteredWithExceeded(MEAL_LIST, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        filteredMealWithExceeded.forEach(meal -> System.out.println(meal));
    }

    public static List<MealWithExceed> getWithExceeder(List<Meal> mealList, int caloriesPerDay) {
        return getFilteredWithExceeded(mealList, LocalTime.MIN, LocalTime.MAX, caloriesPerDay);
    }

    private static List<MealWithExceed> getFilteredWithExceeded(List<Meal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        Map<LocalDate, Integer> caloriesSumPerDay = mealList.stream().collect(Collectors.groupingBy(meal -> meal.getDate(),
                                                                     Collectors.summingInt(meal -> meal.getCalories())));

        List<MealWithExceed> mealWithExceedList = mealList.stream().filter(meal -> TimeUtil.isBetween(meal.getTime(), startTime, endTime))
                .map(meal -> createWithExceed(meal,caloriesSumPerDay.get(meal.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());
        return mealWithExceedList;
    }

    private static MealWithExceed createWithExceed(Meal meal, boolean exceeded) {
        return new MealWithExceed(meal.getDateTime(), meal.getDescription(), meal.getCalories(), exceeded);
    }
}

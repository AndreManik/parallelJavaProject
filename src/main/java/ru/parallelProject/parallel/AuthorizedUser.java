package ru.parallelProject.parallel;

import ru.parallelProject.parallel.util.MealUtils;

public class AuthorizedUser {
    public static int id() {
        return 1;
    }
    public static int getCaloriesPerDay() {
        return MealUtils.DEFAULT_CALORIES_PER_DAY;
    }
}

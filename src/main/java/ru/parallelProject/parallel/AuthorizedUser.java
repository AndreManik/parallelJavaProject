package ru.parallelProject.parallel;

import static ru.parallelProject.parallel.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;

public class AuthorizedUser {
    private static int id = 1;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

    public static int getCaloriesPerDay() {
        return DEFAULT_CALORIES_PER_DAY;
    }
}
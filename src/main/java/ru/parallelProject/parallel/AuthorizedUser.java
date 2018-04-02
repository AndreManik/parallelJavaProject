package ru.parallelProject.parallel;

import ru.parallelProject.parallel.model.AbstractBaseEntity;
import ru.parallelProject.parallel.util.MealsUtil;

public class AuthorizedUser {

    private static int id = AbstractBaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

    public static int getCaloriesPerDay() {
        return MealsUtil.DEFAULT_CALORIES_PER_DAY;
    }
}

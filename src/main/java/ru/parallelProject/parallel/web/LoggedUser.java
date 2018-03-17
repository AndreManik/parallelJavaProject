package ru.parallelProject.parallel.web;

import ru.parallelProject.parallel.model.Role;
import ru.parallelProject.parallel.util.MealUtils;

import java.util.Collections;
import java.util.Set;

public class LoggedUser {
    protected int id = 0;
    protected Set<Role> roles = Collections.singleton(Role.ROLE_USER);
    protected boolean enabled = true;
    protected static int caloriesPerDay = MealUtils.DEFAULT_CALORIES_PER_DAY;

    private static LoggedUser LOGGED_USER = new LoggedUser();

    public static LoggedUser get() {
        return LOGGED_USER;
    }

    public static int getId() {
        return get().id;
    }

    public Set<Role> getAuthorities() {
        return roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public static int getCaloriesPerDay() {
        return caloriesPerDay;
    }
}

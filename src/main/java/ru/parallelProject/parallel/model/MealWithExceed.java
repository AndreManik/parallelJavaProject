package ru.parallelProject.parallel.model;

import java.time.LocalDateTime;

public class MealWithExceed {
    protected final LocalDateTime dateTime;
    protected final String description;
    protected final int calories;
    protected final boolean exceed;

    public MealWithExceed(LocalDateTime dateTime, String description, int calories, boolean exceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }
}

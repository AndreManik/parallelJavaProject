package ru.parallelProject.parallel.model;

import java.time.LocalDateTime;

public class Meal {
    protected final LocalDateTime dateTime;
    protected final String description;
    protected final int calories;

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }
}

package ru.parallelProject.parallel.repository;

import ru.parallelProject.parallel.model.Meal;
import ru.parallelProject.parallel.util.TimeUtil;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryUserMealRepositoryImpl implements UserMealRepository {

    public static final Comparator<Meal> MEAL_COMPARATOR = (m1, m2) -> m2.getDateTime().compareTo(m1.getDateTime());

    private Map<Integer, Map<Integer, Meal>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    private static final int USER_ID = 1;
    private static final int ADMIN_ID = 2;

    {
        save(new Meal(LocalDateTime.now(), "завтрак", 500), USER_ID);

        save(new Meal(LocalDateTime.now(), "обед", 510), ADMIN_ID);
    }

    @Override
    public Meal save(Meal meal, int userId) {
        Integer mealId = meal.getId();
        if (meal.isNew()) {
            mealId = counter.incrementAndGet();
            meal.setId(mealId);
        } else if (get(mealId, userId) == null) {
            return null;
        }

        Map<Integer, Meal> meals = repository.computeIfAbsent(userId, ConcurrentHashMap::new);
        meals.put(mealId, meal);
        return meal;
    }

    @Override
    public Meal get(int mealId, int userId) {
        Map<Integer, Meal> userMeals = repository.get(userId);
        return userMeals == null ? null : userMeals.get(mealId);
    }

    @Override
    public Collection<Meal> getAll(int userId) {
        return repository.get(userId).values().stream().sorted(MEAL_COMPARATOR).collect(Collectors.toList());
    }

    @Override
    public boolean delete(int id, int userId) {
        if (get(id, userId) != null) {
            return repository.remove(id) != null;
        }
        return false;
    }

    @Override
    public Collection<Meal> getBetween(LocalTime startDate, LocalTime endDate, int userId) {
        return getAll(userId).stream()
                             .filter(m -> TimeUtil.isBetween(m.getTime(), startDate, endDate))
                             .sorted(MEAL_COMPARATOR)
                             .collect(Collectors.toList());
    }
}

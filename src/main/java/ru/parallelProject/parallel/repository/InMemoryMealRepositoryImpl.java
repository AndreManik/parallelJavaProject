package ru.parallelProject.parallel.repository;

import ru.parallelProject.parallel.model.Meal;
import ru.parallelProject.parallel.model.MealWithExceed;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMealRepositoryImpl implements MealRepository {

    Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    AtomicInteger counter = new AtomicInteger(0);

    {
        save(new Meal(LocalDateTime.of(2015, Month.MAY, 30,10,20), "Завтрак", 1000));
        save(new Meal(LocalDateTime.of(2015, Month.MAY, 30,13,20), "Обед", 500));
        save(new Meal(LocalDateTime.of(2015, Month.MAY, 30,20,20), "Ужин", 500));
        save(new Meal(LocalDateTime.of(2015, Month.MAY, 31,10,20), "Завтрак", 2000));
        save(new Meal(LocalDateTime.of(2015, Month.MAY, 31,13,20), "Обед", 500));
        save(new Meal(LocalDateTime.of(2015, Month.MAY, 31,20,20), "Ужин", 510));
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getId(), meal);
            return meal;
        }
        return repository.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Meal> getAll() {
        return repository.values();
    }
}

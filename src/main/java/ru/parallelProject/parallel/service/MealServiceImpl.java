package ru.parallelProject.parallel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.parallelProject.parallel.model.Meal;
import ru.parallelProject.parallel.repository.MealRepository;
import ru.parallelProject.parallel.util.exception.NotFoundException;
import static ru.parallelProject.parallel.util.ValidationUtil.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository repository;

    @Autowired
    public MealServiceImpl(MealRepository repository) {
        this.repository = repository;
    }

    @Override
    public Meal get(int id, int userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    @Override
    public List<Meal> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return repository.getBetween(startDateTime, endDateTime, userId);
    }

    @Override
    public List<Meal> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public Meal update(Meal meal, int userId) {
        return checkNotFoundWithId(repository.save(meal, userId), meal.getId());
    }

    @Override
    public Meal create(Meal meal, int userId) {
        return repository.save(meal, userId);
    }
}

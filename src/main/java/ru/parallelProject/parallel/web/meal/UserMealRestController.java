package ru.parallelProject.parallel.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.parallelProject.parallel.model.Meal;
import ru.parallelProject.parallel.model.MealWithExceed;
import ru.parallelProject.parallel.service.UserMealService;
import ru.parallelProject.parallel.util.MealUtils;
import ru.parallelProject.parallel.web.LoggedUser;

import java.time.LocalTime;
import java.util.Collection;

public class UserMealRestController {
    private static final Logger LOG = LoggerFactory.getLogger(UserMealRestController.class);

    @Autowired
    private UserMealService service;

    public Meal get(int id) {
        int userId = LoggedUser.getId();
        LOG.info(String.format("Get meal {%s} for user {%s}", id, userId));
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = LoggedUser.getId();
        LOG.info("delete meal {} for user {}", id, userId);
        service.delete(id, userId);
    }

    public Collection<MealWithExceed> getAll() {
        int userId = LoggedUser.getId();
        LOG.info("getAll for user {}", userId);
        return MealUtils.getMealWithExceeded(service.getAll(userId), LoggedUser.getCaloriesPerDay());
    }

    public void deleteAll() {
        int userId = LoggedUser.getId();
        LOG.info("deleteAll for user {}", userId);
        service.deleteAll(userId);
    }

    public void update(Meal meal) {
        int userId = LoggedUser.getId();
        LOG.info("update {} for user {}", meal, userId);
        service.update(meal, userId);
    }

    public Meal create(Meal meal) {
        int userId = LoggedUser.getId();
        LOG.info("create {} for user {}", meal, userId);
        return service.save(meal, userId);
    }

    public Collection<Meal> getBetween(LocalTime startTime, LocalTime endTime) {
        int userId = LoggedUser.getId();
        LOG.info("get between {} and {} for user {}", startTime, endTime, userId );
        return service.getBetween(startTime, endTime,userId);
    }

}

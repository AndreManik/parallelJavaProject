package ru.parallelProject.parallel.repository.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.parallelProject.parallel.model.Meal;
import ru.parallelProject.parallel.service.MealService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql",  config = @SqlConfig(encoding = "UTF-8"))
public class JpaMealRepositoryTest {

    @Autowired
    MealService service;

    @Test
    public void save() {
        service.create(new Meal(LocalDateTime.now(), "added meal", 20), 100000);
    }

    @Test
    public void delete() {
        service.delete(100002, 100000);
    }

    @Test
    public void get() {
        service.get(100003, 100000);
    }

    @Test
    public void getAll() {
        service.getAll(100000);
    }

    @Test
    public void getBetween() {
        service.getBetweenDates(LocalDate.of(2015,05,30),
                LocalDate.of(2015,06,01), 100000);
    }
}
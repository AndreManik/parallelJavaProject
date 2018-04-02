package ru.parallelProject.parallel.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.parallelProject.parallel.repository.MealRepository;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceImplTest {

    @Autowired
    MealService service;

    @Test
    public void get() {
        service.get(100008, 100001);
    }

    @Test
    public void delete() {
    }

    @Test
    public void getBetweenDateTime() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void update() {
    }

    @Test
    public void create() {
    }
}
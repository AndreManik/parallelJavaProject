package ru.parallelProject.parallel.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.parallelProject.parallel.model.Role;
import ru.parallelProject.parallel.model.User;

import java.util.Collections;
import java.util.Date;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Autowired
    UserService service;

    @Test
    public void create() {
        User newUser = new User(null, "New", "new@gmail.com", "newPass", 1555, false, new Date(), Collections.singleton(Role.ROLE_USER));
        User created = service.create(newUser);
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }

    @Test
    public void getByEmail() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getAll() {
    }
}
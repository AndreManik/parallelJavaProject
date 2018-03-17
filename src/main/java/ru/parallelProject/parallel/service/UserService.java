package ru.parallelProject.parallel.service;

import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.util.exception.NotFoundException;

import java.util.Collection;
import java.util.List;

public interface UserService {

    User create(User user);
    //User save(User user);

    void delete(int id) throws NotFoundException;
    User get(int id) throws NotFoundException;
    User getByEmail(String email) throws NotFoundException;
    Collection<User> getAll();
    void update(User user) throws NotFoundException;
}

package ru.parallelProject.parallel.repository;

import ru.parallelProject.parallel.model.User;

import java.util.Collection;
import java.util.List;

public interface UserRepository {

    User save(User user);
    boolean delete(int id);
    User get(int id);
    User getByEmail(String email);
    Collection<User> getAll();
}

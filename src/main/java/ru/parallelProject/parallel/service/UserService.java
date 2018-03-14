package ru.parallelProject.parallel.service;

import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.util.exception.NotFoundException;

import java.util.List;

public interface UserService {
    public User save(User user);
    public void delete(int id) throws NotFoundException;
    public User get(int id) throws NotFoundException;
    public User getByEmail(String email) throws NotFoundException;
    public List<User> getAll();
    public void update(User user) throws NotFoundException;
}

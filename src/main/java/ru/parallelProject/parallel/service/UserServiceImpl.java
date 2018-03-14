package ru.parallelProject.parallel.service;

import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.repository.UserRepository;
import ru.parallelProject.parallel.util.exception.NotFoundException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public User get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User user) throws NotFoundException {

    }
}

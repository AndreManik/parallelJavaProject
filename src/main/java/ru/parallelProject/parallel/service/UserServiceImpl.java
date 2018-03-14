package ru.parallelProject.parallel.service;

import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.repository.UserRepository;
import ru.parallelProject.parallel.util.exception.NotFoundException;

import java.util.List;

import static ru.parallelProject.parallel.util.ValidationUtil.checkNotFound;
import static ru.parallelProject.parallel.util.ValidationUtil.checkNotFoundWithId;

public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return checkNotFound(repository.getByEmail(email), "email = " + email);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(User user) throws NotFoundException {
        checkNotFoundWithId(repository.save(user), user.getId());
    }
}

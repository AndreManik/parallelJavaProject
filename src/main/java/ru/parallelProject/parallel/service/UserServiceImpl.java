package ru.parallelProject.parallel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.repository.UserRepository;
import ru.parallelProject.parallel.util.ValidationUtil;
import ru.parallelProject.parallel.util.exception.NotFoundException;

import ru.parallelProject.parallel.util.ValidationUtil.*;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void delete(int id) throws NotFoundException {
        ValidationUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return ValidationUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Assert.notNull(email, "email must not be null");
        return ValidationUtil.checkNotFound(repository.getByEmail(email), email);
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        ValidationUtil.checkNotFoundWithId(repository.save(user), user.getId());
    }

    @Cacheable("users")
    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}

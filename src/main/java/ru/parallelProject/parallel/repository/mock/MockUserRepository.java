package ru.parallelProject.parallel.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.repository.UserRepository;

import java.util.List;

@Repository
public class MockUserRepository implements UserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(MockUserRepository.class);

    @Override
    public User save(User user) {
        LOG.info("Save {}" + user);
        return user;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("Delete {}" + id);
        return true;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }


}

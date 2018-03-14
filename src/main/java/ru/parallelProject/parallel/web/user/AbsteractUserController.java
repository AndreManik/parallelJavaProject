package ru.parallelProject.parallel.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.service.UserService;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static ru.parallelProject.parallel.util.ValidationUtil.assureIdConsistent;
import static ru.parallelProject.parallel.util.ValidationUtil.checkNew;

public abstract class AbsteractUserController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    private UserService service;

    public List<User> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        LOG.info("get {}", id);
        return service.get(id);
    }

    public User create(User user) {
        LOG.info("create {}", user);
        checkNew(user);
        return service.create(user);
    }

    public void delete(int id) {
        LOG.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user, int id) {
        LOG.info("update {} with id={}", user, id);
        assureIdConsistent(user, id);
        service.update(user);
    }

    public User getByMail(String mail) {
        LOG.info("getByEmail {}", mail);
        return service.getByEmail(mail);
    }
}

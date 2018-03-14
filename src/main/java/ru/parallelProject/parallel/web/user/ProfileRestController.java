package ru.parallelProject.parallel.web.user;

import ru.parallelProject.parallel.AuthorizedUser;
import ru.parallelProject.parallel.model.User;

public class ProfileRestController extends AbsteractUserController {

    public User get(int id) {
        return super.get(AuthorizedUser.id());
    }

    public void delete() {
        super.delete(AuthorizedUser.id());
    }

    public void update(User user) {
        super.update(user, AuthorizedUser.id());
    }
}

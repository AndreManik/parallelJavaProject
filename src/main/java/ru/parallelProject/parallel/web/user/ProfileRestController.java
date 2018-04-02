package ru.parallelProject.parallel.web.user;

import org.springframework.stereotype.Controller;
import ru.parallelProject.parallel.AuthorizedUser;
import ru.parallelProject.parallel.model.User;

@Controller
public class ProfileRestController extends AbstractUserController {

    public User get() {
        return super.get(AuthorizedUser.id());
    }

    public void delete() {
        super.delete(AuthorizedUser.id());
    }

    public void update(User user) {
        super.update(user, AuthorizedUser.id());
    }
}

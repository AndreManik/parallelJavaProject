package ru.parallelProject.parallel.web.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.parallelProject.parallel.model.Role;
import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.util.exception.NotFoundException;
import ru.parallelProject.parallel.web.user.AdminRestController;


@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAdminSpringMockTest {

    @Autowired
    private AdminRestController controller;


    @Test
    public void testCreate() throws Exception {
        controller.create(new User(null, "Name", "email", "password", Role.ROLE_USER));
    }

    @Test
    public void testDelete() throws Exception {
        controller.delete(7);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() {
        controller.delete(0);
    }
}

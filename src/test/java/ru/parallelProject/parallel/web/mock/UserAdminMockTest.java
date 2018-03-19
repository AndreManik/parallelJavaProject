package ru.parallelProject.parallel.web.mock;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.parallelProject.parallel.model.Role;
import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.repository.mock.InMemoryUserRepositoryImpl;
import ru.parallelProject.parallel.util.exception.NotFoundException;
import ru.parallelProject.parallel.web.user.AdminRestController;

import java.util.Arrays;

public class UserAdminMockTest {
    private static ConfigurableApplicationContext appCtx;
    private static AdminRestController controller;

    @BeforeClass
    public static void beforeClass() {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
        controller = appCtx.getBean(AdminRestController.class);
    }

    @AfterClass
    public static void afterClass() {
        appCtx.close();
    }

    @Before
    public void setUp() {
        InMemoryUserRepositoryImpl repository = appCtx.getBean(InMemoryUserRepositoryImpl.class);
        repository.init();
    }

    @Test
    public void testCreate() throws Exception {
        controller.create(new User(null, "userName", "email", "password", Role.ROLE_ADMIN));
    }

    @Test
    public void testDelete() throws Exception {
        controller.delete(1);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        controller.delete(0);
    }
}

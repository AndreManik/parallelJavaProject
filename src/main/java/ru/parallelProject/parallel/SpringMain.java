package ru.parallelProject.parallel;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.parallelProject.parallel.model.Role;
import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.repository.UserRepository;
import ru.parallelProject.parallel.service.UserService;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

//        UserRepository userRepository = (UserRepository) appCtx.getBean("mockUserRepository");

        UserRepository userRepository;

        userRepository = appCtx.getBean(UserRepository.class);
        userRepository.getAll();

        UserService userService = appCtx.getBean(UserService.class);
        userService.create(new User(null, "userName", "email", "password", Role.ROLE_ADMIN));
        System.out.println(userService.getAll());

        appCtx.close();
    }
}

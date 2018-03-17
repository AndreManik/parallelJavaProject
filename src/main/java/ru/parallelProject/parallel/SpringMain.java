package ru.parallelProject.parallel;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.parallelProject.parallel.repository.UserRepository;
import ru.parallelProject.parallel.repository.InMemoryUserRepository;

import java.util.Arrays;

public class SpringMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));

        InMemoryUserRepository mockUserRepository = (InMemoryUserRepository) appContext.getBean("inMemoryUserRepository");
        mockUserRepository = appContext.getBean(InMemoryUserRepository.class);

        UserRepository userRepository = appContext.getBean(UserRepository.class);
        userRepository.getAll();


        appContext.close();
    }
}

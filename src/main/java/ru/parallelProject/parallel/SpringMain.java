package ru.parallelProject.parallel;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.parallelProject.parallel.repository.mock.MockUserRepository;

import java.util.Arrays;

public class SpringMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));

        MockUserRepository mockUserRepository = (MockUserRepository) appContext.getBean("mockUserRepository");
        mockUserRepository = appContext.getBean(MockUserRepository.class);
        System.out.println(mockUserRepository.getAll());
        appContext.close();
    }
}

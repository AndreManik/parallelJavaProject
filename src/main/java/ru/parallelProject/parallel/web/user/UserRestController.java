package ru.parallelProject.parallel.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.repository.UserRepository;
import ru.parallelProject.parallel.service.UserService;
import ru.parallelProject.parallel.util.exception.NotFoundException;

import java.util.List;

@Controller
public class UserRestController{
    @Autowired
    private UserService service;


}

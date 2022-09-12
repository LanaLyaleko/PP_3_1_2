package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;


@Component
public class DataInitializer {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void init()

        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");
        roleService.saveRole(role1);
        roleService.saveRole(role2);

        User user = new User();
        user.setName("Bob");
        user.setSurname("Johnson");
        user.setEmail("mail1@gmail.com");
        user.setPassword("bob");
        user.addRole(role1);

        User user2 = new User();
        user2.setName("Sam");
        user2.setSurname("Dobkins");
        user2.setEmail("mail2@gmail.com");
        user2.setPassword("sam");
        user2.addRole(role1);
        user2.addRole(role2);

        User user3 = new User();
        user3.setName("Mike");
        user3.setSurname("Trump");
        user3.setEmail("mail3@gmail.com");
        user3.setPassword("mike");
        user3.addRole(role2);

        User user4 = new User();
        user4.setName("Ronald");
        user4.setSurname("Mars");
        user4.setEmail("mail4@gmail.com");
        user4.setPassword("ronald");
        user4.addRole(role2);

        User user5 = new User();
        user5.setName("Donald");
        user5.setSurname("Mask");
        user5.setEmail("mail5@gmail.com");
        user5.setPassword("donald");
        user5.addRole(role1);
        user5.addRole(role2);

        userService.saveUser(user);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
        userService.saveUser(user5);
    }
}

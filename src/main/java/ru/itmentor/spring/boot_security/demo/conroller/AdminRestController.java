package ru.itmentor.spring.boot_security.demo.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AdminRestController {
    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/users")
    public List<User> showAllUsersWithRoles() {
        return userService.getAllUsersWithRoles();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserWithRolesById(id);
    }

    @PostMapping("/new")
    public User create(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PatchMapping("/update")
    public User update(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "User " + id + " deleted";
    }
}
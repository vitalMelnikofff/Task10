package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;


@Service
public interface UserService {
    List<User> getAllUsers();

    void updateUser(User user);

    void removeUser(Long id);

    User getUserById(Long id);

    void saveUser(User user, Set<Long> roleIds);

    User findByName(String username);
    Set<Role> findAllRoles();

}
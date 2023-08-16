package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.dao.UserDao;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;


@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao ) {
        this.userDao = userDao;
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);

    }

    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);

    }
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }



    @Override
    public User saveUser(User user) {
        userDao.save(user);
        return user;
    }

    @Override
    public User findByName(String username) {
        return userDao.findByUserName(username);
    }
}






package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.dao.UserDao;
import ru.itmentor.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import java.util.List;


@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;
    private final EntityManager entityManager;

    @Autowired
    public UserServiceImp(UserDao userDao, EntityManager entityManager) {
        this.userDao = userDao;
        this.entityManager = entityManager;
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
        return userDao.getUserWithRolesById(id);
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
    @Override
    public User getUserWithRolesById(Long id) {
        return entityManager.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<User> getAllUsersWithRoles() {
        return entityManager.createQuery("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles", User.class)
                .getResultList();
    }

    }







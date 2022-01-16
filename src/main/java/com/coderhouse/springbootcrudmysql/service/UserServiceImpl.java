package com.coderhouse.springbootcrudmysql.service;

import com.coderhouse.springbootcrudmysql.model.User;
import com.coderhouse.springbootcrudmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public User updateUserById(User user, Long id) {
        user.setId(id);
        return repository.save(user);
    }

    @Override
    public void delete(User user, Long id) {
        user.setId(id);
        repository.delete(user);
    }

    @Override
    public User findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<User> findByAgeGreaterThan(int age) {
        return repository.findByAgeGreaterThan(age);
    }

    @Override
    public List<User> findAll() {
        List<User> userList =  new ArrayList<>();
        repository.findAll().forEach(userList::add);
        return userList;
    }
}

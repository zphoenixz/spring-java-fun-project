package com.coderhouse.springbootcrudmysql.controller;

import com.coderhouse.springbootcrudmysql.model.User;
import com.coderhouse.springbootcrudmysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coder-house")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/user/all")
    public List<User> findUsers() {
        return service.findAll();
    }

    @GetMapping("/user")
    public User findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @PutMapping("/user/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody  User user) {
        return service.updateUserById(user, id);
    }

}

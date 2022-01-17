package com.coderhouse.springbootcrudmysql.controller;

import com.coderhouse.springbootcrudmysql.handle.FirstApplicationException;
import com.coderhouse.springbootcrudmysql.model.User;
import com.coderhouse.springbootcrudmysql.service.UserService;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/coder-house")
public class UserController {
    Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    UserService service;

    @PostMapping("/user")//@Validated
    public User createUser(@RequestBody User user) {
        logger.info("POST Create user");
        return service.createUser(user);
    }

    @GetMapping("/user/all")
    public List<User> findUsers() {
        return service.findAll();
    }

    @GetMapping("/user")
    public ResponseEntity<User> findByName(@RequestParam String name) {
        logger.info("GET users");
//        try{
            return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
//        } catch (FirstApplicationException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//        return service.findByName(name);
    }

    @PutMapping("/user/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody  User user) {
        logger.info("GET Request user by id " + id);
        return service.updateUserById(user, id);
    }

}

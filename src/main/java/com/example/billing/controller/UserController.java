package com.example.billing.controller;

import com.example.billing.model.User;
import com.example.billing.service.UserService;
import fj.data.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/user/{id}")
    public User getById(@PathVariable String id) throws SQLException {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody User user) {

        Either<String, User> save = userService.save(user);
        if (save.isLeft()){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        else return ResponseEntity.ok(user);
    }

}

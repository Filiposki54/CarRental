package com.pjatk.carrental.controller;

import com.pjatk.carrental.model.User;
import com.pjatk.carrental.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("userList")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}

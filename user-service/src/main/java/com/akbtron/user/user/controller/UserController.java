package com.akbtron.user.user.controller;

import com.akbtron.user.user.VO.ResponseTemplate;
import com.akbtron.user.user.entity.User;
import com.akbtron.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long userId){
        return userService.getUser(userId);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId) {

        return userService.getUserWithDepartment(userId);

    }
}

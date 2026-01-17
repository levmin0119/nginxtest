package com.levmin.nginxtest.controller;

import com.levmin.nginxtest.entry.UserAccount;
import com.levmin.nginxtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nginx")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public boolean saveUser(@RequestBody UserAccount userAccount) {
        return userService.saveUser(userAccount);
    }

    @PostMapping("/queryUser")
    public UserAccount queryUser(@RequestBody UserAccount userAccount) {
        return userService.selectUser(userAccount);
    }
}

package com.guoshouxiang.nest.demo.api.v1.controllers;


import com.guoshouxiang.nest.demo.appservice.contract.UserDto;
import com.guoshouxiang.nest.demo.appservice.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public void create(String userName, String pwd) {
        userService.create(userName, pwd);
    }


    @GetMapping("/get")
    public UserDto get(String id) {
        UserDto user = userService.get(id);
        return user;
    }
    @GetMapping("/list")
    public List<UserDto> list(int pageIndex,int pageSize) {
        return userService.query(pageIndex,pageSize);
    }
}


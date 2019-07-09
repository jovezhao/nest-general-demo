package com.guoshouxiang.nest.demo.api.v1.controllers;

import com.guoshouxiang.nest.demo.appservice.contract.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("version")
public class TestController {

    @Autowired
    private UserService userService;


    @ApiOperation("version")
    @GetMapping("/version")
    public String hello() {
        return "v1";
    }
}

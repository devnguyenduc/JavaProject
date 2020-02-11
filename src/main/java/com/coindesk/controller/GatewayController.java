package com.coindesk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
    @GetMapping("/hello")
    public String Hello(){
        return "Hello world";
    }

    @GetMapping("/admin")
    public String Admin(){
        return "Hello Admin";
    }

    @GetMapping("/user")
    public String User(){
        return "Hello User";
    }
}

package com.levmin.nginxtest.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nginx")
public class HelloNginx {

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String nginxTest() {
        System.out.println("test github!!!");
        return ("nginx test" + port);
    }
}

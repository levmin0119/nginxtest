package com.levmin.nginxtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.levmin.nginxtest.mapper")
public class NginxtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(NginxtestApplication.class, args);
    }

}

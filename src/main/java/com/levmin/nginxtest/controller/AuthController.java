package com.levmin.nginxtest.controller;

import com.levmin.nginxtest.config.JwtUtil;
import com.levmin.nginxtest.entry.LoginDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginDto dto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(), dto.getPassword())
        );

        String token = jwtUtil.genToken(dto.getUsername());

        return Map.of(
                "token", token,
                "type", "Bearer"
        );
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        redisTemplate.opsForValue()
                .set("blacklist:" + token, "1", 30, TimeUnit.MINUTES);
    }



    @GetMapping("/user/info")
    public Object info(Authentication authentication) {

        System.out.println("aaaaa");
        return authentication;
    }

}


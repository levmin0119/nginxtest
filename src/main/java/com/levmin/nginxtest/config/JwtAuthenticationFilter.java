package com.levmin.nginxtest.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("👉 JwtFilter 进入：" + request.getRequestURI());

        try {
            String header = request.getHeader("Authorization");
            System.out.println("Authorization = " + header);

            if (header != null && header.startsWith("Bearer ")) {
                String token = header.substring(7);
                System.out.println("Token = " + token);

                // 黑名单校验
                if (Boolean.TRUE.equals(redisTemplate.hasKey("blacklist:" + token))) {
                    System.out.println("❌ token 在黑名单");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }

                String username = jwtUtil.getUserName(token);
                System.out.println("解析出的 username = " + username);

                List<SimpleGrantedAuthority> authorities =
                        List.of(new SimpleGrantedAuthority("ROLE_USER"));

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                username, null, authorities
                        );

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);

                System.out.println("✅ SecurityContext 已设置");
            }

            filterChain.doFilter(request, response);

        } catch (Exception e) {
            e.printStackTrace(); // ⭐ 关键
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}





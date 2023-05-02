//package com.example.demo.services;
//
//
//import com.example.demo.model.UserInfo;
//import com.example.demo.repository.UserInfoRepository;
//import io.jsonwebtoken.Jwts;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Optional;
//
//@Component
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//    private String jwtSigningKey = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";
//
//    @Autowired
//    UserInfoRepository userInfoRepository;
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//            validateToken(request);
//        }
//
//
//    @Bean
//    public UserInfo validateToken(HttpServletRequest request) {
//        final String authorizationHeader = request.getHeader("Authorization");
//        String jwt = authorizationHeader.substring(7);
//        var parser = Jwts.parserBuilder().setSigningKey(jwtSigningKey).build().parse(jwt);
//        String body = parser.getBody().toString();
//        String name = body.substring(5, body.length() - 1);
//        System.out.println(name);
//        Optional<UserInfo> user = userInfoRepository.findByName(name);
//        if (user.isPresent()) {
//            return user.get();
//        } else {
//            throw new RuntimeException("Object is null");
//        }
//    }
//}
//
//

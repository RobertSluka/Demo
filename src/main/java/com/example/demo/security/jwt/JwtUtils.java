package com.example.demo.security.jwt;

import com.example.demo.model.UserInfo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class JwtUtils {
    private String jwtSigningKey = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";



    public String createToken(UserInfo userInfo) {
        var token = Jwts.builder()
                .setSubject(userInfo.getName())
                .signWith(SignatureAlgorithm.HS256, jwtSigningKey).compact();
//        validateToken(token);
        return token;
    }


}

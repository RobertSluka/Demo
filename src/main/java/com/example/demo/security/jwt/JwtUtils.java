package com.example.demo.security.jwt;

import com.example.demo.model.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
    private String secret = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";

    public String createToken(UserInfo userInfo) {
        var token = Jwts.builder()
                .setSubject(userInfo.getName())
                .signWith(SignatureAlgorithm.HS256, secret).compact();
        return token;
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
        }
    }
}

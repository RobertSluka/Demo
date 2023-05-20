package com.example.demo.security.jwt;

import com.example.demo.database.DataAccessException;
import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class JwtUtils {

    @Autowired
    UserInfoRepository repo;

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private static final String secret = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";

    public String createToken(UserInfo userInfo) {
        var token = Jwts.builder()
                .setSubject(userInfo.getName())
                .signWith(SignatureAlgorithm.HS256, secret).compact();
        return token;
    }

    public static String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateUserIfExists(String name) throws DataAccessException {
        Optional<UserInfo> userList = repo.findByName(name);

        if (userList.isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("User with this name doesn't exist");
        }

        return true;
    }

    public boolean validateTokenByName(String name) throws DataAccessException {
        Optional<UserInfo> userList = repo.findByName(name);

        if (!userList.isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("User with this name already exists");
        }

        return true;
    }
//    public boolean validateTokenById(int id) throws DataAccessException{
//        Optional<UserInfo> userList = repo.findById(id);
//        if (!userList.isEmpty()) {
//            throw new AuthenticationCredentialsNotFoundException("User with this name already exists");
//        }
//
//        return true;
//    }


    public boolean validateTokenByUser(String token) {
        try {
            String name = getUsernameFromJWT(token);

            // Validate the token based on the name
            if (name == null || name.isEmpty()) {
                throw new AuthenticationCredentialsNotFoundException("Name is missing in the JWT token");
            }
            if(!validateTokenByName(name)){
                throw new AuthenticationCredentialsNotFoundException(("User with this name already exists"));
            };

            // Verify the token signature
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

            // Retrieve the claims from the token
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

            // Check if the token has expired (if applicable)
            if (claims.getExpiration() != null && claims.getExpiration().before(new Date())) {
                throw new AuthenticationCredentialsNotFoundException("Token has expired");
            }

            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect", ex);
        }
    }
    public boolean validateUserByToken(String token) {
        try {
            String name = getUsernameFromJWT(token);

            // Validate the token based on the name
            if (name == null || name.isEmpty()) {
                throw new AuthenticationCredentialsNotFoundException("Name is missing in the JWT token");
            }
            if (!validateUserIfExists(name)) {
                throw new AuthenticationCredentialsNotFoundException(("User with this name doesn't exist"));
            }

            // Verify the token signature
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

            // Retrieve the claims from the token
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

            // Check if the token has expired (if applicable)
            if (claims.getExpiration() != null && claims.getExpiration().before(new Date())) {
                throw new AuthenticationCredentialsNotFoundException("Token has expired");
            }

            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect", ex);
        }
    }


}

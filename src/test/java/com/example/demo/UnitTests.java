package com.example.demo;

import com.example.demo.model.UserInfo;
import com.example.demo.security.jwt.JwtUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(TestConfiguration.class)
public class UnitTests {
    @Autowired
    private UserInfo userMarek;
    @Autowired
    private JwtUtils jwtUtils;




    @Test
    public void testCreateToken() {
        // arrange

        String password = "04061998"; // plaintext password
        userMarek = new UserInfo(23,"Robik", "test","robosluka11@gmail.com", "ROLE_ADMIN");
        String token = jwtUtils.createToken(userMarek);

        // act

        // assert
        assertThat(token).isNotNull();
    }
}



    // ...


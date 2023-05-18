package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

@Entity
@Data
@AllArgsConstructor
@Table(name = "userInfo")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String roles;
    public UserInfo() {
        // no-argument constructor
    }

    public String getEmail() {
        return email;
    }
}


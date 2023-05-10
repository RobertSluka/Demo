package com.example.demo.controller;

import com.example.demo.database.DataAccessException;
import com.example.demo.model.UserInfo;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

@Autowired
    private UserService service;

    @GetMapping("/private")
    public String welcome(Authentication authentication) {
        return "Welcome this endpoint is not secure ~[ " +
                getName(authentication)
                +  " ]~";
    }

    private static String getName(Authentication authentication) {
        return Optional.of(authentication.getPrincipal())
                .filter(OidcUser.class::isInstance)
                .map(OidcUser.class::cast)
                .map(OidcUser::getEmail)
                .orElseGet(authentication::getName);
    }

    @PostMapping("/new")
    public ResponseEntity<String> addNewUser(@RequestBody UserInfo userInfo){
        service.addUser(userInfo);
        return ResponseEntity.ok("User added successfully");
    }

    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteUserById(@PathVariable("id") int id) throws DataAccessException {
        String deletedUserId = Integer.toString(id);
        service.deleteUserById(id);
        return "User with ID " + deletedUserId + " deleted successfully";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> allUsers(){
        return ResponseEntity.ok("Here are all users listed: " + service.getAllUsers());
    }
    @GetMapping("/greetings")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcome() {
        System.out.println("Welcome this endpoint is not secure");
        return "Welcome this endpoint is not secure";
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> getUserById(@PathVariable int id){
        return ResponseEntity.ok("Here is the user with id of :" + service.getUserById(id));
    }

}

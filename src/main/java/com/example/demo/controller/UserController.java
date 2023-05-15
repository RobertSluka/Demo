package com.example.demo.controller;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.database.DataAccessException;
import com.example.demo.model.UserInfo;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/new")
    public ResponseEntity<String> addNewUser(@RequestBody UserInfo userInfo){
//        service.addUser(userInfo);
        return ResponseEntity.ok("User added successfully");
    }
    // login endpoint, dummy method for just retrieving a token to test frontend with
    @PostMapping("/login")
    public String login(LoginDTO loginDTO) {
        return jwtUtils.createToken(new UserInfo(1, "fero", loginDTO.getEmail(), loginDTO.getPassword(), "user"));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") int id) throws DataAccessException {
        String deletedUserId = Integer.toString(id);
        service.deleteUserById(id);
        return "User with ID " + deletedUserId + " deleted successfully";
    }

    @GetMapping("/all")
    public ResponseEntity<String> allUsers(){
        return ResponseEntity.ok("Here are all users listed: " + service.getAllUsers());
    }
    @GetMapping("/greetings")
    public String welcome() {
        System.out.println("Welcome this endpoint is not secure");
        return "Welcome this endpoint is not secure";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getUserById(@PathVariable int id){
        return ResponseEntity.ok("Here is the user with id of :" + service.getUserById(id));
    }
}

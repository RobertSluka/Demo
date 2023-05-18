package com.example.demo.controller;

import com.example.demo.database.DataAccessException;
import com.example.demo.model.UserInfo;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        String token = jwtUtils.createToken(userInfo);
        if(jwtUtils.validateTokenByUser(token)){
            service.addUser(userInfo);

            return ResponseEntity.ok().header("Authorization", "Bearer " + token).body("User added successfully");
        }else
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");

    }
    // login endpoint, dummy method for just retrieving a token to test frontend with
    @PostMapping("/login")
    public String login(@RequestBody UserInfo userInfo) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String name = userInfo.getName();

        String password = userInfo.getPassword();
        String hashedPassword = jwtUtils.hashPassword(password);

        Optional<UserInfo> retrievedUser = service.findUserByName(name);
        String retrievedUserPassword = retrievedUser.get().getPassword();


        if (retrievedUser.isPresent()) {
            UserInfo user = retrievedUser.get();

//.matches to compare password - Bcrypt generates each time uniqe password
            if (passwordEncoder.matches(password, retrievedUserPassword)) {
                return jwtUtils.createToken(new UserInfo(0, user.getName(), user.getEmail(), user.getPassword(), "ROLE_ADMIN"));
            }
        }

        return "Username or password are incorrect";
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

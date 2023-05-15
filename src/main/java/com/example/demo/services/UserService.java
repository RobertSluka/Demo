package com.example.demo.services;

import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository userRepo;

    // TODO: bcrypt password hashing
//    public String addUser(UserInfo userInfo) {
//        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
//        userRepo.save(userInfo);
////        return jwtUtils.createToken(userInfo);
//        return "Token created successfully";
//    }

    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }

    public List<UserInfo> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<UserInfo> getUserById(int id) {
        return userRepo.findById(id);
    }


    public Optional<UserInfo> findUserByEmail(String email){
        return userRepo.findByEmail(email);
    }
}

package com.example.demo.controller;

import com.example.demo.database.DataAccessException;
import com.example.demo.model.School;
import com.example.demo.DTO.SchoolDTO;
import com.example.demo.model.SchoolMapper;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/school")
public class SchoolControler {

    @Autowired
    SchoolService service;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    SchoolMapper schoolMapper;

    @GetMapping("/all")
    public List<School> getAllSchools() throws DataAccessException {
        return service.getAllSchools();
    }

    @PutMapping("/update")
    public School updateSchoolById(@RequestBody School school) throws DataAccessException {
        return service.updateSchool(school);
    }

    @PostMapping("/save")
    public School addSchool(@RequestBody SchoolDTO dto, @RequestHeader("authorization") String token) throws DataAccessException {
        // there is substring 7 because we are removing the "Bearer " part of the token
        System.out.println("token: " + token.substring(7));
        // todo: get id or userInfo from here
        jwtUtils.getUsernameFromJWT(token.substring(7));
        // TODO: get user/roles, validate access and then return 403 if not allowed or keep the commented return if allowed
//         return service.addSchool(schoolMapper.toEntity(dto));
        return new School("haha",100,"haha",1);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteSchoolById(@PathVariable("id") int id) throws DataAccessException {
        service.deleteSchoolById(id);
        return "School deleted successfully";
    }

}

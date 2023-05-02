package com.example.demo.controller;

import com.example.demo.database.DataAccessException;
import com.example.demo.model.School;
import com.example.demo.DTO.SchoolDTO;
import com.example.demo.model.SchoolMapper;
import com.example.demo.model.UserInfo;
import com.example.demo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/school")
public class SchoolControler {


    @Autowired
    private SchoolService service;

    @Autowired
    private SchoolMapper schoolMapper;
    @GetMapping("/greetings")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcome() {
        System.out.println("Welcome this endpoint is not secure");
        return "Welcome this endpoint is not secure";
    }
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

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<School> getAllSchools() throws DataAccessException {
        return service.getAllSchools();
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public School updateSchoolById(@RequestBody School school) throws DataAccessException {
        return service.updateSchool(school);
    }
    @PostMapping("/new")
    public ResponseEntity<String> addNewUser(@RequestBody UserInfo userInfo){
        service.addUser(userInfo);
        return ResponseEntity.ok("User added successfully");
    }

    @PostMapping("/save")
    public School addSchool(@RequestBody SchoolDTO dto) throws DataAccessException {
         return service.addSchool(schoolMapper.toEntity(dto));
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteSchoolById(@PathVariable("id") int id) throws DataAccessException {
        service.deleteSchoolById(id);
        return "School deleted successfully";
    }

}

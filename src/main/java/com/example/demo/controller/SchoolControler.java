package com.example.demo.controller;

import com.example.demo.database.DAOInterface;
import com.example.demo.database.DataAccessException;
import com.example.demo.model.School;
import com.example.demo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolControler {


    @Autowired
    private SchoolService service;



    @GetMapping("/school/all")
    public List<School> getAllSchools() throws DataAccessException {
        return service.getAllSchools();
    }


    @PostMapping("/school/save")
    public School addSchool(@RequestBody School school) throws DataAccessException {
         return service.addSchool(school);
    }
    @DeleteMapping("/school/delete/{id}")
    public String deletePersonById(@PathVariable("id") School id) throws DataAccessException {
        service.deleteSchoolById(id);
        return "School deleted successfully";
    }

}

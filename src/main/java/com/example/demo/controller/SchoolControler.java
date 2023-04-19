package com.example.demo.controller;

import com.example.demo.database.DataAccessException;
import com.example.demo.model.School;
import com.example.demo.DTO.SchoolDTO;
import com.example.demo.model.SchoolMapper;
import com.example.demo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SchoolControler {


    @Autowired
    private SchoolService service;

    @Autowired
    private SchoolMapper schoolMapper;


    @GetMapping("/school/all")
    public List<School> getAllSchools() throws DataAccessException {
        return service.getAllSchools();
    }

    @PutMapping("/school/update")
    public School updateSchoolById(@RequestBody School school) throws DataAccessException {
        return service.updateSchool(school);
    }


    @PostMapping("/school/save")
    public School addSchool(@RequestBody SchoolDTO dto) throws DataAccessException {
         return service.addSchool(schoolMapper.toEntity(dto));
    }
    @DeleteMapping("/school/delete/{id}")
    public String deleteSchoolById(@PathVariable("id") int id) throws DataAccessException {
        service.deleteSchoolById(id);
        return "School deleted successfully";
    }

}

package com.example.demo.controller;

import com.example.demo.DTO.SubjectDTO;
import com.example.demo.model.Subject;
import com.example.demo.model.SubjectMapper;
import com.example.demo.services.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SubjectController {
    @Autowired
    private SubjectServiceImpl service;
    @Autowired
    private SubjectMapper subjectMapper;


    @GetMapping("/subject/all")
    public List<Subject> getAll (){
        return service.getAllSubjects();
    }
    @PostMapping("/subject/save")
    public Subject save (@RequestBody SubjectDTO dto ){
        return service.addSubject(subjectMapper.toEntity(dto));
    }

    @DeleteMapping("/subject/delete/{id}")
    public String delete (@PathVariable int id){
        service.deleteSubjectById(id);
        return "Subject was deleted";
    }

    @GetMapping("/subject/{id}")
    public Subject findById(int id){
        return service.getSubjectById(id);
    }

    @PutMapping("/subject/update")
    public Subject updateSubject(@RequestBody Subject subject){
        return service.updateSubjectById(subject);
    }
}

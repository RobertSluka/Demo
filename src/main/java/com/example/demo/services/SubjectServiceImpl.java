package com.example.demo.services;

import com.example.demo.database.SubjectDB;
import com.example.demo.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubjectServiceImpl {
    @Autowired
    private SubjectDB SubjectRepo;



    public Subject addSubject (Subject subject) {
        return SubjectRepo.save(subject);
    }

    public String deleteSubjectById (int id){
       SubjectRepo.deleteById(id);
       return "subject removed" + id;
    }

    public List<Subject> getAllSubjects(){
        return SubjectRepo.findAll();
    }
    public Subject updateSubjectById(Subject subject){
        Subject existingSubject = SubjectRepo.findById(subject.getId()).orElse(null);
        existingSubject.setName(subject.getName());
        existingSubject.setCredits(subject.getCredits());
        return SubjectRepo.save(existingSubject);
    }
    public Subject getSubjectById(int id){
        return SubjectRepo.findById(id).orElse(null);

    }


}

package com.example.demo.database;

import com.example.demo.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController

public interface SubjectDB extends JpaRepository<Subject, Integer> {

    public List<Subject> subjects = new ArrayList<Subject>();
}

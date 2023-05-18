package com.example.demo.database;

import com.example.demo.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolDB extends JpaRepository<School,Integer> {
    School findByName(String name);
}

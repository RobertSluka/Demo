package com.example.demo.database;

import com.example.demo.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDB extends JpaRepository<School,Integer> {
}

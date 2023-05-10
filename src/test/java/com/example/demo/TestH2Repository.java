package com.example.demo;

import com.example.demo.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestH2Repository extends JpaRepository<School,Integer> {
}

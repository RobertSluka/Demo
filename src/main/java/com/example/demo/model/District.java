package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Entity
@Table(name = "District")
public class District {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id ;
    private String name;
    @OneToMany(mappedBy = "district")
    private List<School> schools;
}

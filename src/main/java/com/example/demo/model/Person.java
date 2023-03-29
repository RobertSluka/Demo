package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "people")
public class Person {
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Id
    @Column(name = "personId")
    private int personId;

    @Column(insertable = false,updatable = false, name = "school_id")
    private int school_id;

    public Person(String name, int age, int personId, int school_id) {
        this.name = name;
        this.age = age;
        this.personId = personId;
        this.school_id = school_id;
    }
    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person with name: " + name + ", age " + age;
    }
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinTable(name = "school_people",
//            joinColumns = {
//                    @JoinColumn(name = "person_id",referencedColumnName = "personId",nullable = false)
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "school_id", referencedColumnName = "id",nullable = false)
//            }
//    )
    private School school;

}

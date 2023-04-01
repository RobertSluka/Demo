package com.example.demo.model;

import jakarta.persistence.*;

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "personId")
    private int personId;


    public Person(String name, int age, int personId ){
        this.name = name;
        this.age = age;
        this.personId = personId;

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
    @ManyToOne
    private Subject subject;

}

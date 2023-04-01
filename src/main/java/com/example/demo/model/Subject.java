package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity

@Table(name = "subject")

public class Subject {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "credits")
    private int credits;
    @Column(name = "value")
    private int value;

    public Subject() {
    }

    public Subject(int id, String name, int credits, int value, List<Person> people) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.value = value;
        this.people = people;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @OneToMany(mappedBy ="subject",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Person> people;

}
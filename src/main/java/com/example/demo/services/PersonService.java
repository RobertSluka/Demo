package com.example.demo.services;

import com.example.demo.model.Person;
import com.example.demo.model.School;

import java.util.List;

public interface PersonService {
    Person addPersonToTable(Person person);
    List<Person> getAllPeople();
    void deletePerson(int id);
    School getPersonsSchoolById(int school_id);
    List<Person> findPeopleBySchoolId(int id);


}

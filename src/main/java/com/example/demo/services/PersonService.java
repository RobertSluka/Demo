package com.example.demo.services;

import com.example.demo.model.Person;
import com.example.demo.model.School;

import java.util.List;

public interface PersonService {
    public Person addPersonToTable(Person person);
    List<Person> getAllPeople();

    public void deletePerson(int id);

    public School getPersonsSchoolById(int school_id);
    public List<Person> findPeopleBySchoolId(int id);


}

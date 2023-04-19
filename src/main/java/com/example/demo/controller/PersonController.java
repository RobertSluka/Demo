package com.example.demo.controller;

import com.example.demo.DTO.PersonDTO;
import com.example.demo.database.DataAccessException;
import com.example.demo.model.Person;
import com.example.demo.model.PersonMapper;
import com.example.demo.model.School;
import com.example.demo.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PersonController {
    @Autowired
   private  PersonServiceImpl personService;

    @Autowired
    private PersonMapper personMapper;
//    @PostMapping("/person/update")
//    public void updatePerson(Person person) throws DataAccessException {
//        personService.updatePerson(person);
//    }
    @PostMapping("/person/save")
    public Person savePerson(@RequestBody PersonDTO dto) throws DataAccessException {
       return personService.addPersonToTable(personMapper.toEntity(dto));

    }
    @GetMapping("/person/all")
    public List<Person> getAllPeople(){
        return personService.getAllPeople();


    }

    @GetMapping("/person/school/{school_id}")
    public School getSchoolById(@PathVariable("school_id") int school_id){
       return personService.getPersonsSchoolById(school_id);



    }
    @GetMapping("/person/{school_id}")
    public List<Person> getAllPeopleBySchoolId(@PathVariable("school_id") int id) {
        return personService.findPeopleBySchoolId(id);
    }
    @DeleteMapping("/person/delete/{id}")
    public String deletePersonById(@PathVariable("id") int id){
        personService.deletePerson(id);
        return "Person deleted successfully";
    }
}

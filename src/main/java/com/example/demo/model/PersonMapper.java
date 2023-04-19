package com.example.demo.model;

import com.example.demo.DTO.PersonDTO;
import com.example.demo.DTO.SchoolDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public Person toEntity(PersonDTO dto){
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        return entity;
    }
}

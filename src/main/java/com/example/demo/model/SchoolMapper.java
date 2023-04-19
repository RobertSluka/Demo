package com.example.demo.model;

import com.example.demo.DTO.SchoolDTO;
import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {
    public School toEntity(SchoolDTO dto){
        School entity = new School();
        entity.setAddress(dto.getAddress());
        entity.setCapacity(dto.getCapacity());
        entity.setName(dto.getName());
        return entity;
    }

}

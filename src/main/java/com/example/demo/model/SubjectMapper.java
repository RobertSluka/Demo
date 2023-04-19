package com.example.demo.model;

import com.example.demo.DTO.SchoolDTO;
import com.example.demo.DTO.SubjectDTO;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {
    public Subject toEntity(SubjectDTO dto){
        Subject entity = new Subject();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCredits(dto.getCredits());
        entity.setValue(dto.getValue());
        return entity;
    }
}

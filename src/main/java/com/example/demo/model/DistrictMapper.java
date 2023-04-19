package com.example.demo.model;

import com.example.demo.DTO.DistrictDTO;
import com.example.demo.DTO.PersonDTO;

public class DistrictMapper {
    public District toEntity(DistrictDTO dto){
        District entity = new District();
        entity.setName(dto.getName());
        return entity;
    }
}

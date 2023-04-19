package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class SchoolDTO {
    private int id;
    private String address;
    private int capacity;
    private String name;

    public SchoolDTO(int id,String address, int capacity, String name) {
        this.id = id;
        this.address = address;
        this.capacity = capacity;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public int getId(){
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "capacity")
    private int capacity;



    public School() {
    }


    public School(String s) {}
    public School(String name, int capacity, String address, int id) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String value = "";
        if(name != null){
            value += getName();
        }
        if(address != null){
            value += getAddress();
        }
        if (capacity != 0){
            value+= getCapacity();
        }
        return value;
    }

    public int getId() {
        return id;
    }

    @OneToMany(mappedBy = "school",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Person> people;

    @ManyToOne
    private Subject subject;

}

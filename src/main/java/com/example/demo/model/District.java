package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@Entity
@Table(name = "District")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class District {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id ;
    private String name;
    @OneToMany(mappedBy = "district")
    private List<School> schools;
}

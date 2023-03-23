package com.example.demo.database;

import com.example.demo.database.DataAccessException;
import com.example.demo.model.Person;
import com.example.demo.model.School;

import java.util.List;


public interface DAOInterface<T> {



    int create(T value) throws DataAccessException;

    T selectByID(int id) throws DataAccessException;

    List<T> all() throws DataAccessException;


    int update(T value) throws DataAccessException;


    int delete(T value) throws DataAccessException;

}

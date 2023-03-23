package com.example.demo.services;

import com.example.demo.database.DataAccessException;
import com.example.demo.database.SchoolDB;
import com.example.demo.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SchoolService {
    // TODO: see PersonController
    @Autowired
    private SchoolDB SchoolRepo ;

    public SchoolService() throws Exception {
    }

    public School addSchool(School school) throws DataAccessException {
         return SchoolRepo.save(school);
    }

    public void deleteSchoolById(School school) throws DataAccessException {
        SchoolRepo.delete(school);
    }

    public List<School> getAllSchools() throws DataAccessException {
        return SchoolRepo.findAll();
    }
//    public int updateSchoolName(School school) throws DataAccessException {
//        return SchoolRepo.update(school);
//    }
//    public int deleteSchool(School school) throws DataAccessException {
//        return SchoolRepo.delete(school);
//    }
//    public School getSchoolById(int id) throws DataAccessException {
//        return SchoolRepo.selectById(id);
//    }
//    public List<School> listAll() {
//        return (List<School>) SchoolRepo.findAll();
//    }



    @Override
    public String toString() {
        return "SchoolController{" +
                "schoolDB=" + SchoolRepo +
                '}';
    }
}





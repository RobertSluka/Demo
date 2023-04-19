package com.example.demo.services;

import com.example.demo.database.DataAccessException;
import com.example.demo.database.SchoolDB;
import com.example.demo.model.School;
import com.example.demo.model.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SchoolService {
    // TODO: see PersonController
    @Autowired
    private final SchoolDB SchoolRepo ;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolDB schoolRepo, SchoolMapper schoolMapper) throws Exception {
        SchoolRepo = schoolRepo;
        this.schoolMapper = schoolMapper;
    }

    public School addSchool(School school) throws DataAccessException {
         return SchoolRepo.save(school);
    }

    public void deleteSchoolById(int id) throws DataAccessException {
        SchoolRepo.deleteById(id);
    }

    public List<School> getAllSchools() throws DataAccessException {
        return SchoolRepo.findAll();
    }
    public School updateSchool(School school) throws DataAccessException {
        School existingSchool = SchoolRepo.findById(school.getId()).orElse(null);
        existingSchool.setId(school.getId());
        existingSchool.setAddress(school.getAddress());
        existingSchool.setName(school.getName());
        existingSchool.setCapacity(school.getCapacity());
        return SchoolRepo.save(existingSchool);

//    public void updateSchool(int id,SchoolUp) throws DataAccessException {
//        School school = SchoolRepo.getReferenceById(id);
//        boolean changes = false;
//        if (updateRequ)


        }
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





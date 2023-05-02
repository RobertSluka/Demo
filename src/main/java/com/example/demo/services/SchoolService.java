package com.example.demo.services;

import com.example.demo.database.DataAccessException;
import com.example.demo.database.SchoolDB;
import com.example.demo.model.School;
import com.example.demo.model.SchoolMapper;
import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SchoolService {
    // TODO: see PersonController
    @Autowired
    private final SchoolDB SchoolRepo ;
    private final SchoolMapper schoolMapper;

    @Autowired
    private UserInfoRepository UserRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;


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




        }
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        UserRepo.save(userInfo);
//        return jwtUtils.createToken(userInfo);
        return "Token created successfully";
    }



    @Override
    public String toString() {
        return "SchoolController{" +
                "schoolDB=" + SchoolRepo +
                '}';
    }
}





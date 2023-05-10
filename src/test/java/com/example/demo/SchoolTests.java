//package com.example.demo;
//
//import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
//import com.example.demo.database.DataAccessException;
//import com.example.demo.model.School;
//import com.example.demo.services.SchoolService;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@SpringBootTest
//public class SchoolTests {
//    @Autowired
//    SchoolService service;
//    School prazska = new School();
//
//
//    @AfterEach
//    public void tearDown() throws DataAccessException {
//
//
//
//        // act
//        service.deleteSchoolById(prazska.getId());
//        //assert
//        assertThat(service.getSchoolById(prazska.getId()).isEmpty());
//    }
//
//    @BeforeEach
//    public void setUp() {
//        prazska.setName("Prazska");
//        prazska.setAddress("Prazska");
//        prazska.setCapacity(222);
//    }
//
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void testAddSchool() throws DataAccessException {
//        //arrange
//        prazska = new School();
//        //act
//        service.addSchool(prazska);
//        //assert
//        assertThat(service.getSchoolById(prazska.getId())).isEqualTo(prazska);
//
//    }
//}
//    @Test
//    @Transactional
//    public void testDeleteSchool() throws DataAccessException {
//        //arrange
//        School priekopska = new School();
//        service.addSchool(priekopska);
//        int schoolId = marianska.getId();
//        //act
//        service.deleteSchoolById(schoolId);
//        //assert
//        assertThat(service.getSchoolById(marianska.getId()).isEmpty());
//    }



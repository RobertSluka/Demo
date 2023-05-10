package com.example.demo;

import com.example.demo.model.School;
import com.example.demo.services.SchoolService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class H2tests {
    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";
    private static RestTemplate restTemplate;

    private School marianska;

    @Autowired
    private TestH2Repository h2Repository;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }
    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/school/");
        //Define the school object before each test
        marianska = new School();
        marianska.setId(1);
        marianska.setName("marianska");
        marianska.setAddress("marianska");
        marianska.setCapacity(111);
    }
    @Test
    public void testAddSchool() {
        baseUrl = baseUrl.concat("save");
        School response = restTemplate.postForObject(baseUrl, marianska, School.class);

        assertAll("Add School",
                () -> assertEquals("marianska", response.getName()),
                () -> assertEquals(12, h2Repository.findAll().size())
        );
    }

    @Test
    public void testDeleteSchoolById() {
        School savedSchool = new School("marianska",111,"marianska",11);
        baseUrl = baseUrl.concat("delete/" + savedSchool.getId());

        restTemplate.delete(baseUrl + "/" + savedSchool.getId());

        assertEquals(false, h2Repository.findById(savedSchool.getId()).isPresent());
    }
    @Test
    public void getAllSchools() {
        baseUrl = baseUrl.concat("all");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<School[]> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, School[].class);

        School[] schools = response.getBody();
        assertEquals(10, schools.length);

    }

    @AfterEach
    public void TearDown(){
        h2Repository.deleteById(marianska.getId());
    }


}


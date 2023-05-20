package com.example.demo.controller;

import com.example.demo.database.DataAccessException;
import com.example.demo.model.School;
import com.example.demo.DTO.SchoolDTO;
import com.example.demo.model.SchoolMapper;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.services.SchoolService;
import com.example.demo.webSocket.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/school")
public class SchoolControler {
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public SchoolControler(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Autowired
    SchoolService service;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    SchoolMapper schoolMapper;

    @GetMapping("/all")
    public List<School> getAllSchools() throws DataAccessException {
        return service.getAllSchools();
    }

    @PutMapping("/update")
    public School updateSchoolById(@RequestBody School school) throws DataAccessException {
        return service.updateSchool(school);
    }

    @PostMapping("/save")
    public String addSchool(@RequestBody SchoolDTO dto, @RequestHeader("authorization") String token) throws DataAccessException {

// Check if the token is long enough to avoid truncation issues
        if (token.length() < 7) {
            return "Invalid token";
        }
////
////        // Extract the token value by removing the "Bearer " part
        String jwtToken = token.substring(7);
//

        // Validate the token and extract the username
        if (jwtUtils.validateUserByToken(jwtToken)) {
            service.addSchool(schoolMapper.toEntity(dto));

            // Send a WebSocket message to notify the clients about the school being saved
            messagingTemplate.convertAndSend("/all/messages");
            return "School was added";
        } else {
            return "The user is not valid";
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deleteSchoolById(@PathVariable("id") int id) throws DataAccessException {
        service.deleteSchoolById(id);
        return "School deleted successfully";
    }

}

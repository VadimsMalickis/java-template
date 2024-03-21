package lv.rvt.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lv.rvt.model.Student;

@RestController
@RequestMapping("/api")
public class DefaultRestController {

    @GetMapping(value = "/student")
    Student getSingleStudent() {
        return  Student.builder()
                    .name("John")
                    .surname("Smith")
                    .email("e@rvt.lv")
                    .studentGroup("DP2-5")
                    .build();
    }
}

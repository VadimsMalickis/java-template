package lv.rvt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lv.rvt.model.Student;
import lv.rvt.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class DefaultRestController {

    private final StudentRepository studentRepository;

    public DefaultRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    Student getSingleStudent() {
        return  Student.builder()
                    .name("John")
                    .surname("Smith")
                    .email("e@rvt.lv")
                    .studentGroup("DP2-5")
                    .build();
    }

    @GetMapping("/student/{id}")
    Student getStudentById(@PathVariable Integer id) {
        return  Student.builder()
            .name("John")
            .surname("Smith")
            .email("e@rvt.lv")
            .studentGroup("DP2-5")
            .build()
        ;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    void addStudent(@Valid @RequestBody Student student) {
        studentRepository.save(student);
    }


}

package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    /**
     * We separate the business logic to the service class (different layer)
     */
    private final StudentService studentService;

    /**
     * This is the dependency injection part. Instead of using the "new" keyword
     * to initiate it in the controller, we use "Autowired" annotation to let
     * Spring Boot framework handle the object initiation process. Thus loose the
     * tight coupling
     */
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}

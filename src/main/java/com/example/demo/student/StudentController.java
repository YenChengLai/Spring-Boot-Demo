package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @PathVariable(required = false) String name,
                              @PathVariable(required = false) String email){
        studentService.updateNameAndEmail(studentId, name, email);
    }
}

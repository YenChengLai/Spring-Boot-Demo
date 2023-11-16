package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * This class is a service layer, we created it to separate
 * the logic within the controller. Thus creating multiple layers
 * for better management purposes.
 * The @Service annotation is actually doing the same thing as @ Component
 * It's just for better distinguishing purposes
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}

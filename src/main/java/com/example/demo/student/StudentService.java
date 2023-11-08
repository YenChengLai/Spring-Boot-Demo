package com.example.demo.student;

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
    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "John", 25, LocalDate.of(1996, 10, 5), "John.Doe@gmail.com")
        );
    }
}

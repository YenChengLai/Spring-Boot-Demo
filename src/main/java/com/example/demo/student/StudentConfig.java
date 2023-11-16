package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student John = new Student(
                    "John",
                    23,
                    LocalDate.of(2000, Month.JUNE, 10),
                    "john.doe@gmail.com"
            );

            Student william = new Student(
                    "William",
                    20,
                    LocalDate.of(2003, Month.JULY, 17),
                    "william.shakespear@gmail.com"
            );

            studentRepository.saveAll(
                    List.of(John, william)
            );
        };
    }
}

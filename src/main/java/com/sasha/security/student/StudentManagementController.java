package com.sasha.security.student;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static  final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Sasha"),
            new Student(2, "Misha"),
            new Student(3,"Ivan"),
            new Student(4,"Liza")
    );
}

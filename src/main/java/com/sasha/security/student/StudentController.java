package com.sasha.security.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static  final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Sasha"),
            new Student(2, "Misha"),
            new Student(3,"Ivan"),
            new Student(4,"Liza")
    );

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream().
                filter(student -> Objects.equals(student.getStudentId(), studentId)).
                findFirst().
                orElseThrow(()->new IllegalArgumentException("Student " + studentId + "does not exists"));
    }
}

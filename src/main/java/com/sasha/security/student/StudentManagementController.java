package com.sasha.security.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Sasha"),
            new Student(2, "Misha"),
            new Student(3, "Ivan"),
            new Student(4, "Liza")
    );


    //    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')

    @GetMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }



    @PostMapping()
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("registerNewStudent");
        System.out.println(student);

    }

    @DeleteMapping(path = "{studentID}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable Integer studentID, Integer id) {
        System.out.println("deleteStudent");
        System.out.println("Student with " + id + "is deleted");
    }

    @PutMapping(path = "{studentID}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable Integer studentID, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(studentID);
        System.out.println(student);
    }

}

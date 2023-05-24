package com.aclabs.aclabs2023.controllers;

import com.aclabs.aclabs2023.model.Student;
import com.aclabs.aclabs2023.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {
    @Autowired
    StudentService studentService; // our Controller to delegate the logic implementation to a Service class

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("/updateStudent/{id}")
    public void updateStudent(@RequestBody Student updatedStudent){
        studentService.updateStudent(updatedStudent);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
    }
}

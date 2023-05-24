package com.aclabs.aclabs2023.controllers;
import com.aclabs.aclabs2023.model.Student;
import com.aclabs.aclabs2023.services.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService; // our Controller to delegate the logic implementation to a Service class

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>("Student with id " + student.getId() + " was created.", HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student updatedStudent){
       studentService.studentExists(updatedStudent.getId());
       studentService.updateStudent(updatedStudent);
       return new ResponseEntity<>("Student with id " + updatedStudent.getId() + " was updated.", HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable String id){
        studentService.studentExists(id);
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student with id " + id + " was deleted.", HttpStatus.OK);
    }
}

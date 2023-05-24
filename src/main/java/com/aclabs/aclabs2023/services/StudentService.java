package com.aclabs.aclabs2023.services;

import com.aclabs.aclabs2023.exceptions.StudentNotFoundException;
import com.aclabs.aclabs2023.model.Student;
import com.aclabs.aclabs2023.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository; //Service class to delegate the persistence part (adding, removing, retrieving, updating items in a database or store) to a Repository
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student updatedStudent) {
        studentRepository.save(updatedStudent);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public void studentExists(String id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Exception: Student was not found!");
        }
    }
}

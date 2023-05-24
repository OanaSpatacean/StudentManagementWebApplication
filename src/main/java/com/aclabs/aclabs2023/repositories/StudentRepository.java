package com.aclabs.aclabs2023.repositories;

import com.aclabs.aclabs2023.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}

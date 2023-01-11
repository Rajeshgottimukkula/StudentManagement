package com.studentManagement.studentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentManagement.studentService.Entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
	
}

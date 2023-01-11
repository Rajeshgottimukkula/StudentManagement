package com.studentManagement.studentService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.studentManagement.studentService.Entity.Student;
import com.studentManagement.studentService.Service.StudentService;
import com.studentManagement.studentService.VO.ResponseTemplateVO;

@RestController
@RequestMapping("/student")
public class StudentController {

	
	
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/registerStudent")
	public Student registerStudent(@RequestBody Student student) {
		
		return studentService.registerStudent(student);
		
	}
	
	
	@GetMapping("/allStudents")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
		
	}
}

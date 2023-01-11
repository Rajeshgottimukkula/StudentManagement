package com.studentManagement.studentService.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.studentManagement.studentService.Entity.Student;
import com.studentManagement.studentService.VO.Course;
import com.studentManagement.studentService.VO.ResponseTemplateVO;
import com.studentManagement.studentService.VO.Task;
import com.studentManagement.studentService.repository.StudentRepository;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Student registerStudent(Student student) {
		// TODO Auto-generated method stub
		
		
		log.info("Saving the student "+student+" to the database");
		return studentRepository.save(student);
	}



	public java.util.List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		log.info("Getting all the students info");
		return studentRepository.findAll();
	}



	public ResponseTemplateVO getStudentById(int id) {
		// TODO Auto-generated method stub
		
		ResponseTemplateVO vo=new ResponseTemplateVO();
		log.info("Getting the student with id "+id);
		
		Student student=studentRepository.findById(id).get();
		Course course=restTemplate.getForObject("http://localhost:8031/course/"+student.getCourseName(), Course.class);
		Task task=restTemplate.getForObject("http://localhost:8032/task/"+student.getTaskId(), Task.class);
		
		vo.setCourse(course);
		vo.setStudent(student);
		vo.setTask(task);
		return vo;
	}

	
	
   
}

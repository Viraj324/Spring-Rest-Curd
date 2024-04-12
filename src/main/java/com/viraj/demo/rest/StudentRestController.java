package com.viraj.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viraj.demo.entity.Student;
import com.viraj.demo.rest.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		
		
		theStudents.add(new Student("Viraj1","Sonawane"));
		theStudents.add(new Student("Viraj2","Sonawane"));
		theStudents.add(new Student("Viraj3","Sonawane"));
		theStudents.add(new Student("Viraj4","Sonawane"));
	}
	//http://localhost:8080/api/students
	//define endpoint for "/students" - return a list of Students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
	}
	
	
	//define endpoint for retrivingg a single student with endpoint or "/student/{studentId}" - return statement at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		//Just index into the list.. keep it simple for now 
		//http://localhost:8080/api/students/1
		
		//check the student against the list size
		if((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not Found.."+studentId);
		}
		return theStudents.get(studentId);
		
	}
	
	//Add Exception Handler using @ExceptionHandler
	
}

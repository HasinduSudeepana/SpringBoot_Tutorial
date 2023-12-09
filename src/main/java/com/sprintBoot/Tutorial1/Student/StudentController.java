package com.sprintBoot.Tutorial1.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	// The StudentService field is a service responsible for business logic related to Student entities.
	private final StudentService studentService;

	// Constructor for StudentController, injecting an instance of StudentService.
	@Autowired
	public StudentController(StudentService studentService) {

		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> getStudents(){

		return studentService.getStudents();
	}

	@PostMapping
	public void registerNewStudent(@RequestBody Student student){
		StudentService.addNewStudent(student);
	}

	@DeleteMapping(path="{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId){
		studentService.deleteStudent(studentId);
	}

	@PutMapping(path="{studentId}")
	public void updateStudent(@PathVariable("studentId") Long studentId,
							  @RequestParam(required = false) String name,
							  @RequestParam(required = false) String email){
		studentService.updateStudent(studentId,name,email);
	}

}

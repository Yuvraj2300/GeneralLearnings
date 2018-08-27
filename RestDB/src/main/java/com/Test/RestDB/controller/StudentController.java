package com.Test.RestDB.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Test.RestDB.Reps.StudentRep;
import com.Test.RestDB.entity.Student;

@RestController
@RequestMapping("/testapi")
public class StudentController {

	@Autowired
	StudentRep	stdRep;
	
	@PostMapping("/students")
	public	ResponseEntity<Student>	postStudent(@RequestBody	@Valid	Student	student){
		stdRep.save(student);
		return	ResponseEntity.ok(student);
	}
	
	
	@GetMapping("/students")
	public	List<Student>	getAllStudents(){
		return	stdRep.findAll();
	}
	
	
}

package com.lrn.springrestex_1.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lrn.springrestex_1.entity.Student;
import com.lrn.springrestex_1.exception.StudentNotFoundException;
import com.lrn.springrestex_1.repos.StudentRepository;

@RestController
public class StudentResource {
	@Autowired
	private StudentRepository studentRep;

	@GetMapping("/students")
	public List<Student> getAll() {
		return studentRep.findAll();
	}

	@GetMapping("/students/{id}")
	public Resource<Student> retrieveStudent(@PathVariable Long id) {
		Optional<Student> student = studentRep.findById(id);
		Student	foundStudent	=	student.get();
		
		if (!student.isPresent()) {
			throw new StudentNotFoundException("id- " + id);
		}

		// USING RESOURCE AND ALSO RETURNIGN IT TO USE HATEOAS
		Resource<Student> resource = new Resource<>(student.get());

		// HATEOAS RELATED
		ControllerLinkBuilder linkToAll = linkTo(methodOn(this.getClass()).getAll());
		resource.add(linkToAll.withRel("all-students"));
		
		ControllerLinkBuilder	linktoUpdate	=	linkTo(methodOn(this.getClass()).
				updateStudent(foundStudent, student.get().getId()));
		resource.add(linktoUpdate.withRel("update-student"));
		
		return resource;
	}

	@PostMapping("/students")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student) {
		Student savedStudent = studentRep.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable Long id) {
		Optional<Student> studentOpt = studentRep.findById(id);

		if (!studentOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		student.setId(id);
		studentRep.save(student);

		return ResponseEntity.noContent().build();
	}

}

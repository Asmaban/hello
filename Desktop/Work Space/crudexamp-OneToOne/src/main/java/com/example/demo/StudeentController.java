package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")

public class StudeentController {
	@Autowired

	private StudeentRepo studentRepo;

	@PostMapping
	public ResponseEntity<Studeent> saveStudent(@RequestBody Studeent student) {
	return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Studeent>> getAllStudents() {
	return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Studeent> getStudentById(@PathVariable int id) {
	Optional<Studeent> student = studentRepo.findById(id);
	return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Studeent> updateStudent(@PathVariable int id, @RequestBody
	Studeent updatedStudent) {
	Optional<Studeent> existingStudent = studentRepo.findById(id);

	if (existingStudent.isPresent()) {
	Studeent student = existingStudent.get();
	student.setName(updatedStudent.getName());
	student.setDob(updatedStudent.getDob());
	student.setClasses(updatedStudent.getClasses());
	student.setDivision(updatedStudent.getDivision());
	student.setGender(updatedStudent.getGender());
	return new ResponseEntity<>(studentRepo.save(student), HttpStatus.OK);
	} else {

	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
	Optional<Studeent> student = studentRepo.findById(id);

	if (student.isPresent()) {
	studentRepo.deleteById(id);
	return new ResponseEntity<>(HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}

}

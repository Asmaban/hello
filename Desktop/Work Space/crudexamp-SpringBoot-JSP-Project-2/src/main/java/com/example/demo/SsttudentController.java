package com.example.demo;
import com.example.demo.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SsttudentController {
	
	private SsttudentService studentService;

	public SsttudentController(SsttudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
		
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Ssttudent student = new Ssttudent();
		model.addAttribute("student",student);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveSsttudent(@ModelAttribute("student") Ssttudent student) {
		studentService.saveSsttudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getSsttudentById(id));
		return "edit_student";
		
	}
	
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Ssttudent student, Model model) {
		Ssttudent existingSsttudent = studentService.getSsttudentById(id);
		existingSsttudent.setId(student.getId());
		existingSsttudent.setFirstName(student.getFirstName());
		existingSsttudent.setLastName(student.getLastName());
		existingSsttudent.setEmail(student.getEmail());
		
		
		studentService.updateSsttudent(existingSsttudent);
		return "redirect:/students";
		
		
	}
	
	@GetMapping("/students/{id}")
	public String deleteSsttudent(@PathVariable Long id) {
		studentService.deleteSsttudentById(id);
		return "redirect:/students";
		
	}
	
	@PostMapping("/api/students")
	public ResponseEntity<String> saveSsttudent1(@RequestBody Ssttudent student) {
	    Ssttudent savedStudent = studentService.saveSsttudent(student);
	    if (savedStudent != null) {
	        return new ResponseEntity<>("Student saved successfully", HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>("Failed to save student", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/api/students/{id}")
    public ResponseEntity<Ssttudent> getStudentById(@PathVariable Long id) {
        Ssttudent student = studentService.getSsttudentById(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	 @PutMapping("/api/students/{id}")
	    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Ssttudent student) {
	        Ssttudent existingSsttudent = studentService.getSsttudentById(id);
	        if (existingSsttudent != null) {
	            existingSsttudent.setFirstName(student.getFirstName());
	            existingSsttudent.setLastName(student.getLastName());
	            existingSsttudent.setEmail(student.getEmail());
	            studentService.updateSsttudent(existingSsttudent);
	            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
	        }
	    }
	 

	    @DeleteMapping("/api/students/{id}")
	    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
	        studentService.deleteSsttudentById(id);
	        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
	    }


}

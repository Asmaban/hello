package com.example.demo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cycles")

public class CycleController {
	@Autowired
	private CycleRepo cycleRepo;
	
	@PostMapping("/api/cycles")
	public ResponseEntity<Cycle> saveCycle(@RequestBody Cycle cycle) {
		return new ResponseEntity<>(cycleRepo.save(cycle), HttpStatus.CREATED);
		}

		@GetMapping("/api/cycles")
		public ResponseEntity<List<Cycle>> getAllCycles() {
		return new ResponseEntity<>(cycleRepo.findAll(), HttpStatus.OK);
		}
		
		@GetMapping("/api/cycles/{id}")
		public ResponseEntity<Cycle> getCycleById(@PathVariable Long id) {
		Optional<Cycle> cycle = cycleRepo.findById(id);
		return cycle.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
		.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}

		@PutMapping("/api/cycles/{id}")
		public ResponseEntity<Cycle> updateCycle(@PathVariable long id, @RequestBody
		Cycle updatedCycle) {
		Optional<Cycle> existingCycle = cycleRepo.findById(id);

		if (existingCycle.isPresent()) {
		Cycle cycle = existingCycle.get();
		cycle.setModel(updatedCycle.getModel());
		return new ResponseEntity<>(cycleRepo.save(cycle), HttpStatus.OK);
		} else {

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
		
		@DeleteMapping("/api/cycles/{id}")
		public ResponseEntity<Void> deleteCycle(@PathVariable Long id) {
		Optional<Cycle> cycle = cycleRepo.findById(id);

		if (cycle.isPresent()) {
		cycleRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}


}

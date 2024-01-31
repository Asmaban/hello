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
@RequestMapping("/api/bicycles")
public class BicycleController {
	
	@Autowired
	private BicycleRepo bicycleRepo;
	
	@PostMapping
	public ResponseEntity<Bicycle> saveBicycle(@RequestBody Bicycle bicycle) {
		return new ResponseEntity<>(bicycleRepo.save(bicycle), HttpStatus.CREATED);
		}

		@GetMapping("/api/bicycles")
		public ResponseEntity<List<Bicycle>> getAllBicycles() {
		return new ResponseEntity<>(bicycleRepo.findAll(), HttpStatus.OK);
		}
		
		@GetMapping("/api/bicycles/{id}")
		public ResponseEntity<Bicycle> getBicycleById(@PathVariable Long id) {
		Optional<Bicycle> bicycle = bicycleRepo.findById(id);
		return bicycle.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
		.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}

		@PutMapping("/api/bicycles/{id}")
		public ResponseEntity<Bicycle> updateBicycle(@PathVariable long id, @RequestBody
		Bicycle updatedBicycle) {
		Optional<Bicycle> existingBicycle = bicycleRepo.findById(id);

		if (existingBicycle.isPresent()) {
		Bicycle bicycle = existingBicycle.get();
		bicycle.setBrand(updatedBicycle.getBrand());
		return new ResponseEntity<>(bicycleRepo.save(bicycle), HttpStatus.OK);
		} else {

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
		
		@DeleteMapping("/api/bicycles/{id}")
		public ResponseEntity<Void> deleteBicycle(@PathVariable Long id) {
		Optional<Bicycle> bicycle = bicycleRepo.findById(id);

		if (bicycle.isPresent()) {
		bicycleRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}

}

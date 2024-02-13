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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
	@Autowired
	MoviesRepo mR;
	
	@PostMapping
	public ResponseEntity<Movies> saveMovies(@RequestBody Movies m) {
	return new ResponseEntity<>(mR.save(m), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Movies>> getAllMovies() {
	return new ResponseEntity<>(mR.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movies> getMoviesById(@PathVariable Long id) {
	Optional<Movies> m = mR.findById(id);
	return m.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Movies> updateMovies(@PathVariable long id, @RequestBody
	Movies updatedMovies) {
	Optional<Movies> existingMovies = mR.findById(id);

	if (existingMovies.isPresent()) {
	Movies m= existingMovies.get();
	m.setTitle(updatedMovies.getTitle());
	m.setId(updatedMovies.getId());
	
	return new ResponseEntity<>(mR.save(m), HttpStatus.OK);
	} else {

	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMovies(@PathVariable Long id) {
	Optional<Movies> m = mR.findById(id);

	if (m.isPresent()) {
	mR.deleteById(id);
	return new ResponseEntity<>(HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	

}

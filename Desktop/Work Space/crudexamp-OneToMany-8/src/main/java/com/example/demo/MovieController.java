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
public class MovieController {
	@Autowired
	private MovieRepo movieRepo;

	@PostMapping("/api/movie")
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie m) {
	Movie savedMovie = movieRepo.save(m);
	return new ResponseEntity<Movie>(savedMovie, HttpStatus.CREATED);
	}
	
	@GetMapping("/api/movie/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable long id) {
		Optional<Movie> m = movieRepo.findById(id);

		if (m.isPresent()) {
			return new ResponseEntity<Movie>(m.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/api/movie/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie updatedMovie) {
		Optional<Movie> existingMovie = movieRepo.findById(id);

		if (existingMovie.isPresent()) {
			Movie m = existingMovie.get();
			m.setTitle(updatedMovie.getTitle());
			m.setId(updatedMovie.getId());
			Movie savedMovie = movieRepo.save(m);
			return new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);
		} else {
			return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/api/movie/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable long id) {
		Optional<Movie> m = movieRepo.findById(id);

		if (m.isPresent()) {
			movieRepo.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}



	

}

package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public class MovieeController {
	@Autowired
	private MovieeRepo movieRepo;
	
	
	@PostMapping("/api/movie")
	public ResponseEntity<Moviee> saveMoviee(@RequestBody Moviee movie) {
		Moviee savedMoviee = movieRepo.save(movie);
		return new ResponseEntity<Moviee>(savedMoviee,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/api/movie/one")
	public List<Moviee> getMovieeOne() {
		Pageable paging = PageRequest.of(0, 7, Sort.by("id").ascending());
		Page<Moviee> page = movieRepo.findAll(paging);
		return page.getContent();
	}

	@GetMapping("/api/movie/two")
	public List<Moviee> getMovieeTwo() {
		Pageable paging = PageRequest.of(0, 5, Sort.by("id").descending());
		Page<Moviee> page = movieRepo.findAll(paging);
		return page.getContent();
	}

	@GetMapping("/api/movie/three")
	public List<Moviee> getMovieeThree() {
		Pageable paging = PageRequest.of(0, 6, Sort.by("title").ascending());
		Page<Moviee> page = movieRepo.findAll(paging);
		return page.getContent();
	}
	
	@PutMapping("/api/movie/{id}")
	public ResponseEntity<Moviee> putdata(@PathVariable Long id, @RequestBody Moviee m) {
		Optional<Moviee> obj = movieRepo.findById(id);
		if (obj.isPresent()) {
			obj.get().setTitle(m.getTitle());
			obj.get().setId(m.getId());
			
			
			return new ResponseEntity<>(movieRepo.save(obj.get()), HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	@DeleteMapping("/api/movie/{id}")
	public ResponseEntity<Moviee> deletedata(@PathVariable Long id) {
		Optional<Moviee> obj = movieRepo.findById(id);
		if (obj.isPresent()) {
			movieRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}


}

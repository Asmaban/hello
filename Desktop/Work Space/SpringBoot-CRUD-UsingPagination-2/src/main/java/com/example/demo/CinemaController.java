package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
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
public class CinemaController {
	@Autowired
	CinemaRepo cinemaRepo;
	
	@PostMapping("/api/cinema")
	public ResponseEntity<Cinema> savedata(@RequestBody Cinema cinema) {
		return new ResponseEntity<>(cinemaRepo.save(cinema),HttpStatus.CREATED);
	}
	
	@GetMapping("api/cinema/one")
	public List<Cinema> getCinemaOne() {
		Pageable p = PageRequest.of(0, 4, Sort.by("seatNo").ascending());
		Page<Cinema> page = cinemaRepo.findAll(p);
		return page.getContent();
	}
	
	@GetMapping("api/cinema/two")
	public List<Cinema> getCinemaTwo() {
		Pageable p = PageRequest.of(0, 5, Sort.by("movieName").descending());
		Page<Cinema> page = cinemaRepo.findAll(p);
		return page.getContent();
	}
	
	@GetMapping("api/cinema/three")
	public List<Cinema> getCinemaThree() {
		Pageable p = PageRequest.of(0, 3, Sort.by("id").descending());
		Page<Cinema> page = cinemaRepo.findAll(p);
		return page.getContent();
	}
	
	@GetMapping("api/cinema/four")
	public List<Cinema> getCinemaFour() {
		Pageable p = PageRequest.of(0, 5, Sort.by("name").ascending());
		Page<Cinema> page = cinemaRepo.findAll(p);
		return page.getContent();
	}
	
	@PutMapping("/api/cinema/{id}")
	public ResponseEntity<Cinema> putdata(@PathVariable Long id,@RequestBody Cinema ci) {
		Optional<Cinema> obj = cinemaRepo.findById(id);
		if(obj.isPresent()) {
			obj.get().setName(ci.getName());
			obj.get().setSeatNo(ci.getSeatNo());
			obj.get().setMovieName(ci.getMovieName());
			obj.get().setId(ci.getId());
			
			return new ResponseEntity<>(cinemaRepo.save(obj.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/api/cinema/{id}")
	public ResponseEntity<Cinema> putdata(@PathVariable Long id) {
		Optional<Cinema> obj = cinemaRepo.findById(id);
		if(obj.isPresent()) {
			cinemaRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	

}

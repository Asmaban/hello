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
public class PeersonController {
	@Autowired
	private PeersonRepo personRepo;
	
	
	@PostMapping("/api/person")
	public ResponseEntity<Peerson> savePeerson(@RequestBody Peerson person) {
		Peerson savedPeerson = personRepo.save(person);
		return new ResponseEntity<Peerson>(savedPeerson,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/api/person/one")
	public List<Peerson> getPeersonOne() {
		Pageable paging = PageRequest.of(0, 7, Sort.by("id").ascending());
		Page<Peerson> page = personRepo.findAll(paging);
		return page.getContent();
	}

	@GetMapping("/api/person/two")
	public List<Peerson> getPeersonTwo() {
		Pageable paging = PageRequest.of(0, 5, Sort.by("name").descending());
		Page<Peerson> page = personRepo.findAll(paging);
		return page.getContent();
	}

	@GetMapping("/api/person/three")
	public List<Peerson> getPeersonThree() {
		Pageable paging = PageRequest.of(0, 6, Sort.by("seatNo").ascending());
		Page<Peerson> page = personRepo.findAll(paging);
		return page.getContent();
	}
	
	@PutMapping("/api/person/{id}")
	public ResponseEntity<Peerson> putdata(@PathVariable Long id, @RequestBody Peerson p) {
		Optional<Peerson> obj = personRepo.findById(id);
		if (obj.isPresent()) {
			obj.get().setName(p.getName());
			obj.get().setId(p.getId());
			obj.get().setSeatNo(p.getSeatNo());
			obj.get().setMovieName(p.getMovieName());
			obj.get().setTicketPrice(p.getTicketPrice());
			
			return new ResponseEntity<>(personRepo.save(obj.get()), HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	@DeleteMapping("/api/person/{id}")
	public ResponseEntity<Peerson> deletedata(@PathVariable Long id) {
		Optional<Peerson> obj = personRepo.findById(id);
		if (obj.isPresent()) {
			personRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}


}

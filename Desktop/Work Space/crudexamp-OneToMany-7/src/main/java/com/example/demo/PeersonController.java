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
public class PeersonController {
	@Autowired
	PeersoRepo personRepo;
	
	@PostMapping
	public ResponseEntity<Peerson> savePeerson(@RequestBody Peerson p) {
	return new ResponseEntity<>(personRepo.save(p), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Peerson>> getAllPeerson() {
	return new ResponseEntity<>(personRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Peerson> getPeersonById(@PathVariable Long id) {
	Optional<Peerson> p = personRepo.findById(id);
	return p.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Peerson> updatePeerson(@PathVariable long id, @RequestBody
	Peerson updatedPeerson) {
	Optional<Peerson> existingPeerson = personRepo.findById(id);

	if (existingPeerson.isPresent()) {
	Peerson p = existingPeerson.get();
	p.setName(updatedPeerson.getName());
	p.setId(updatedPeerson.getId());
	p.setSeatNo(updatedPeerson.getSeatNo());
	p.setMovieName(updatedPeerson.getMovieName());
	return new ResponseEntity<>(personRepo.save(p), HttpStatus.OK);
	} else {

	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePeerson(@PathVariable Long id) {
	Optional<Peerson> p = personRepo.findById(id);

	if (p.isPresent()) {
	personRepo.deleteById(id);
	return new ResponseEntity<>(HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	

}

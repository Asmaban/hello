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
public class PpersonController {
	@Autowired
	private PpersonRepo ppersonRepo;

	@PostMapping("/api/person")
	public ResponseEntity<Pperson> savePperson(@RequestBody Pperson p) {
		Pperson savedPperson = ppersonRepo.save(p);
		return new ResponseEntity<Pperson>(savedPperson, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Pperson>> getAllPperson() {
		List<Pperson> p = ppersonRepo.findAll();
		return new ResponseEntity<List<Pperson>>(p, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pperson> getPpersonById(@PathVariable long id) {
		Optional<Pperson> p = ppersonRepo.findById(id);

		if (p.isPresent()) {
			return new ResponseEntity<Pperson>(p.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Pperson>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pperson> updatePperson(@PathVariable long id, @RequestBody Pperson updatedPperson) {
		Optional<Pperson> existingPperson = ppersonRepo.findById(id);

		if (existingPperson.isPresent()) {
			Pperson p = existingPperson.get();
			p.setName(updatedPperson.getName());
			p.setMovieName(updatedPperson.getMovieName());
			p.setId(updatedPperson.getId());
			Pperson savedPperson = ppersonRepo.save(p);
			return new ResponseEntity<Pperson>(savedPperson, HttpStatus.OK);
		} else {
			return new ResponseEntity<Pperson>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePperson(@PathVariable long id) {
		Optional<Pperson> p = ppersonRepo.findById(id);

		if (p.isPresent()) {
			ppersonRepo.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}

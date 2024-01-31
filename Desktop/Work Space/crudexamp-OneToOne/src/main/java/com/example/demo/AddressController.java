package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")

public class AddressController {
	@Autowired
	private AddressRepo addressRepo;

	@PostMapping
	public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
	return new ResponseEntity<>(addressRepo.save(address), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Address>> getAllAddresses() {
	return new ResponseEntity<>(addressRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable int id) {
	Optional<Address> address = addressRepo.findById(id);
	return address.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable int id, @RequestBody
	Address updatedAddress) {
	Optional<Address> existingAddress = addressRepo.findById(id);

	if (existingAddress.isPresent()) {
	Address address = existingAddress.get();
	address.setStreet(updatedAddress.getStreet());
	address.setCity(updatedAddress.getCity());
	address.setZipCode(updatedAddress.getZipCode());
	return new ResponseEntity<>(addressRepo.save(address), HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable int id) {
	Optional<Address> address = addressRepo.findById(id);

	if (address.isPresent()) {
	addressRepo.deleteById(id);
	return new ResponseEntity<>(HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}

}

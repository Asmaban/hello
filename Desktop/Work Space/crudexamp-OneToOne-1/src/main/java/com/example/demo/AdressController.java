package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")

public class AdressController {
	@Autowired
    private AdressRepo adressRepo;

    @PostMapping
    public ResponseEntity<Adress> createAddress(@RequestBody Adress address) {
        adressRepo.save(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adress> getAddressById(@PathVariable Long id) {
        Adress address = adressRepo.findById(id).orElse(null);
        return address != null ? ResponseEntity.ok(address) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adress> updateAddress(@PathVariable Long id, @RequestBody Adress updatedAddress) {
        return adressRepo.findById(id)
                .map(address -> {
                    address.setStreet(updatedAddress.getStreet());
                    address.setCity(updatedAddress.getCity());
                    address.setZipCode(updatedAddress.getZipCode());
                    return ResponseEntity.ok(adressRepo.save(address));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        if (adressRepo.existsById(id)) {
            adressRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

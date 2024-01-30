package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")

public class PersonController {
	@Autowired
    private PersonRepo personRepo;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        personRepo.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personRepo.findById(id).orElse(null);
        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personRepo.findById(id)
                .map(person -> {
                    person.setName(updatedPerson.getName());
                    person.setAdress(updatedPerson.getAdress());
                    return ResponseEntity.ok(personRepo.save(person));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        if (personRepo.existsById(id)) {
            personRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

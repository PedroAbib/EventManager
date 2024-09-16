package com.EventManager.controllers;

import com.EventManager.entities.Person;
import com.EventManager.dto.PersonRecord;
import com.EventManager.services.PersonServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices personServices;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> allPerson = personServices.getAllPerson();
        return ResponseEntity.ok(allPerson);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable String personId) {
        Optional<Person> person = personServices.getPerson(personId);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody @Valid PersonRecord data) {
        Person newPerson = personServices.addPerson(data);
        return ResponseEntity.ok(newPerson);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<Person> updatePerson(@PathVariable String personId, @RequestBody PersonRecord data) {
        Person updatedPerson = personServices.updatePerson(personId, data);
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable String personId) {
        personServices.deletePerson(personId);
        return ResponseEntity.ok().build();
    }
}

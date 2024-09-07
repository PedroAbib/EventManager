package com.EventManager.controllers;

import com.EventManager.entities.Person;
import com.EventManager.entities.PersonRecord;
import com.EventManager.services.PersonServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody @Valid PersonRecord data) {
        Person newPerson = personServices.addPerson(data);
        return ResponseEntity.ok(newPerson);
    }
}

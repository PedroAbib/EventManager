package com.EventManager.controllers;

import com.EventManager.entities.Person;
import com.EventManager.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

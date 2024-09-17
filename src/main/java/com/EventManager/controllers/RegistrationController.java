package com.EventManager.controllers;

import com.EventManager.entities.Person;
import com.EventManager.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @GetMapping("/{eventId}")
    public ResponseEntity<List<Person>> getRegisteredPeople(String eventId) {
        List<Person> registeredPeople = registrationService.getRegisteredPeople(eventId);
        return ResponseEntity.ok(registeredPeople);
    }

}

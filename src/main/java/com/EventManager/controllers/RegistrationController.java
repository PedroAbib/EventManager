package com.EventManager.controllers;

import com.EventManager.entities.Person;
import com.EventManager.entities.Registration;
import com.EventManager.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @PostMapping("/{eventId}/{personId}")
    public ResponseEntity<String> registerPersonToEvent(@PathVariable String eventId, @PathVariable String personId) {
        registrationService.registerPersonToEvent(eventId, personId);
        return ResponseEntity.ok("Person registered successfully!");
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<List<Person>> getRegisteredPeople(@PathVariable String eventId) {
        List<Person> registeredPeople = registrationService.getRegisteredPeople(eventId);
        return ResponseEntity.ok(registeredPeople);
    }

}

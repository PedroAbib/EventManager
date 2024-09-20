package com.EventManager.controllers;

import com.EventManager.dto.RegistrationResponseDTO;
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
    public ResponseEntity<List<RegistrationResponseDTO>> getRegisteredPeople(@PathVariable String eventId) {
        List<RegistrationResponseDTO> registeredPeople = registrationService.getRegisteredPeople(eventId);
        return ResponseEntity.ok(registeredPeople);
    }

    @DeleteMapping("/{registrationId}")
    public ResponseEntity<String> deleteRegistration(@PathVariable String registrationId) {
        registrationService.unregisterPersonFromEvent(registrationId);
        return ResponseEntity.ok("Person unregistered successfully!");
    }
}

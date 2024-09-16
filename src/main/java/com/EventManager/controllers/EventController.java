package com.EventManager.controllers;

import com.EventManager.entities.Event;
import com.EventManager.entities.EventRecord;
import com.EventManager.services.EventServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventServices eventServices;

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> allEvents = eventServices.getAllEvents();
        return ResponseEntity.ok(allEvents);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Optional<Event>> getEvent(@PathVariable String eventId) {
        Optional<Event> event = eventServices.getEvent(eventId);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody @Valid EventRecord data) {
        Event newEvent = eventServices.addEvent(data);
        return ResponseEntity.ok(newEvent);
    }
}

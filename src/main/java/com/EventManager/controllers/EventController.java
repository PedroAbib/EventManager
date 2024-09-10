package com.EventManager.controllers;

import com.EventManager.entities.Event;
import com.EventManager.entities.EventRecord;
import com.EventManager.services.EventServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody @Valid EventRecord data) {
        Event newEvent = eventServices.addEvent(data);
        return ResponseEntity.ok(newEvent);
    }
}

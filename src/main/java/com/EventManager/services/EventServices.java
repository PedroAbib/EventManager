package com.EventManager.services;

import com.EventManager.entities.Event;
import com.EventManager.entities.EventRecord;
import com.EventManager.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServices {
    @Autowired
    EventRepository repository;

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Optional<Event> getEvent(String eventId) {
        return repository.findById(eventId);
    }

    public Event addEvent(EventRecord data) {
        Event newEvent = new Event(data);
        return repository.save(newEvent);
    }

    // updateEvent

    // deleteEvent
}

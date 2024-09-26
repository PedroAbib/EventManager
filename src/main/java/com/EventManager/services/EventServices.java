package com.EventManager.services;

import com.EventManager.entities.Event;
import com.EventManager.dto.EventDTO;
import com.EventManager.exceptions.ResourceNotFoundException;
import com.EventManager.repositories.EventRepository;
import jakarta.persistence.EntityNotFoundException;
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
        Optional<Event> event = repository.findById(eventId);
        if (event.isPresent()) {
            return event;
        } else {
            throw new ResourceNotFoundException("Event ID not found.");
        }
    }

    public Event addEvent(EventDTO data) {
        Event newEvent = new Event(data);
        return repository.save(newEvent);
    }

    public Event updateEvent(String eventId, EventDTO data) {
        Optional<Event> event = repository.findById(eventId);

        if (event.isPresent()) {
            Event updatedEvent = event.get();

            if (data != null) {
                updatedEvent.setName(data.name());
                updatedEvent.setDate(data.date());
                updatedEvent.setAddress(data.address());
                updatedEvent.setDescription(data.description());
            }
            return repository.save(updatedEvent);
        } else {
            throw new ResourceNotFoundException("Event ID not found.");
        }
    }

    public void deleteEvent(String eventId) {
        Optional<Event> event = repository.findById(eventId);

        if (event.isPresent()) {
            repository.deleteById(eventId);
        } else {
            throw new ResourceNotFoundException("Event ID not found.");
        }
    }
}

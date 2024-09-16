package com.EventManager.services;

import com.EventManager.entities.Event;
import com.EventManager.entities.EventRecord;
import com.EventManager.repositories.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public Event updateEvent(String eventId, EventRecord data) {
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
        }

        return null;
    }

    public void deleteEvent(String eventId) {
        Optional<Event> event = repository.findById(eventId);

        if (event.isPresent()) {
            repository.deleteById(eventId);
        } else {
            throw new EntityNotFoundException();
        }
    }
}

package com.EventManager.services;

import com.EventManager.entities.Event;
import com.EventManager.dto.EventDTO;
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
        return repository.findById(eventId);
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
                if (data.name() != null && !data.name().isEmpty()) {
                    updatedEvent.setName(data.name());
                }
                if (data.imageURL() != null && !data.imageURL().isEmpty()) {
                    updatedEvent.setImageURL(data.imageURL());
                }
                if (data.date() != null) {
                    updatedEvent.setDate(data.date());
                }
                if (data.address() != null && !data.address().isEmpty()) {
                    updatedEvent.setAddress(data.address());
                }
                if (data.description() != null && !data.description().isEmpty()) {
                    updatedEvent.setDescription(data.description());
                }
                if (data.isCompleted() != null) {
                    updatedEvent.setIsCompleted(data.isCompleted());
                }
            }
            return repository.save(updatedEvent);
        } else {
            throw new EntityNotFoundException();
        }
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

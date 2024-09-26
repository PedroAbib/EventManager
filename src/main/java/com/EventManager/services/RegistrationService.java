package com.EventManager.services;

import com.EventManager.dto.RegistrationDTO;
import com.EventManager.dto.RegistrationResponseDTO;
import com.EventManager.entities.Event;
import com.EventManager.entities.Person;
import com.EventManager.entities.Registration;
import com.EventManager.exceptions.ResourceNotFoundException;
import com.EventManager.mappers.RegistrationMapper;
import com.EventManager.repositories.EventRepository;
import com.EventManager.repositories.PersonRepository;
import com.EventManager.repositories.RegistrationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RegistrationMapper registrationMapper;

    public void registerPersonToEvent(String eventId, String personId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event ID not found.")); // Handle these Exceptions later
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person ID not found."));

        Registration registration = new Registration();
        registration.setEvent(event);
        registration.setPerson(person);

        registrationRepository.save(registration);
    }

    public List<RegistrationResponseDTO> getRegisteredPeople(String eventId) {
        List<Registration> registrations = registrationRepository.findByEventId(eventId);
        // Review this implementation on line 50

        return registrations.stream()
                .map(registrationMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void toggleIsPaid(String registrationId, RegistrationDTO newData) {
        Optional<Registration> existingRegistration = registrationRepository.findById(registrationId);

        if (existingRegistration.isPresent()) {
            Registration registration = existingRegistration.get();

            if (newData.isPaid() != null) {
                registration.setIsPaid(newData.isPaid());
            }
            registrationRepository.save(registration);
        } else {
            throw new ResourceNotFoundException("Registration ID not found.");
        }
    }

    public void unregisterPersonFromEvent(String registrationId) {
        Optional<Registration> registration = registrationRepository.findById(registrationId);

        if (registration.isPresent()) {
            registrationRepository.deleteById(registrationId);
        } else {
            throw new ResourceNotFoundException("Registration ID not found.");
        }
    }
}

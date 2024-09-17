package com.EventManager.services;

import com.EventManager.entities.Person;
import com.EventManager.entities.Registration;
import com.EventManager.repositories.EventRepository;
import com.EventManager.repositories.PersonRepository;
import com.EventManager.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getRegisteredPeople(String eventId) {
        List<Registration> registrations = registrationRepository.findByEventId(eventId);

        return registrations.stream()
                .map(Registration::getPerson)
                .collect(Collectors.toList());
    }
}

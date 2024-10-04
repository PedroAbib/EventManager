package com.EventManager.mappers;

import com.EventManager.dto.RegistrationResponseDTO;
import com.EventManager.entities.Person;
import com.EventManager.entities.Registration;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper {

    public RegistrationResponseDTO toResponseDTO(Registration registration) {
        Person person = registration.getPerson();
        return new RegistrationResponseDTO(
                registration.getId(),
                person.getId(),
                person.getFullName(),
                person.getTagName(),
                person.getWorkField(),
                person.getCpf(),
                person.getEmail(),
                person.getPhoneNumber(),
                person.getAddress(),
                person.getPostalCode(),
                registration.getRegistrationDate(),
                registration.getIsPaid()
        );
    }
}

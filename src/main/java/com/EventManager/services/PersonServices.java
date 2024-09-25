package com.EventManager.services;

import com.EventManager.entities.Person;
import com.EventManager.dto.PersonDTO;
import com.EventManager.repositories.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServices {
    @Autowired
    private PersonRepository repository;

    public List<Person> getAllPerson() {
        return repository.findAll();
    }

    public Optional<Person> getPerson(String personId) {
        return repository.findById(personId);
    }

    public Person addPerson(PersonDTO data) {
        Person newPerson = new Person(data);
        return repository.save(newPerson);
    }

    public Person updatePerson(String personId, PersonDTO data) {
        Optional<Person> person = repository.findById(personId);

        if (person.isPresent()) {
            Person updatedPerson = person.get();

            if (data != null) {
                if (data.fullName() != null && !data.fullName().isEmpty()) {
                    updatedPerson.setFullName(data.fullName());
                }
                if (data.tagName() != null && !data.tagName().isEmpty()) {
                    updatedPerson.setTagName(data.tagName());
                }
                if (data.workField() != null && !data.workField().isEmpty()) {
                    updatedPerson.setWorkField(data.workField());
                }
                if (data.cpf() != null && !data.cpf().isEmpty()) {
                    updatedPerson.setCpf(data.cpf());
                }
                if (data.email() != null && !data.email().isEmpty()) {
                    updatedPerson.setEmail(data.email());
                }
                if (data.phoneNumber() != null && !data.phoneNumber().isEmpty()) {
                    updatedPerson.setPhoneNumber(data.phoneNumber());
                }
                if (data.address() != null && !data.address().isEmpty()) {
                    updatedPerson.setAddress(data.address());
                }
                if (data.postalCode() != null && !data.postalCode().isEmpty()) {
                    updatedPerson.setPostalCode(data.postalCode());
                }
            }
            return repository.save(updatedPerson);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public void deletePerson(String personId) {
        Optional<Person> person = repository.findById(personId);

        if (person.isPresent()) {
            repository.deleteById(personId);
        } else {
            throw new EntityNotFoundException();
        }
    }

}

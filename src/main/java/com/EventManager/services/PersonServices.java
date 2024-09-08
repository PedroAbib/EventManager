package com.EventManager.services;

import com.EventManager.entities.Person;
import com.EventManager.entities.PersonRecord;
import com.EventManager.repositories.PersonRepository;
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

    public Person addPerson(PersonRecord data) {
        Person newPerson = new Person(data);
        return repository.save(newPerson);
    }

    // Atualizar as informações de uma pessoa
    public Person updatePerson(String personId, PersonRecord data) {
        Optional<Person> person = repository.findById(personId);

        if (person.isPresent()) {
            Person updatedPerson = person.get();

            if (data != null) {
                updatedPerson.setFullName(data.fullName());
                updatedPerson.setCpf(data.cpf());
                updatedPerson.setPhoneNumber(data.phoneNumber());
                updatedPerson.setPostalCode(data.postalCode());
            }
            repository.save(updatedPerson);
        }

        return null;
    }

    // Deletar uma pessoa
}

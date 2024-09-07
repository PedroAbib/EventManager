package com.EventManager.services;

import com.EventManager.entities.Person;
import com.EventManager.entities.PersonRecord;
import com.EventManager.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {
    @Autowired
    private PersonRepository repository;

    // Ler todas as pessoas cadastradas
    public List<Person> getAllPerson() {
        return repository.findAll();
    }

    // Adicionar uma pessoa
    public Person addPerson(PersonRecord data) {
        Person newPerson = new Person(data);
        return repository.save(newPerson);
    }
    // Ler as informações de uma pessoa

    // Atualizar as informações de uma pessoa

    // Deletar uma pessoa
}

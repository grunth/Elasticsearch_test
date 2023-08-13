package com.example.demo.service;

import com.example.demo.document.PersonDocument;
import com.example.demo.repository.PersonDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonDocumentRepository repository;

    @Autowired
    public PersonService(PersonDocumentRepository repository) {
        this.repository = repository;
    }

    public void save(final PersonDocument personDocument) {
        repository.save(personDocument);
    }

    public PersonDocument findById(final String id) {
        return repository.findById(id).orElse(null);
    }
}

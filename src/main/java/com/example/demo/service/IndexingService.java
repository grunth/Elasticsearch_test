package com.example.demo.service;

import com.example.demo.document.PersonDocument;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonDocumentRepository;
import com.example.demo.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndexingService {

    private final PersonDocumentRepository personDocumentRepository;
    private final PersonRepository personRepository;

    @Autowired
    public IndexingService(PersonDocumentRepository personDocumentRepository, PersonRepository personRepository) {
        this.personDocumentRepository = personDocumentRepository;
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void indexPersons() {
        List<Person> persons = personRepository.findAll();
        List<PersonDocument> productDocuments = persons.stream()
                .map(this::convertToPersonDocument)
                .toList();
        personDocumentRepository.saveAll(productDocuments);
    }

    private PersonDocument convertToPersonDocument(Person person) {
        PersonDocument personDocument = new PersonDocument();
        personDocument.setId(person.getId());
        personDocument.setName(person.getName());
        return personDocument;
    }
}

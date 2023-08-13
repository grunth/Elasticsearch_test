package com.example.demo.controller;

import com.example.demo.document.PersonDocument;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody final PersonDocument personDocument) {
        service.save(personDocument);
    }

    @GetMapping("/{id}")
    public PersonDocument findById(@PathVariable final String id) {
        return service.findById(id);
    }
}

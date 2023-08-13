package com.example.demo.repository;

import com.example.demo.document.PersonDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonDocumentRepository extends ElasticsearchRepository<PersonDocument, String> {
}

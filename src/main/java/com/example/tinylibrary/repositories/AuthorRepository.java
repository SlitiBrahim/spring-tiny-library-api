package com.example.tinylibrary.repositories;

import com.example.tinylibrary.models.Author;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface AuthorRepository extends Neo4jRepository<Author, Long> {

}

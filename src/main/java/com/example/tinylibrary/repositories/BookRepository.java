package com.example.tinylibrary.repositories;

import com.example.tinylibrary.models.Book;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository extends Neo4jRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByReference(String reference);
    List<Book> findByReleaseDate(Integer releaseDate);

    /**
     * Get books authored by a certain author by matching name param with author firstname + lastname.
     * This method allows case insensitive searches by setting param name and author firstname and
     * lastname to lowercase.
     * @param name Full name (firstname + lastname) of the author
     * @return Books
     */
    @Query("MATCH(n:Book)<-[:AUTHORED]-(a:Author)" +
            "WHERE (toLower(a.firstname) + \" \" + toLower(a.lastname) = toLower($name))" +
            "RETURN n")
    List<Book> getBooksAuthoredBy(@Param("name") String name);
}

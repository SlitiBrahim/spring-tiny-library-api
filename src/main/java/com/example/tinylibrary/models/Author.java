package com.example.tinylibrary.models;

        import org.neo4j.ogm.annotation.GeneratedValue;
        import org.neo4j.ogm.annotation.Id;
        import org.neo4j.ogm.annotation.NodeEntity;
        import org.neo4j.ogm.annotation.Relationship;

        import java.util.ArrayList;
        import java.util.List;

        import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    // An Author owns 1 or multiple Book
    // Author 1->N Book.
    @Relationship(type="AUTHORED", direction = OUTGOING)
    private final List<Book> books = new ArrayList<>();

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

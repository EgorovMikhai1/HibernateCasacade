package com.example.hibernatecasacde.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * orphanRemoval=true
     * применяется только к дочерним сущностям,
     * которые были удалены из коллекции родительской
     * сущности. Если дочерняя сущность становится
     * "сиротой" (то есть она больше не связана с
     * родительской сущностью), то она удаляется из
     * базы данных. Это происходит в момент сохранения
     * или обновления родительской сущности.
     */
    @JsonBackReference
    @OneToMany(mappedBy = "author", orphanRemoval = true)
    private Set<Book> books;

    public Author() {
    }

    public Author(Long id, String name, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
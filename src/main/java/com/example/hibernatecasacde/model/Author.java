package com.example.hibernatecasacde.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
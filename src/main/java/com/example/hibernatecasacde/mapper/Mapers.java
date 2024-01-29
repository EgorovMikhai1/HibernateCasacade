package com.example.hibernatecasacde.mapper;

import com.example.hibernatecasacde.dto.CreateAuthorPersistDto;
import com.example.hibernatecasacde.model.Author;
import com.example.hibernatecasacde.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
@Component
public interface Mapers {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "title", target = "books", qualifiedByName = "titleToBook")
    Author toEntity(CreateAuthorPersistDto dto);

    @Named("titleToBook")
    default Set<Book> titleToBook(String title) {
        if (title == null) {
            return Collections.emptySet();
        }
        Set<Book> books = new HashSet<>();
        Book book = new Book();
        book.setTitle(title);
        books.add(book);
        return books;
    }
}
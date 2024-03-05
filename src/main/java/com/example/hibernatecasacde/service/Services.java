package com.example.hibernatecasacde.service;

import com.example.hibernatecasacde.dto.CreateAuthorPersistDto;
import com.example.hibernatecasacde.exceptions.AuthorNotFoundException;
import com.example.hibernatecasacde.exceptions.error_messages.ErrorMessages;
import com.example.hibernatecasacde.mapper.Mapers;
import com.example.hibernatecasacde.model.Author;
import com.example.hibernatecasacde.model.Book;
import com.example.hibernatecasacde.repo.Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class Services {

    private final Repo repo;
    private final Mapers mapers;

    @Transactional
    public Author createAuthor(CreateAuthorPersistDto dto) {
        Author author = new Author();
        //repo.findByName(dto.getName());
//        if (author != null) {
//            throw new AuthorAlreadyExistException(ErrorMessages.AUTHOR_ALREADY_EXIST);
//        } else {

            Book book = new Book();

            Set<Book> setBOOK = new HashSet<>();
            setBOOK.add(book);

            book.setTitle(dto.getTitle());
            author.setName(dto.getName());

            author.setBooks(setBOOK);
            repo.saveAndFlush(mapers.toEntity(dto));

        //}
        return author;
    }

    public void deleteById(String id) {
        repo.deleteById(Integer.parseInt(id));
    }

    public Author getById(int id) {
        return repo.findById(id).orElseThrow(() -> new AuthorNotFoundException(ErrorMessages.AUTHOR_NOT_FOUND));
    }
}
package com.example.hibernatecasacde.controller;

import com.example.hibernatecasacde.dto.CreateAuthorPersistDto;
import com.example.hibernatecasacde.model.Author;
import com.example.hibernatecasacde.service.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class Controller {

    private final Services services;

    /**
     * Простой гет запрос для @ExceptionHandler
     */
    @GetMapping(value = "get/{id}")
    public Author getAuthor(@PathVariable(name = "id") int id) {
        return services.getById(id);
    }

    /**
     * При сохранении объекта Author
     * с помощью authorRepository.save(author),
     * все связанные объекты Book, которые находятся
     * в его коллекции books, также автоматически сохраняются
     * в базе данных.
     */
    @PostMapping(value = "persist")
    public void createA(@RequestBody CreateAuthorPersistDto dto) {
        services.createAuthor(dto);
    }

    /**
     * Этот каскадный тип применяет операцию remove() ко
     * всем связанным сущностям, когда родительская сущность удаляется.
     * Если у вас есть автор с книгами и вы удаляете автора,
     * все его книги также будут удалены из базы данных, независимо
     * от того, есть ли у книг другие связи или нет.
     * Это как массовое удаление: удаление одной сущности (родительской)
     * автоматически приведет к удалению всех связанных сущностей (детей).
     */
    @DeleteMapping(value = "delete/{id}")
    public void deleteAById(@PathVariable(name = "id") String id) {
        services.deleteById(id);
    }

//    @ExceptionHandler(AuthorNotFoundException.class)
//    public ResponseEntity<String> handleArithmeticException(AuthorNotFoundException ex) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .headers(headers)
//                .body(ex.getMessage());
//    }
}
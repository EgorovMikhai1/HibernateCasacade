package com.example.hibernatecasacde.controller;

import com.example.hibernatecasacde.dto.CreateAuthorPersistDto;
import com.example.hibernatecasacde.model.Author;
import com.example.hibernatecasacde.service.Services;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "")
@RequiredArgsConstructor
public class Controller {

    private final Services services;

    /**
     * Простой гет запрос для @ExceptionHandler
     */
    @GetMapping(value = "/get/{id}")
    @Operation(summary = "Что делает метод тезисно",
            description = "Описывает более подробно что будет в качестве ответа",
            tags = "Тут можно одним словом описать к какой группе запросов это относится, например АВТОРЫ",
            externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "нашли"),
                    @ApiResponse(responseCode = "404", description = "не нашли")
            },
            security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },
            hidden = false
    )
    public Author getAuthorById(@PathVariable(name = "id") int id) {
        return services.getById(id);
    }

    /**
     * При сохранении объекта Author
     * с помощью authorRepository.save(author),
     * все связанные объекты Book, которые находятся
     * в его коллекции books, также автоматически сохраняются
     * в базе данных.
     */

    @Operation(summary = "Что делает метод",
            description = "Описывает более подробно что будет в качестве ответа",
            tags = "Тут можно одним словом описать к какой группе запросов это относится, например АВТОРЫ",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные автора для сохранения",
                    required = true, //обязательно ли тело запроса для сохранения
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateAuthorPersistDto.class) // указывает на класс,
                            // который служит примером реализации схемы для объекта API
                    )
            )
    )
    @PostMapping(value = "/persist")
    public ResponseEntity<Author> createA(@RequestBody CreateAuthorPersistDto dto) {
        return new ResponseEntity<>(services.createAuthor(dto), HttpStatus.CREATED);
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
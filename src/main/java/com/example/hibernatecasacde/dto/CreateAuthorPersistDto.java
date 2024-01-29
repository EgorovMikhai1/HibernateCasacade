package com.example.hibernatecasacde.dto;

public class CreateAuthorPersistDto {
    String name;
    String title;

    public CreateAuthorPersistDto() {
    }

    public CreateAuthorPersistDto(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
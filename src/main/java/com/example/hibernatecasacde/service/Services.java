package com.example.hibernatecasacde.service;

import com.example.hibernatecasacde.dto.CreateAuthorPersistDto;
import com.example.hibernatecasacde.mapper.Mapers;
import com.example.hibernatecasacde.model.Author;
import com.example.hibernatecasacde.repo.Repo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Services {

    private final Repo repo;
    private final Mapers mapers;

    @Transactional
    public Author createAuthor(CreateAuthorPersistDto dto) {
        return repo.saveAndFlush(mapers.toEntity(dto));
    }


    public void deleteById(String id) {
        repo.deleteById(Integer.parseInt(id));
    }
}

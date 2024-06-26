package com.example.hibernatecasacde.repo;

import com.example.hibernatecasacde.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Author, Integer> {

    Author findByName(String authorName);
}

package com.example.Book.Library.API.repository;


import com.example.Book.Library.API.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

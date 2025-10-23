package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.AuthorDTO;
import com.example.Book.Library.API.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<AuthorDTO> getAuthors();
    Optional<AuthorDTO> getAuthorById(Long id);
    Author createAuthor(AuthorDTO authorDTO);
    Optional<Author> updateAuthor(Long id, AuthorDTO authorDTO);
    void deleteAuthor(Long id);
}

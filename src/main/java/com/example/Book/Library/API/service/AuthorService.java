package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> getAuthors();
}

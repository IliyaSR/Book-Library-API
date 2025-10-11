package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.BookResponseDTO;

import java.util.List;

public interface BookService {
    List<BookResponseDTO> getBooks();
    BookResponseDTO getBook(Long id);
}

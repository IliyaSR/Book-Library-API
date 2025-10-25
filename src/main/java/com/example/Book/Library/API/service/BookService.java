package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.BookRequestDTO;
import com.example.Book.Library.API.dto.BookResponseDTO;

import java.util.List;

public interface BookService {
    List<BookResponseDTO> getBooks();
    BookResponseDTO getBook(Long id);
    BookRequestDTO createBook(BookRequestDTO bookDTO);
    BookRequestDTO updateBook(Long id, BookRequestDTO bookDTO);
    void deleteBook(Long id);
}

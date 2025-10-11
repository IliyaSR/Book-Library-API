package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.AuthorDTO;
import com.example.Book.Library.API.dto.BookResponseDTO;
import com.example.Book.Library.API.dto.CategoryDTO;
import com.example.Book.Library.API.entity.Book;
import com.example.Book.Library.API.repository.BookRepository;
import com.example.Book.Library.API.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponseDTO> getBooks() {
        List<Book> books = bookRepository.findAll();

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found");
        }

        return books.stream()
                .map(book -> new BookResponseDTO(
                                book.getTitle(),
                                book.getDescription(),
                                book.getPublishYear(),
                                new AuthorDTO(
                                        book.getAuthor().getName(),
                                        book.getAuthor().getCountry()
                                ),
                                new CategoryDTO(
                                        book.getCategory().getName()
                                )
                        )
                ).collect(Collectors.toList());
    }

    public BookResponseDTO getBook(Long id) {
        return bookRepository.findById(id)
                .map(book -> new BookResponseDTO(
                        book.getTitle(),
                        book.getDescription(),
                        book.getPublishYear(),
                        new AuthorDTO(
                                book.getAuthor().getName(),
                                book.getAuthor().getCountry()
                        ),
                        new CategoryDTO(
                                book.getCategory().getName()
                        )
                ))
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
    }
}

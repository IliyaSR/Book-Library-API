package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.AuthorDTO;
import com.example.Book.Library.API.dto.BookResponseDTO;
import com.example.Book.Library.API.dto.CategoryDTO;
import com.example.Book.Library.API.entity.Book;
import com.example.Book.Library.API.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<List<BookResponseDTO>> getBooks() {
        return Optional.of(bookRepository.findAll().stream()
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
                ).collect(Collectors.toList()));
    }

    public Optional<BookResponseDTO> getBook(Long id) {
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
                                book.getAuthor().getName()
                        )
                ));
    }
}

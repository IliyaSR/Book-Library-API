package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.AuthorDTO;
import com.example.Book.Library.API.dto.BookRequestDTO;
import com.example.Book.Library.API.dto.BookResponseDTO;
import com.example.Book.Library.API.dto.CategoryDTO;
import com.example.Book.Library.API.entity.Book;
import com.example.Book.Library.API.repository.AuthorRepository;
import com.example.Book.Library.API.repository.BookRepository;
import com.example.Book.Library.API.exception.ResourceNotFoundException;
import com.example.Book.Library.API.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
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

    public BookRequestDTO createBook(BookRequestDTO bookDTO) {

        bookRepository.save(
                new Book(
                        bookDTO.getTitle(),
                        bookDTO.getDescription(),
                        bookDTO.getPublishYear(),
                        authorRepository.findById(bookDTO.getAuthorId())
                                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + bookDTO.getAuthorId())),
                        categoryRepository.findById(bookDTO.getCategoryId())
                                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + bookDTO.getCategoryId()))

                )
        );

        return bookDTO;
    }
}

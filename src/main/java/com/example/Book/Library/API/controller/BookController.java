package com.example.Book.Library.API.controller;

import com.example.Book.Library.API.dto.BookRequestDTO;
import com.example.Book.Library.API.dto.BookResponseDTO;
import com.example.Book.Library.API.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/books")
public class BookController {

    private final BookServiceImpl bookService;

    @Autowired
    BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<?> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createBook(@RequestBody BookRequestDTO bookDTO){
        return ResponseEntity.ok(bookService.createBook(bookDTO));
    }
}

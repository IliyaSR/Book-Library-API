package com.example.Book.Library.API.controller;

import com.example.Book.Library.API.dto.AuthorDTO;
import com.example.Book.Library.API.service.AuthorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    @Autowired
    AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAuthors() {
        return ResponseEntity.ok(authorService.getAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.createAuthor(authorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.updateAuthor(id, authorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

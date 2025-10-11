package com.example.Book.Library.API.controller;

import com.example.Book.Library.API.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        if (!authorService.getAuthors().isEmpty()){
            return ResponseEntity.ok(authorService.getAuthors());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

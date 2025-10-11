package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.AuthorDTO;
import com.example.Book.Library.API.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDTO> getAuthors() {
        return authorRepository.findAll().stream()
                .map(author -> new AuthorDTO(
                        author.getName(),
                        author.getCountry()
                )).toList();

    }
}

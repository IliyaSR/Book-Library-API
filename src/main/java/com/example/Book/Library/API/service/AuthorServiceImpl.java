package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.AuthorDTO;
import com.example.Book.Library.API.exception.ResourceNotFoundException;
import com.example.Book.Library.API.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDTO> getAuthors() {
        List<AuthorDTO> authors = authorRepository.findAll().stream()
                .map(author -> new AuthorDTO(
                        author.getName(),
                        author.getCountry()
                )).toList();

        if(authors.isEmpty()){
            throw new ResourceNotFoundException("No authors found!");
        }else{
            return authors;
        }
    }

    @Override
    public Optional<AuthorDTO> getAuthorById(Long id) {
        Optional<AuthorDTO> authorDTO = authorRepository.findById(id)
                .map(author -> new AuthorDTO(
                        author.getName(),
                        author.getCountry()
                ));
        if (authorDTO.isPresent()) {
            return authorDTO;
        } else {
            throw new ResourceNotFoundException("Author not found with id: " + id);
        }
    }
}

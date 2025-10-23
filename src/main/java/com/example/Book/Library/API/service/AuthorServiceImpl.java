package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.AuthorDTO;
import com.example.Book.Library.API.entity.Author;
import com.example.Book.Library.API.exception.ResourceNotFoundException;
import com.example.Book.Library.API.repository.AuthorRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        if (authors.isEmpty()) {
            throw new ResourceNotFoundException("No authors found!");
        } else {
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

    @Override
    public Author createAuthor(AuthorDTO authorDTO) {
        try {
            Author author = new Author(
                    authorDTO.getName(),
                    authorDTO.getCountry()
            );

            return authorRepository.save(author);
        } catch (ConstraintViolationException ex) {
            throw new IllegalArgumentException(
                    ex.getConstraintViolations()
                            .stream()
                            .map(ev -> ev.getPropertyPath() + ": " + ev.getMessage())
                            .collect(Collectors.joining(", "))
            );
        }
    }

    @Override
    public Optional<Author> updateAuthor(Long id, AuthorDTO authorDTO) {

        Author author = authorRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("The author doesn't exist!"));


        author.setName(authorDTO.getName());
        author.setCountry(authorDTO.getCountry());


        authorRepository.save(author);

        return Optional.of(author);
    }
}

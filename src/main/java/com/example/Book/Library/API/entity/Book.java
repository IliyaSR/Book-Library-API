package com.example.Book.Library.API.entity;

import com.example.Book.Library.API.dto.AuthorDTO;
import com.example.Book.Library.API.dto.CategoryDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.time.Year;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    public static final int CURRENT_YEAR = 2025;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The field is required!")
    @Size(min = 2, max = 100)
    private String title;

    @Size(max = 500)
    private String description;

    @NotNull(message = "This field is required!")
    @Min(1400)
    @Max(value = CURRENT_YEAR)
    private int publishYear;

    @NotNull(message = "The field is required! Must have author with this id!")
    @ManyToOne
    private Author author;

    @NotNull(message = "The field is required! Must have category with this id!")
    @ManyToOne
    private Category category;

    public Book(String title, String description, int publishYear, Author author, Category category) {
        this.title = title;
        this.description = description;
        this.publishYear = publishYear;
        this.author = author;
        this.category = category;
    }

    public String toString() {
        return String.format("Name of Book: %s", title);
    }

}

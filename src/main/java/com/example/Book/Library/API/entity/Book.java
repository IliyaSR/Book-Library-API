package com.example.Book.Library.API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "The field is required!")
    @Min(1400)
    @Max(value = CURRENT_YEAR)
    private int publishYear;

    @NotBlank(message = "The field is required! Must have author with this id!")
    @ManyToOne
    private Author author;

    @NotBlank(message = "The field is required! Must have category with this id!")
    @ManyToOne
    private Category category;

}

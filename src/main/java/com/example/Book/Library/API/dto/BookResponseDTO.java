package com.example.Book.Library.API.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {

    private String title;
    private String description;
    private int publishYear;
    private AuthorDTO author;
    private CategoryDTO category;
}

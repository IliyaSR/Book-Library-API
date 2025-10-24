package com.example.Book.Library.API.dto;

import com.example.Book.Library.API.entity.Author;
import com.example.Book.Library.API.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {

    private String title;
    private String description;
    private int publishYear;
    private Long authorId;
    private Long categoryId;
}

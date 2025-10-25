package com.example.Book.Library.API.dto;

import com.example.Book.Library.API.entity.Author;
import com.example.Book.Library.API.entity.Category;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.example.Book.Library.API.entity.Book.CURRENT_YEAR;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {

    @NotBlank(message = "The field is required!")
    @Size(min = 2, max = 100)
    private String title;

    @Size(max = 500)
    private String description;

    @NotNull(message = "This field is required!")
    @Min(1400)
    @Max(value = CURRENT_YEAR)
    private int publishYear;
    private Long authorId;
    private Long categoryId;
}

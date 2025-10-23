package com.example.Book.Library.API.dto;

import com.example.Book.Library.API.entity.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDTO {

    @NotBlank(message = "This field is required!")
    @Size(min = 2, max = 60, message = "The field must be between 2 and 60 characters!")
    private String name;

    @Size(max = 60)
    private String country;
}

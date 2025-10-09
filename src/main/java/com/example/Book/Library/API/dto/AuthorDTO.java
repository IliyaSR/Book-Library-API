package com.example.Book.Library.API.dto;

import com.example.Book.Library.API.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDTO {

    private String name;
    private String country;
}

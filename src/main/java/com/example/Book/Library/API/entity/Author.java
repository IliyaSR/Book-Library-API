package com.example.Book.Library.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "This field is required!")
    @Size(min = 2, max = 60)
    private String name;

    @Size(max = 60)
    private String country;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String toString() {
        return String.format("Name of Author: %s", name);
    }
}

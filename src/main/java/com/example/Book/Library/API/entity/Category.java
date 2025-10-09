package com.example.Book.Library.API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "This field is required!")
    @Size(min = 2, max = 50)
    @UniqueElements
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Book> books;
}

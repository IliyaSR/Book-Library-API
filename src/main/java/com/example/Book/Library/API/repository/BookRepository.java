package com.example.Book.Library.API.repository;

import com.example.Book.Library.API.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

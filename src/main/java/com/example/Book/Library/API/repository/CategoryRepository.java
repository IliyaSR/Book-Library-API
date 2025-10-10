package com.example.Book.Library.API.repository;

import com.example.Book.Library.API.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

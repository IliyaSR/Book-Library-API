package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.CategoryDTO;
import com.example.Book.Library.API.entity.Category;
import com.example.Book.Library.API.exception.ResourceNotFoundException;
import com.example.Book.Library.API.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategories() {
        List<Category> categories = categoryRepository.findAll();

        if (categories.isEmpty()) {
            throw new ResourceNotFoundException("Categories not found");
        }

        return categories.stream()
                .map(category -> new CategoryDTO(
                        category.getName()
                )).toList();
    }
}

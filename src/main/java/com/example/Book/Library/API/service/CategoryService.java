package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.CategoryDTO;
import com.example.Book.Library.API.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<CategoryDTO> getCategories();

    public Category createCategory(CategoryDTO categoryDTO);
}

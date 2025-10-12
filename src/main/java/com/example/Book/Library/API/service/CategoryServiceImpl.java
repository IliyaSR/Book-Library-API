package com.example.Book.Library.API.service;

import com.example.Book.Library.API.dto.CategoryDTO;
import com.example.Book.Library.API.entity.Book;
import com.example.Book.Library.API.entity.Category;
import com.example.Book.Library.API.exception.ResourceNotFoundException;
import com.example.Book.Library.API.repository.CategoryRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
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

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {

        try {
            Category category = new Category(
                    categoryDTO.getName()
            );
            return categoryRepository.save(category);
        } catch (ConstraintViolationException ex) {
            throw new IllegalArgumentException(ex.getConstraintViolations()
                    .stream()
                    .map(ev -> ev.getPropertyPath() + ": " + ev.getMessage())
                    .collect(Collectors.joining(", "))
            );
        }
    }

    public void deleteCategory(Long id) {

        try {
            Optional<Category> category = categoryRepository.findById(id);
            if (category.isPresent()) {
                categoryRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException("Category with id " + id + " not found!");
            }
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException(ex.getMessage());
        }
    }
}

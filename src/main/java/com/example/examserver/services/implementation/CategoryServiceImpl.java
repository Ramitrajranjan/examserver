package com.example.examserver.services.implementation;

import com.example.examserver.model.exam.Category;
import com.example.examserver.repository.CategoryRepository;
import com.example.examserver.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category)
    {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories()
    {
        return new LinkedHashSet<>( this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {

        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category=new Category();
        category.setId(categoryId);
        this.categoryRepository.deleteById(category.getId());
    }
}

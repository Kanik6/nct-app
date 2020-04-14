package com.ort.ortnct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService
{
    @Autowired
    CategoryRepository categoryRepository;

    public Category createCategory(Category category)
    {
        return categoryRepository.save(category);
    }
}

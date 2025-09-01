package com.praticalCRUD.Pratical.CRUD.Services;

import com.praticalCRUD.Pratical.CRUD.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

}

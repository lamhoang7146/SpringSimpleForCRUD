package com.praticalCRUD.Pratical.CRUD.Services;

import com.praticalCRUD.Pratical.CRUD.Dtos.ApiResponseDto;
import com.praticalCRUD.Pratical.CRUD.Models.Category;
import com.praticalCRUD.Pratical.CRUD.Repositories.CategoryRepository;
import com.praticalCRUD.Pratical.CRUD.Ultils.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<ApiResponseDto<List<Category>>> getCategories() {
        return ResponseHelper.success(this.categoryRepository.findAll(), "Get categories successfully!", HttpStatus.OK);
    }

}

package com.praticalCRUD.Pratical.CRUD.Services;

import com.praticalCRUD.Pratical.CRUD.Dtos.ApiResponseDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Requests.CreateCategoryDto;
import com.praticalCRUD.Pratical.CRUD.Models.Category;
import com.praticalCRUD.Pratical.CRUD.Repositories.CategoryRepository;
import com.praticalCRUD.Pratical.CRUD.Ultils.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<ApiResponseDto<List<Category>>> getCategories() {
        return ResponseHelper.success(this.categoryRepository.findAll(), "Get categories successfully!", HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseDto<Category>> createCategory(CreateCategoryDto createCategoryDto) {
        Optional<Category> isNameExists = this.categoryRepository.findByName(createCategoryDto.getName());

        if (isNameExists.isPresent()) {
            return ResponseHelper.fail(null, "Name category is exists!", HttpStatus.BAD_REQUEST);
        }

        Category category = new Category();
        category.setName(createCategoryDto.getName());
        category.setDescription(createCategoryDto.getDescription());
        return ResponseHelper.success(this.categoryRepository.save(category), "Create category successfully!", HttpStatus.OK);
    }

}

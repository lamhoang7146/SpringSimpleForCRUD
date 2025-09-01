package com.praticalCRUD.Pratical.CRUD.Services;

import com.praticalCRUD.Pratical.CRUD.Dtos.ApiResponseDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Requests.CreateCategoryDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Requests.UpdateCategoryDto;
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

    public ResponseEntity<ApiResponseDto<Category>> getCategoryById(String id) {
        Optional<Category> isCategoryExists = this.categoryRepository.findById(id);

        if (isCategoryExists.isEmpty()) {
            return ResponseHelper.fail(null, "Category not found!", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.success(isCategoryExists.get(), "Get category by id: ", HttpStatus.OK);
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

    public ResponseEntity<ApiResponseDto<Category>> updateCategory(String id, UpdateCategoryDto updateCategoryDto) {
        Optional<Category> isCategoryExists = this.categoryRepository.findById(id);

        if (isCategoryExists.isEmpty()) {
            return ResponseHelper.fail(null, "Category not found!", HttpStatus.BAD_REQUEST);
        }

        Category category = isCategoryExists.get();

        if (updateCategoryDto.getName() != null &&
                !updateCategoryDto.getName().equals(category.getName()) &&
                this.categoryRepository.findByName(updateCategoryDto.getName()).isPresent()
        ) {
            return ResponseHelper.fail(null, "Name category is exists!", HttpStatus.BAD_REQUEST);
        }

        if(updateCategoryDto.getName() != null){
            category.setName(updateCategoryDto.getName());
        }

        if (updateCategoryDto.getDescription() != null) {
            category.setDescription(updateCategoryDto.getDescription());
        }

        Category updatedCategory = this.categoryRepository.save(category);
        return ResponseHelper.success(updatedCategory, "Update category successfully!", HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseDto<Object>> deleteCategory(String id) {
        Optional<Category> isCategoryExists = this.categoryRepository.findById(id);
        if (isCategoryExists.isEmpty()) {
            return ResponseHelper.fail(null, "Category not found!", HttpStatus.BAD_REQUEST);
        }
        this.categoryRepository.delete(isCategoryExists.get());
        return ResponseHelper.success(null, "Delete category successfully!", HttpStatus.OK);
    }

}

package com.praticalCRUD.Pratical.CRUD.Controllers;

import com.praticalCRUD.Pratical.CRUD.Dtos.ApiResponseDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Requests.CategoryFilterDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Requests.CreateCategoryDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Requests.UpdateCategoryDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Responses.CategoryWithCountDto;
import com.praticalCRUD.Pratical.CRUD.Models.Category;
import com.praticalCRUD.Pratical.CRUD.Services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<CategoryWithCountDto>>> getCategories(CategoryFilterDto categoryFilterDto) {
        return this.categoryService.getCategories(categoryFilterDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Category>> getCategoryById(@PathVariable String id) {
        return this.categoryService.getCategoryById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<Category>> createCategory(@Valid @RequestBody CreateCategoryDto createCategoryDto){
        return this.categoryService.createCategory(createCategoryDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Category>> updateCategory(@PathVariable String id, @Valid @RequestBody UpdateCategoryDto updateCategoryDto) {
        return this.categoryService.updateCategory(id, updateCategoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Object>> deleteCategory(@PathVariable String id) {
        return this.categoryService.deleteCategory(id);
    }

}

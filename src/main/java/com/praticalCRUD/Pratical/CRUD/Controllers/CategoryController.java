package com.praticalCRUD.Pratical.CRUD.Controllers;

import com.praticalCRUD.Pratical.CRUD.Dtos.ApiResponseDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Requests.CreateCategoryDto;
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
    public ResponseEntity<ApiResponseDto<List<Category>>> getCategories() {
        return this.categoryService.getCategories();
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<Category>> createCategory(@Valid @RequestBody CreateCategoryDto createCategoryDto){
        return this.categoryService.createCategory(createCategoryDto);
    }
}

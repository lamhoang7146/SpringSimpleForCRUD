package com.praticalCRUD.Pratical.CRUD.Controllers;

import com.praticalCRUD.Pratical.CRUD.Dtos.ApiResponseDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.ProductDto.Requests.CreateProductDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.ProductDto.Requests.ProductFilterDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.ProductDto.Requests.UpdateProductDto;
import com.praticalCRUD.Pratical.CRUD.Models.Category;
import com.praticalCRUD.Pratical.CRUD.Models.Product;
import com.praticalCRUD.Pratical.CRUD.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{categoryId}/category")
    public ResponseEntity<ApiResponseDto<List<Product>>> getProductByCategoryId(@PathVariable Category categoryId, ProductFilterDto productFilterDto) {
        return this.productService.getProductsByCategoryId(categoryId, productFilterDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Product>> getProductById(@PathVariable String id) {
        return this.productService.getProductById(id);
    }

    @PostMapping("/{categoryId}")
    public ResponseEntity<ApiResponseDto<Product>> createProduct(
            @PathVariable Category categoryId,
            @Valid @RequestBody CreateProductDto createProductDto
    ) {
        return productService.createProduct(categoryId, createProductDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Product>> updateProduct(@PathVariable String id, @Valid @RequestBody UpdateProductDto updateProductDto) {
        return this.productService.updateProduct(id, updateProductDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Object>> deleteProduct(@PathVariable String id) {
        return this.productService.deleteProduct(id);
    }

}

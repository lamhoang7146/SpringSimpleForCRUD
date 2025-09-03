package com.praticalCRUD.Pratical.CRUD.Services;

import com.praticalCRUD.Pratical.CRUD.Dtos.ApiResponseDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.ProductDto.Requests.CreateProductDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.ProductDto.Requests.ProductFilterDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.ProductDto.Requests.UpdateProductDto;
import com.praticalCRUD.Pratical.CRUD.Models.Category;
import com.praticalCRUD.Pratical.CRUD.Models.Product;
import com.praticalCRUD.Pratical.CRUD.Repositories.ProductRepository;
import com.praticalCRUD.Pratical.CRUD.Ultils.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<ApiResponseDto<List<Product>>> getProductsByCategoryId(Category categoryId, ProductFilterDto productFilterDto) {
        return ResponseHelper.success(this.productRepository.filterProducts(
                productFilterDto.getName(),
                productFilterDto.getStatus(),
                productFilterDto.getCreatedAtFrom(),
                productFilterDto.getCreatedAtTo(),
                categoryId
        ), "Get products successfully!", HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseDto<Product>> getProductById(String id) {
        Optional<Product> productExists = productRepository.findById(id);

        if (!productExists.isPresent()) {
            return ResponseHelper.fail(null, "Product not found!", HttpStatus.CONFLICT);
        }

        return ResponseHelper.success(productExists.get(), "Get product successfully!", HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseDto<Product>> createProduct(Category category, CreateProductDto createProductDto) {
        Optional<Product> productIfExists = productRepository.findByName(createProductDto.getName());

        if (productIfExists.isPresent()) {
            return ResponseHelper.fail(null, "Name product is exists!", HttpStatus.CONFLICT);
        }

        Product product = new Product();
        product.setName(createProductDto.getName());
        product.setPrice(createProductDto.getPrice());
        product.setStock(createProductDto.getStock());

        if (createProductDto.getStatus() != null) {
            product.setStatus(createProductDto.getStatus());
        }

        product.setDescription(createProductDto.getDescription());
        product.setCategory(category);
        return ResponseHelper.success(this.productRepository.save(product), "Create product successfully!", HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseDto<Product>> updateProduct(String id, UpdateProductDto updateProductDto) {
        Optional<Product> productExists = productRepository.findById(id);

        if (!productExists.isPresent()) {
            return ResponseHelper.fail(null, "Product not found!", HttpStatus.CONFLICT);
        }

        Product product = productExists.get();
        if (updateProductDto.getName() != null &&
                !updateProductDto.getName().equals(product.getName()) &&
                this.productRepository.findByName(updateProductDto.getName()).isPresent()
        ) {
            return ResponseHelper.fail(null, "Name product is exists!", HttpStatus.CONFLICT);
        }

        product.setName(updateProductDto.getName());

        if (updateProductDto.getDescription() != null) {
            product.setDescription(updateProductDto.getDescription());
        }

        if (updateProductDto.getPrice() != null) {
            product.setPrice(updateProductDto.getPrice());
        }

        if (updateProductDto.getStock() != null) {
            product.setStock(updateProductDto.getStock());
        }

        if (updateProductDto.getStatus() != null) {
            product.setStatus(updateProductDto.getStatus());
        }

        return ResponseHelper.success(productRepository.save(product), "Update product successfully!", HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseDto<Object>> deleteProduct(String id) {
        Optional<Product> productExists = productRepository.findById(id);

        if (!productExists.isPresent()) {
            return ResponseHelper.fail(null, "Product not found!", HttpStatus.CONFLICT);
        }

        productRepository.delete(productExists.get());

        return ResponseHelper.success(null, "Delete product successfully!", HttpStatus.OK);

    }
}

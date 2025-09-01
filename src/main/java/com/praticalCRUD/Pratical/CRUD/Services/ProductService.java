package com.praticalCRUD.Pratical.CRUD.Services;

import com.praticalCRUD.Pratical.CRUD.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}

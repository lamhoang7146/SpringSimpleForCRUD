package com.praticalCRUD.Pratical.CRUD.Repositories;

import com.praticalCRUD.Pratical.CRUD.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

package com.praticalCRUD.Pratical.CRUD.Repositories;

import com.praticalCRUD.Pratical.CRUD.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findByName(String name);
}

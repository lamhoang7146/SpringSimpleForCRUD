package com.praticalCRUD.Pratical.CRUD.Repositories;

import com.praticalCRUD.Pratical.CRUD.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}

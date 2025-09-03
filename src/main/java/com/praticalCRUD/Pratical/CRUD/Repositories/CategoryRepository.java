package com.praticalCRUD.Pratical.CRUD.Repositories;

import com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Responses.CategoryWithCountDto;
import com.praticalCRUD.Pratical.CRUD.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findByName(String name);
    List<Category> findByNameContainingIgnoreCase(String name);

    @Query("SELECT new com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Responses.CategoryWithCountDto(" +
            "c.id, c.name, c.description, c.status, c.createdAt, COUNT(p)) " +
            "FROM Category c LEFT JOIN c.products p " +
            "WHERE (:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:status IS NULL OR c.status = :status) " +
            "AND (:createdAtFrom IS NULL OR c.createdAt >= :createdAtFrom) " +
            "AND (:createdAtTo IS NULL OR c.createdAt <= :createdAtTo) " +
            "GROUP BY c.id, c.name, c.description, c.status, c.createdAt")
    List<CategoryWithCountDto> filterCategoriesWithCount(
            @Param("name") String name,
            @Param("status") Boolean status,
            @Param("createdAtFrom") LocalDateTime createdAtFrom,
            @Param("createdAtTo") LocalDateTime createdAtTo
    );

}

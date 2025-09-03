package com.praticalCRUD.Pratical.CRUD.Repositories;

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

    @Query("SELECT c FROM Category c " +
            "WHERE (:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:status IS NULL OR c.status = :status) " +
            "AND (:createdAtFrom IS NULL OR c.createdAt >= :createdAtFrom) " +
            "AND (:createdAtTo IS NULL OR c.createdAt <= :createdAtTo)")
    List<Category> filterCategories(@Param("name") String name,
                                    @Param("status") Boolean status,
                                    @Param("createdAtFrom") LocalDateTime createdAtFrom,
                                    @Param("createdAtTo") LocalDateTime createdAtTo);
}

package com.praticalCRUD.Pratical.CRUD.Repositories;

import com.praticalCRUD.Pratical.CRUD.Models.Category;
import com.praticalCRUD.Pratical.CRUD.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByName(String name);

    List<Product> findByCategoryId(String categoryId);

    @Query("SELECT c FROM Product c " +
            "WHERE (:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:status IS NULL OR c.status = :status) " +
            "AND (:createdAtFrom IS NULL OR c.createdAt >= :createdAtFrom) " +
            "AND (:createdAtTo IS NULL OR c.createdAt <= :createdAtTo)" +
            "AND (:categoryId IS NULL OR c.category = :categoryId)")
    List<Product> filterProducts(@Param("name") String name,
                                 @Param("status") Boolean status,
                                 @Param("createdAtFrom") LocalDateTime createdAtFrom,
                                 @Param("createdAtTo") LocalDateTime createdAtTo,
                                 @Param("categoryId") Category categoryId);
}

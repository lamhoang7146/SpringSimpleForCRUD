package com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Responses;

import java.time.LocalDateTime;

public class CategoryWithCountDto {
    private String id;
    private String name;
    private String description;
    private Boolean status;
    private LocalDateTime createdAt;
    private Long productCount;

    public CategoryWithCountDto(String id, String name, String description,
                                Boolean status, LocalDateTime createdAt,
                                Long productCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.productCount = productCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }
}


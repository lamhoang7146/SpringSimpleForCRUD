package com.praticalCRUD.Pratical.CRUD.Dtos.CategoryDto.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateCategoryDto {
    @NotBlank(message = "Name category is required")
    @Size(min = 2, max = 20, message = "Name category at least 2 and not exceed 20 characters!")
    private String name;

    @NotBlank(message = "Description category is required")
    @Size(min = 3, max = 30, message = "Description category at least 3 and not exceed 30 characters!")
    private String description;

    private Boolean status;

    public CreateCategoryDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
}

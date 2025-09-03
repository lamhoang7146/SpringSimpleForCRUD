package com.praticalCRUD.Pratical.CRUD.Dtos.ProductDto.Requests;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class UpdateProductDto {
    @NotBlank(message = "Name product is required")
    @Size(min = 2, max = 20, message = "Name product at least 2 and not exceed 20 characters!")
    private String name;

    @NotBlank(message = "Description product is required")
    @Size(min = 3, max = 30, message = "Description product at least 3 and not exceed 30 characters!")
    private String description;

    private Boolean status;

    @NotNull(message = "Price product is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "Stock product is required")
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;

    public @NotBlank(message = "Name product is required") @Size(min = 2, max = 20, message = "Name product at least 2 and not exceed 20 characters!") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name product is required") @Size(min = 2, max = 20, message = "Name product at least 2 and not exceed 20 characters!") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Description product is required") @Size(min = 3, max = 30, message = "Description product at least 3 and not exceed 30 characters!") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description product is required") @Size(min = 3, max = 30, message = "Description product at least 3 and not exceed 30 characters!") String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public @NotNull(message = "Price product is required") @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0") BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price product is required") @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0") BigDecimal price) {
        this.price = price;
    }

    public @NotNull(message = "Stock product is required") @Min(value = 0, message = "Stock cannot be negative") Integer getStock() {
        return stock;
    }

    public void setStock(@NotNull(message = "Stock product is required") @Min(value = 0, message = "Stock cannot be negative") Integer stock) {
        this.stock = stock;
    }
}

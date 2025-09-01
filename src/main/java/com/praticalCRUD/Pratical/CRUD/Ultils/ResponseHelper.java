package com.praticalCRUD.Pratical.CRUD.Ultils;

import com.praticalCRUD.Pratical.CRUD.Dtos.ApiResponseDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.ApiStatusResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {
    public static <T> ResponseEntity<ApiResponseDto<T>> success(T data, String message, HttpStatus status){
        return ResponseEntity.status(status).body(
                new ApiResponseDto<>(
                        ApiStatusResponseDto.SUCCESS.name(),
                        data,
                        message,
                        status.value()
                )
        );
    }

    public static <T> ResponseEntity<ApiResponseDto<T>> fail(T data, String message, HttpStatus status){
        return ResponseEntity.status(status).body(
                new ApiResponseDto<>(
                        ApiStatusResponseDto.FAIL.name(),
                        data,
                        message,
                        status.value()
                )
        );
    }

}

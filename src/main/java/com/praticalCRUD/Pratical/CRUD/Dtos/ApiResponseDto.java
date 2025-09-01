package com.praticalCRUD.Pratical.CRUD.Dtos;

public class ApiResponseDto<T> {
    private String status;
    private T response;
    private String message;
    private int statusCode;

    public ApiResponseDto(String status, T response, String message, int statusCode) {
        this.status = status;
        this.response = response;
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}

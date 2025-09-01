package com.praticalCRUD.Pratical.CRUD.Dtos.UserDto.Requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UpdateUserDto {
    @Size(min = 3, max = 20, message = "Username at least 3 and not exceed 20 characters!")
    private String username;

    @Email
    private String email;

    @Size(min = 3, max = 20, message = "Password at least 3 and not exceed 20 characters!")
    private String password;

    @Size(min = 10, max = 10, message = "Phone number at least 10 and not exceed 10 characters!")
    private String phone;

    public UpdateUserDto(String username, String email, String password, String phone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

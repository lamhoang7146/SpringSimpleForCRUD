package com.praticalCRUD.Pratical.CRUD.Controllers;

import com.praticalCRUD.Pratical.CRUD.Dtos.ApiResponseDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.UserDto.Requests.CreateUserDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.UserDto.Requests.UpdateUserDto;
import com.praticalCRUD.Pratical.CRUD.Models.User;
import com.praticalCRUD.Pratical.CRUD.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<User>>> getUsers(
            ) {
        return this.userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<User>> getUser(@PathVariable String id) {
        return this.userService.getUser(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<User>> createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return this.userService.createUser(createUserDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponseDto<User>> updateUser(@PathVariable String id, @Valid @RequestBody UpdateUserDto updateUserDto) {
        return this.userService.updateUser(id, updateUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Object>> deleteUser(@PathVariable String id) {
        return this.userService.deleteUser(id);
    }
}

package com.praticalCRUD.Pratical.CRUD.Services;

import com.praticalCRUD.Pratical.CRUD.Dtos.ApiResponseDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.UserDto.Requests.CreateUserDto;
import com.praticalCRUD.Pratical.CRUD.Dtos.UserDto.Requests.UpdateUserDto;
import com.praticalCRUD.Pratical.CRUD.Models.User;
import com.praticalCRUD.Pratical.CRUD.Repositories.UserRepository;
import com.praticalCRUD.Pratical.CRUD.Ultils.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<ApiResponseDto<List<User>>> getUsers() {
        List<User> usersPage = userRepository.findAll();
        return ResponseHelper.success(usersPage, "Get users successfully", HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseDto<User>> getUser(String id) {
        Optional<User> isUserExists = this.userRepository.findById(id);

        if (isUserExists.isEmpty()) {
            return ResponseHelper.fail(null, "Not found", HttpStatus.BAD_REQUEST);
        }

        User user = isUserExists.get();

        return ResponseHelper.success(user, "Get user by id: ", HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseDto<User>> createUser(CreateUserDto createUserDto) {
        Optional<User> isEmailExist = this.userRepository.findByEmail(createUserDto.getEmail());

        if (isEmailExist.isPresent()) {
            return ResponseHelper.fail(null, "Email already exists!", HttpStatus.BAD_REQUEST);
        }

        Optional<User> isPhoneExist = this.userRepository.findByPhone(createUserDto.getPhone());

        if (isPhoneExist.isPresent()) {
            return ResponseHelper.fail(null, "Phone already exists!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());
        user.setPhone(createUserDto.getPhone());
        return ResponseHelper.success(this.userRepository.save(user), "Created user successfully!", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ApiResponseDto<User>> updateUser(String id, UpdateUserDto updateUserDto) {
        Optional<User> isUserExists = this.userRepository.findById(id);

        if (isUserExists.isEmpty()) {
            return ResponseHelper.fail(null, "Not found", HttpStatus.BAD_REQUEST);
        }

        User user = isUserExists.get();

        if (updateUserDto.getEmail() != null &&
                !updateUserDto.getEmail().equals(user.getEmail()) &&
                userRepository.findByEmail(updateUserDto.getEmail()).isPresent()) {
            return ResponseHelper.fail(null, "Email already exists!", HttpStatus.BAD_REQUEST);
        }

        if (updateUserDto.getPhone() != null &&
                !updateUserDto.getPhone().equals(user.getPhone()) &&
                userRepository.findByPhone(updateUserDto.getPhone()).isPresent()) {
            return ResponseHelper.fail(null, "Phone already exists!", HttpStatus.BAD_REQUEST);
        }

        if (updateUserDto.getUsername() != null) {
            user.setUsername(updateUserDto.getUsername());
        }
        if (updateUserDto.getEmail() != null) {
            user.setEmail(updateUserDto.getEmail());
        }
        if (updateUserDto.getPassword() != null) {
            user.setPassword(updateUserDto.getPassword());
        }
        if (updateUserDto.getPhone() != null) {
            user.setPhone(updateUserDto.getPhone());
        }

        User updatedUser = userRepository.save(user);
        return ResponseHelper.success(updatedUser, "Updated user successfully!", HttpStatus.OK);

    }

    public ResponseEntity<ApiResponseDto<Object>> deleteUser(String id){
        Optional<User> isUserExists = this.userRepository.findById(id);

        if (isUserExists.isEmpty()) {
            return ResponseHelper.fail(null, "Not found", HttpStatus.BAD_REQUEST);
        }
        this.userRepository.delete(isUserExists.get());
        return ResponseHelper.success(null, "Deleted user successfully!", HttpStatus.OK);
    }

}

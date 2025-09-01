package com.praticalCRUD.Pratical.CRUD.Repositories;

import com.praticalCRUD.Pratical.CRUD.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
}

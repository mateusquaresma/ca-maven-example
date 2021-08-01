package com.ca.example.domain.port;

import com.ca.example.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(String id);

    List<User> findAllUsers();

    User create(User userToSave);

    Optional<User> findByEmail(String email);
}

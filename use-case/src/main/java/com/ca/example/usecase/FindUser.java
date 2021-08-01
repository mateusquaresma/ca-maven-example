package com.ca.example.usecase;

import com.ca.example.domain.entity.User;
import com.ca.example.domain.port.UserRepository;

import java.util.List;
import java.util.Optional;

public class FindUser {

    private final UserRepository repository;

    public FindUser(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}

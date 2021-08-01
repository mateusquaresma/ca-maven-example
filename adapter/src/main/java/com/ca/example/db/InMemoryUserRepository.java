package com.ca.example.db;

import com.ca.example.domain.entity.User;
import com.ca.example.domain.port.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> usersByID = new HashMap<>();
    private final Map<String, User> usersByEmail = new HashMap<>();

    @Override
    public Optional<User> findById(String id) {
        User found = usersByID.get(id);
        return Optional.ofNullable(found);
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<>(usersByID.values());
    }

    @Override
    public User create(User userToSave) {
        usersByID.put(userToSave.getId(), userToSave);
        usersByEmail.put(userToSave.getEmail(), userToSave);
        return userToSave;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User found = usersByEmail.get(email);
        return Optional.ofNullable(found);
    }
}

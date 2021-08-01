package com.ca.example.usecase;

import com.ca.example.domain.entity.User;
import com.ca.example.domain.exception.UserAlreadyExistsException;
import com.ca.example.domain.port.IdGenerator;
import com.ca.example.domain.port.PasswordEncoder;
import com.ca.example.domain.port.UserRepository;

import java.util.Optional;

public class CreateUser {

    private final UserRepository repository;
    private final IdGenerator generator;
    private final PasswordEncoder encoder;

    public CreateUser(UserRepository repository, IdGenerator generator, PasswordEncoder encoder) {
        this.repository = repository;
        this.generator = generator;
        this.encoder = encoder;
    }

    public User create(User user) {
        Optional<User> userInDB = repository.findByEmail(user.getEmail());
        if (userInDB.isPresent())
            throw new UserAlreadyExistsException("User " + user.getEmail() + " already exists");

        User userToSave = User.builder()
                .id(generator.generate())
                .email(user.getEmail())
                .password(encoder.encode(user.getPassword()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
        return repository.create(userToSave);
    }
}

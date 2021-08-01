package com.ca.example.config;

import com.ca.example.db.InMemoryUserRepository;
import com.ca.example.domain.port.IdGenerator;
import com.ca.example.domain.port.PasswordEncoder;
import com.ca.example.domain.port.UserRepository;
import com.ca.example.encoder.Sha256PasswordEncoder;
import com.ca.example.generator.UUIDIdGenerator;
import com.ca.example.usecase.CreateUser;
import com.ca.example.usecase.FindUser;

public class ManualConfig {

    private final UserRepository userRepository = new InMemoryUserRepository();
    private final IdGenerator generator = new UUIDIdGenerator();
    private final PasswordEncoder encoder = new Sha256PasswordEncoder();

    public CreateUser createUser() {
        return new CreateUser(userRepository, generator, encoder);
    }

    public FindUser findUser() {
        return new FindUser(userRepository);
    }
}

package com.ca.example.generator;

import com.ca.example.domain.port.IdGenerator;

import java.util.UUID;

public class UUIDIdGenerator implements IdGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}

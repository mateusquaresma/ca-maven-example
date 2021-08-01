package com.ca.example.encoder;

import com.ca.example.domain.port.PasswordEncoder;

public class Sha256PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(String password) {
        return password;
    }
}

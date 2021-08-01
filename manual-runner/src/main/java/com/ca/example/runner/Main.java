package com.ca.example.runner;

import com.ca.example.config.ManualConfig;
import com.ca.example.domain.entity.User;
import com.ca.example.usecase.CreateUser;
import com.ca.example.usecase.FindUser;

public class Main {
    public static void main(String[] args) {
        ManualConfig config = new ManualConfig();
        CreateUser createUser = config.createUser();

        User user = User.builder()
                .id("1")
                .email("mateus@teste.com")
                .firstName("Mateus")
                .lastName("Quaresma")
                .password("123")
                .build();
        User mateus = createUser.create(user);
        System.out.println("First user = " + mateus);

        user = User.builder()
                .id("1")
                .email("quaresma@teste.com")
                .firstName("Lucio")
                .lastName("Quaresma")
                .password("123")
                .build();

        User quaresma = createUser.create(user);
        System.out.println("Second user = " + quaresma);
        FindUser findUser = config.findUser();
        System.out.println("All Users");
        findUser.findAllUsers().forEach(System.out::println);
        System.out.println("User found by ID = " + findUser.findById("1"));
        System.out.println("User found by email = " + findUser.findByEmail("quaresma@teste.com"));
    }
}

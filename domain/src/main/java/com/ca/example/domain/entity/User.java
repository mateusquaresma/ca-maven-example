package com.ca.example.domain.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Builder
@Getter
public class User {
    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

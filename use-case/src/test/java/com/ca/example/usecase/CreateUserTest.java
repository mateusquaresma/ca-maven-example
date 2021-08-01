package com.ca.example.usecase;


import com.ca.example.domain.entity.User;
import com.ca.example.domain.exception.UserAlreadyExistsException;
import com.ca.example.domain.port.IdGenerator;
import com.ca.example.domain.port.PasswordEncoder;
import com.ca.example.domain.port.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserTest {

    @Mock
    private UserRepository repository;
    @Mock
    private IdGenerator generator;
    @Mock
    private PasswordEncoder encoder;

    private CreateUser subject;

    @Before
    public void setup() {
        subject = new CreateUser(repository, generator, encoder);
    }

    @Test
    public void shouldCreateAnUser() {
        User example = User.builder()
                .id("abc")
                .email("fulano@gmail.com")
                .password("123")
                .firstName("Fulano")
                .lastName("De Tal")
                .build();

        when(repository.create(eq(example))).thenReturn(example);

        User createdUser = subject.create(example);
        assertEquals(example, createdUser);
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void mustValidateAnExixtingUser() {
        User example = User.builder()
                .id("abc")
                .email("fulano@gmail.com")
                .password("123")
                .firstName("Fulano")
                .lastName("De Tal")
                .build();

        when(repository.findByEmail(example.getEmail())).thenThrow(UserAlreadyExistsException.class);
        subject.create(example);
    }
}
package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserDetails() {
        // Mocking and Stubbing
        when(userRepository.findUserById("U123")).thenReturn("John Doe");

        String result = userService.getUserDetails("U123");

        assertEquals("Details: John Doe", result);

        // Verifying Interactions
        verify(userRepository, times(1)).findUserById("U123");
    }
}\n
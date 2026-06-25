package com.example;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserDetails(String userId) {
        String user = userRepository.findUserById(userId);
        if (user == null) {
            return "User not found";
        }
        return "Details: " + user;
    }
}\n
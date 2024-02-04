package com.example.Notes.UserService;

public interface UserService {
    User saveUser(User user);
    User getUserByUsername(String username);
}

package com.example.userservice.service;

import com.example.userservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    User updateUser(String id, User user);
    void deleteUser(String id);
    Optional<User> getUserById(String id);
    List<User> getAllUsers();
}
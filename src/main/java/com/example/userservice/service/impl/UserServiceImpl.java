package com.example.userservice.service.impl;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setCreatedAt(Instant.now().toString());
        log.info("Creating user: {}", user);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User user) {
        user.setId(id);
        log.info("Updating user with id {}: {}", id, user);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        log.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(String id) {
        log.info("Fetching user with id: {}", id);
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        Iterable<User> iterable = userRepository.findAll();
        log.info("Fetching all users");
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
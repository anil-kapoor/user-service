package com.example.userservice.controller;

import com.example.userservice.enums.Role;
import com.example.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/token")
    public ResponseEntity<String> generateToken(
            @RequestParam String userId,
            @RequestParam String email,
            @RequestParam List<Role> roles) {
        String token = jwtUtil.generateToken(userId, email, roles);
        return ResponseEntity.ok(token);
    }
}
package com.example.userservice.service;

import com.example.userservice.entity.Showtime;
import java.util.List;
import java.util.Optional;

public interface ShowtimeService {
    Showtime create(Showtime showtime);
    Showtime update(String id, Showtime showtime);
    void delete(String id);
    Optional<Showtime> getById(String id);
    List<Showtime> getAll();
}
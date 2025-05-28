package com.example.userservice.service;

import com.example.userservice.entity.Theatre;
import java.util.List;
import java.util.Optional;

public interface TheatreService {
    Theatre createTheatre(Theatre theatre);
    Theatre updateTheatre(String id, Theatre theatre);
    void deleteTheatre(String id);
    Optional<Theatre> getTheatreById(String id);
    List<Theatre> getAllTheatres();
}
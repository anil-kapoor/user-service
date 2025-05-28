package com.example.userservice.service;

import com.example.userservice.entity.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie create(Movie movie);
    Movie update(String id, Movie movie);
    void delete(String id);
    Optional<Movie> getById(String id);
    List<Movie> getAll();
}
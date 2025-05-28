package com.example.userservice.service.impl;

import com.example.userservice.entity.Movie;
import com.example.userservice.repository.MovieRepository;
import com.example.userservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(String id, Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    @Override
    public void delete(String id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Optional<Movie> getById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> getAll() {
        return (List<Movie>) movieRepository.findAll();
    }
}
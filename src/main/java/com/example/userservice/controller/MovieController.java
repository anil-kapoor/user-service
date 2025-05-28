package com.example.userservice.controller;

import com.example.userservice.entity.Movie;
import com.example.userservice.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PreAuthorize("hasAnyRole('PLATFORM_ADMIN')")
    @PostMapping
    public ResponseEntity<Movie> create(@Valid @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.create(movie));
    }

    @PreAuthorize("hasAnyRole('PLATFORM_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable String id, @Valid @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.update(id, movie));
    }

    @PreAuthorize("hasAnyRole('PLATFORM_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('PLATFORM_ADMIN', 'SUPPORT')")
    @GetMapping("/{id}")
    public ResponseEntity<Movie> get(@PathVariable String id) {
        return movieService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAnyRole('PLATFORM_ADMIN', 'SUPPORT')")
    @GetMapping
    public ResponseEntity<List<Movie>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }
}
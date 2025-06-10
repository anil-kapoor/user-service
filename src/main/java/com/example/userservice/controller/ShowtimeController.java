package com.example.userservice.controller;

import com.example.userservice.entity.Showtime;
import com.example.userservice.service.ShowtimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/v1/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @PreAuthorize("hasAnyRole('THEATRE_ADMIN', 'PLATFORM_ADMIN')")
    @PostMapping
    public ResponseEntity<Showtime> create(@Valid @RequestBody Showtime showtime) {
        return ResponseEntity.ok(showtimeService.create(showtime));
    }

    @PreAuthorize("hasAnyRole('THEATRE_ADMIN', 'PLATFORM_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Showtime> update(@PathVariable String id, @Valid @RequestBody Showtime showtime) {
        return ResponseEntity.ok(showtimeService.update(id, showtime));
    }

    @PreAuthorize("hasRole('PLATFORM_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        showtimeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('THEATRE_ADMIN', 'PLATFORM_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Showtime> get(@PathVariable String id) {
        return showtimeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAnyRole('THEATRE_ADMIN', 'PLATFORM_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Showtime>> getAll() {
        return ResponseEntity.ok(showtimeService.getAll());
    }
}
package com.example.userservice.controller;

import com.example.userservice.entity.Theatre;
import com.example.userservice.service.TheatreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping
    public ResponseEntity<Theatre> create(@Valid @RequestBody Theatre theatre) {
        return ResponseEntity.ok(theatreService.createTheatre(theatre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theatre> update(@PathVariable String id, @Valid @RequestBody Theatre theatre) {
        return ResponseEntity.ok(theatreService.updateTheatre(id, theatre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        theatreService.deleteTheatre(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theatre> get(@PathVariable String id) {
        return theatreService.getTheatreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Theatre>> getAll() {
        return ResponseEntity.ok(theatreService.getAllTheatres());
    }
}
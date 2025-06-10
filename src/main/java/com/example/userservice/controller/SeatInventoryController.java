package com.example.userservice.controller;

import com.example.userservice.entity.SeatInventory;
import com.example.userservice.service.SeatInventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seat-inventory")
public class SeatInventoryController {

    @Autowired
    private SeatInventoryService inventoryService;

    @PreAuthorize("hasAnyRole('THEATRE_ADMIN', 'PLATFORM_ADMIN')")
    @PostMapping
    public ResponseEntity<SeatInventory> create(@Valid @RequestBody SeatInventory inventory) {
        return ResponseEntity.ok(inventoryService.create(inventory));
    }

    @PreAuthorize("hasAnyRole('THEATRE_ADMIN', 'PLATFORM_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<SeatInventory> update(@PathVariable String id, @Valid @RequestBody SeatInventory inventory) {
        return ResponseEntity.ok(inventoryService.update(id, inventory));
    }

    @PreAuthorize("hasRole('PLATFORM_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        inventoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('THEATRE_ADMIN', 'PLATFORM_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<SeatInventory> get(@PathVariable String id) {
        return inventoryService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAnyRole('THEATRE_ADMIN', 'PLATFORM_ADMIN')")
    @GetMapping
    public ResponseEntity<List<SeatInventory>> getAll() {
        return ResponseEntity.ok(inventoryService.getAll());
    }
}
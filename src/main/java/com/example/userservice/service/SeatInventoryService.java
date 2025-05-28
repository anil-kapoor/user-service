package com.example.userservice.service;

import com.example.userservice.entity.SeatInventory;
import java.util.List;
import java.util.Optional;

public interface SeatInventoryService {
    SeatInventory create(SeatInventory inventory);
    SeatInventory update(String id, SeatInventory inventory);
    void delete(String id);
    Optional<SeatInventory> getById(String id);
    List<SeatInventory> getAll();
}
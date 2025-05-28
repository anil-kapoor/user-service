package com.example.userservice.service.impl;

import com.example.userservice.entity.SeatInventory;
import com.example.userservice.repository.SeatInventoryRepository;
import com.example.userservice.service.SeatInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatInventoryServiceImpl implements SeatInventoryService {

    @Autowired
    private SeatInventoryRepository inventoryRepository;

    @Override
    public SeatInventory create(SeatInventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public SeatInventory update(String id, SeatInventory inventory) {
        inventory.setId(id);
        return inventoryRepository.save(inventory);
    }

    @Override
    public void delete(String id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public Optional<SeatInventory> getById(String id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public List<SeatInventory> getAll() {
        return (List<SeatInventory>) inventoryRepository.findAll();
    }
}
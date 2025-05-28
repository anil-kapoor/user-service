package com.example.userservice.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.userservice.entity.SeatInventory;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatInventoryRepository extends CosmosRepository<SeatInventory, String> {
}
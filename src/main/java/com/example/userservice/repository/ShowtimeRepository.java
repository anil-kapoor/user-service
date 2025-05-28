package com.example.userservice.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.userservice.entity.Showtime;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends CosmosRepository<Showtime, String> {
}
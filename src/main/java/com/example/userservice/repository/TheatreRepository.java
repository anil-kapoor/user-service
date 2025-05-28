package com.example.userservice.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.userservice.entity.Theatre;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends CosmosRepository<Theatre, String> {
}
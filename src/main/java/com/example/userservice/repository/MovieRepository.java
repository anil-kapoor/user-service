package com.example.userservice.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.userservice.entity.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CosmosRepository<Movie, String> {
}
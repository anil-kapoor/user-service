package com.example.userservice.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.userservice.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CosmosRepository<User, String> {

}
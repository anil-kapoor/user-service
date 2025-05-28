package com.example.userservice.service.impl;

import com.example.userservice.entity.Showtime;
import com.example.userservice.repository.ShowtimeRepository;
import com.example.userservice.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Override
    public Showtime create(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public Showtime update(String id, Showtime showtime) {
        showtime.setId(id);
        return showtimeRepository.save(showtime);
    }

    @Override
    public void delete(String id) {
        showtimeRepository.deleteById(id);
    }

    @Override
    public Optional<Showtime> getById(String id) {
        return showtimeRepository.findById(id);
    }

    @Override
    public List<Showtime> getAll() {
        return (List<Showtime>) showtimeRepository.findAll();
    }
}
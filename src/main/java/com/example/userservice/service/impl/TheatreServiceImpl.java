package com.example.userservice.service.impl;

import com.example.userservice.entity.Theatre;
import com.example.userservice.repository.TheatreRepository;
import com.example.userservice.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    @Override
    public Theatre updateTheatre(String id, Theatre theatre) {
        theatre.setId(id);
        return theatreRepository.save(theatre);
    }

    @Override
    public void deleteTheatre(String id) {
        theatreRepository.deleteById(id);
    }

    @Override
    public Optional<Theatre> getTheatreById(String id) {
        return theatreRepository.findById(id);
    }

    @Override
    public List<Theatre> getAllTheatres() {
        return (List<Theatre>) theatreRepository.findAll();
    }
}
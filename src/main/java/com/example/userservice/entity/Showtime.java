package com.example.userservice.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Container(containerName = "showtimes")
public class Showtime {

    @Id
    private String id;

    @NotBlank
    private String movieId;

    @NotBlank
    private String theatreId;

    private String screenId;
    private String date;  // yyyy-MM-dd
    private String time;  // HH:mm
    private double price;
    private int totalSeats;
    private int availableSeats;
}
package com.example.userservice.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Container(containerName = "movies")
public class Movie {

    @Id
    private String id;

    @NotBlank
    private String title;

    private String language;

    private List<String> genre;

    private int durationMins;

    private String rating;
}
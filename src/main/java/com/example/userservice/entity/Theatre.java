package com.example.userservice.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Container(containerName = "theatres")
public class Theatre {

    @Id
    private String id;

    @PartitionKey
    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Theatre name is required")
    private String name;

    private String partnerId;

    private List<Screen> screens;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Screen {
        private String screenId;
        private int totalSeats;
        private Layout layout;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Layout {
        private int rows;
        private int cols;
        private List<String> vipRows;
    }
}
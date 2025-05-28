package com.example.userservice.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Container(containerName = "seat_inventory")
public class SeatInventory {

    @Id
    private String id;

    @PartitionKey
    private String showtimeId;

    private Map<String, String> seatStatus; // seatNumber -> status (e.g., A1 -> AVAILABLE, BOOKED)
}
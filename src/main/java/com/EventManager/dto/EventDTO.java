package com.EventManager.dto;

import java.time.LocalDate;

public record EventDTO(
        String name,
        String imageURL,
        LocalDate date,
        String address,
        String description) {
}

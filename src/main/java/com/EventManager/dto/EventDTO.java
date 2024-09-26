package com.EventManager.dto;

import java.time.LocalDate;

public record EventDTO(
        String name,
        LocalDate date,
        String address,
        String description) {
}

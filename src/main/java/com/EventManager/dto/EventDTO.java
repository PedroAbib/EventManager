package com.EventManager.dto;

public record EventDTO(
        String name,
        String imageURL,
        String date,
        String address,
        String description,
        Boolean isCompleted) {
}

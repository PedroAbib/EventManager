package com.EventManager.dto;

public record PersonDTO(
        String fullName,
        String tagName,
        String workField,
        String cpf,
        String email,
        String phoneNumber,
        String address,
        String postalCode) {
}

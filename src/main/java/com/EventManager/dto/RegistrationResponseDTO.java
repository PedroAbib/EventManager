package com.EventManager.dto;

import java.time.LocalDate;

public record RegistrationResponseDTO(
        String registrationId,
        String personId,
        String personFullName,
        String personTagName,
        String personWorkField,
        String personCpf,
        String personEmail,
        String personPhoneNumber,
        String personAddress,
        String personPostalCode,
        LocalDate registrationDate,
        Boolean isPaid) {
}

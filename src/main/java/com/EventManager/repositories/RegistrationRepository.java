package com.EventManager.repositories;

import com.EventManager.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, String> {

    List<Registration> findByEventId(String eventId);
}

package com.EventManager.entities;

import com.EventManager.dto.EventDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
@EqualsAndHashCode(of = "id")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String imageURL;

    private LocalDate date;

    private String address;

    private String description;

    private Boolean isCompleted = false;

    public Event(EventDTO data) {
        this.name = data.name();
        this.imageURL = data.imageURL();
        this.date = data.date();
        this.address = data.address();
        this.description = data.description();
    }
}

package com.EventManager.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    private String date; // talvez utilizar LocalDate??

    private String address;

    private String description;

    @ManyToMany
    private List<Person> participants;

    private Boolean isCompleted = false;

    public Event(EventRecord data) {
        this.name = data.name();
        this.date = data.date();
        this.address = data.address();
        this.description = data.description();
    }
}

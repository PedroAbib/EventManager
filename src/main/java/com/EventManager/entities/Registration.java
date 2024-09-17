package com.EventManager.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "registrations")
@EqualsAndHashCode(of = "id")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn
    private Event event;

    @ManyToOne
    @JoinColumn
    private Person person;
}

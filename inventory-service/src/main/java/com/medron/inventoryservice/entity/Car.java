package com.medron.inventoryservice.entity;

import com.medron.inventoryservice.entity.enums.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    private String plate;
    @Enumerated(EnumType.STRING)
    private State state;
    private int modelYear;



}

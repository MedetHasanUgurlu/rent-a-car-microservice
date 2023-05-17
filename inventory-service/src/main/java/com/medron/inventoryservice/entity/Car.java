package com.medron.inventoryservice.entity;

import com.medron.inventoryservice.entity.enums.State;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
    @Cascade(CascadeType.DELETE)
    @JoinColumn(name = "model_id")
    private Model model;
    private String plate;
    @Enumerated(EnumType.STRING)
    private State state;
    private int modelYear;
    private double dailyPrice;



}

package com.medron.maintenanceservices.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenances")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID carId;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private String complaint;
    private double price;
    private boolean isPaid;
    private boolean isCompleted;
}

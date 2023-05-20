package com.medron.maintenanceservice.business.dto.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceGetAllResponse {
    private UUID id;
    private UUID carId;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private String complaint;
    private double price;
    private boolean isPaid;
    private boolean isCompleted;
}

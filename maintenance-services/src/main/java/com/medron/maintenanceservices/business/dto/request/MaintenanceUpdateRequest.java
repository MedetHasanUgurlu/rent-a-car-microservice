package com.medron.maintenanceservices.business.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceUpdateRequest implements MaintenanceRequest {
    private String complaint;
    private double price;
    private boolean isPaid;
    private boolean isCompleted;
}
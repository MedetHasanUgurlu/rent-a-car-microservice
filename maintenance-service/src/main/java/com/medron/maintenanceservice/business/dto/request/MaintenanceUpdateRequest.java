package com.medron.maintenanceservice.business.dto.request;

import com.medron.maintenanceservice.business.dto.request.abstracts.MaintenanceRequest;
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

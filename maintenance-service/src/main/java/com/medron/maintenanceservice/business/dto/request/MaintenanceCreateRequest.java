package com.medron.maintenanceservice.business.dto.request;


import com.medron.maintenanceservice.business.dto.request.abstracts.MaintenanceRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceCreateRequest implements MaintenanceRequest {
    @NotNull(message = "CarID must be ENTERED.")
    private UUID carId;
    @NotEmpty(message = "complaint must not be Empty.")
    @NotNull(message = "complaint must  not be Null.")
    private String complaint;
    @Min(1)
    private double price;
}

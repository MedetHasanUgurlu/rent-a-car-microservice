package com.medron.maintenanceservice.business.dto.request;

import com.medron.maintenanceservice.business.dto.request.abstracts.MaintenanceRequest;
import com.medron.maintenanceservice.constant.ValidationConstant;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceUpdateRequest implements MaintenanceRequest {
    @NotEmpty(message = ValidationConstant.COMPLAINT_NOT_EMPTY)
    @NotNull(message = ValidationConstant.COMPLAINT_NOT_NULL)
    private String complaint;
    @Min(value = 1,message = ValidationConstant.INVALID_PRICE)
    private double price;
    private boolean isPaid;
    private boolean isCompleted;
}

package com.medron.inventoryservice.business.dto.request.create;

import com.medron.commonpackage.utils.annotation.Plate;
import com.medron.commonpackage.utils.annotation.ValidYear;
import com.medron.inventoryservice.business.dto.abstracts.CarRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarCreateRequest implements CarRequest {
    @NotBlank
    private UUID modelId;
    @Plate
    private String plate;
    @ValidYear
    private int modelYear;
}

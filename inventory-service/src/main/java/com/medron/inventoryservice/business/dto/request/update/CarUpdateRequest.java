package com.medron.inventoryservice.business.dto.request.update;

import com.medron.inventoryservice.business.dto.abstracts.CarRequest;
import com.medron.inventoryservice.entity.enums.State;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarUpdateRequest implements CarRequest {
    private UUID modelId;
    private String plate;
    private State state;
    private int modelYear;
}

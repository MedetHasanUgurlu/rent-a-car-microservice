package com.medron.inventoryservice.business.dto.response.get;

import com.medron.inventoryservice.entity.enums.State;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarGetResponse {
    private UUID id;
    private UUID modelId;
    private String plate;
    private State state;
    private int modelYear;
}

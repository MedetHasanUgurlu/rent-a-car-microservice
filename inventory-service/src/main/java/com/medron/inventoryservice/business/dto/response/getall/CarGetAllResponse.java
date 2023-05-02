package com.medron.inventoryservice.business.dto.response.getall;

import com.medron.inventoryservice.entity.enums.State;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarGetAllResponse {
    private UUID id;
    private UUID modelId;
    private String plate;
    private State state;
    private int modelYear;
}

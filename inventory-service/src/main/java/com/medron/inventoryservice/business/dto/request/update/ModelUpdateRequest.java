package com.medron.inventoryservice.business.dto.request.update;

import com.medron.inventoryservice.business.dto.abstracts.ModelRequest;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelUpdateRequest implements ModelRequest {
    private String name;
    private UUID brandId;
}

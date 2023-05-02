package com.medron.inventoryservice.business.dto.request.create;

import com.medron.inventoryservice.business.dto.abstracts.ModelRequest;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelCreateRequest implements ModelRequest {
    private String name;
    private UUID brandId;
}


package com.medron.inventoryservice.business.dto.response.get;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelGetResponse {
    private UUID id;
    private String name;
    private UUID brandId;
}

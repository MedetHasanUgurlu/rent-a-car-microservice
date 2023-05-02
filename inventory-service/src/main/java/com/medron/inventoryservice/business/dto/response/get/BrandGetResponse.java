package com.medron.inventoryservice.business.dto.response.get;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandGetResponse {
    private UUID id;
    private String name;
}


package com.medron.inventoryservice.business.dto.response.getall;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandGetAllResponse {
    private UUID id;
    private String name;
}


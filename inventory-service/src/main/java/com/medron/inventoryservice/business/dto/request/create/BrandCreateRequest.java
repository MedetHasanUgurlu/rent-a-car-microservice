package com.medron.inventoryservice.business.dto.request.create;


import com.medron.inventoryservice.business.dto.abstracts.BrandRequest;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandCreateRequest implements BrandRequest {
    private String name;
}


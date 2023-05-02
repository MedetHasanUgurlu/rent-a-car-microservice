package com.medron.inventoryservice.business.dto.request.update;

import com.medron.inventoryservice.business.dto.abstracts.BrandRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandUpdateRequest implements BrandRequest {
    private String name;
}

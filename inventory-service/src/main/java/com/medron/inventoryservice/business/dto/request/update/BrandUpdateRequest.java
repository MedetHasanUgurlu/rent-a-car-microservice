package com.medron.inventoryservice.business.dto.request.update;

import com.medron.inventoryservice.business.dto.abstracts.BrandRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandUpdateRequest implements BrandRequest {
    @NotNull
    @NotEmpty
    private String name;
}

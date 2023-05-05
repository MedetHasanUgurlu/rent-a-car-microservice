package com.medron.inventoryservice.business.dto.request.create;


import com.medron.inventoryservice.business.dto.abstracts.BrandRequest;
import com.medron.inventoryservice.constant.ValidationConstant;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandCreateRequest implements BrandRequest {
    @NotEmpty(message = ValidationConstant.Brand.BRAND_NAME_NOT_EMPTY)
    @NotNull(message = ValidationConstant.Brand.BRAND_NAME_NOT_NULL)
    private String name;
}


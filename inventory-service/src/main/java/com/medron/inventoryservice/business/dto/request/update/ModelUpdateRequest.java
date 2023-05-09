package com.medron.inventoryservice.business.dto.request.update;

import com.medron.inventoryservice.business.dto.abstracts.ModelRequest;
import com.medron.inventoryservice.constant.ValidationConstant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelUpdateRequest implements ModelRequest {
    @NotBlank(message = ValidationConstant.Model.MODEL_NAME_NOT_BLANK)
    private String name;
    @NotNull(message = ValidationConstant.Model.BRAND_ID_NOT_NULL)
    private UUID brandId;

}


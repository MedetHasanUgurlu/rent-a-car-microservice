package com.medron.paymentservice.business.dto.request;

import com.medron.commonpackage.utils.annotation.ExpressionYear;
import com.medron.paymentservice.constant.ValidationConstant;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentUpdateRequest implements PaymentRequest{
    @ExpressionYear
    @NotEmpty(message = ValidationConstant.CARD_HOLDER_NAME_MUST_NOT_BE_EMPTY)
    @NotNull(message = ValidationConstant.CARD_HOLDER_NAME_MUST_NOT_BE_NULL)
    private String cardHolder;

    @Min(value = 1,message = ValidationConstant.BALANCE)
    private double balance;
}

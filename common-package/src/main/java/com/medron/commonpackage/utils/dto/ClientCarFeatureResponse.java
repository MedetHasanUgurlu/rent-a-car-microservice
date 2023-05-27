package com.medron.commonpackage.utils.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientCarFeatureResponse {
    private String modelName;
    private String brandName;
    private String plate;
    private int modelYear;
}

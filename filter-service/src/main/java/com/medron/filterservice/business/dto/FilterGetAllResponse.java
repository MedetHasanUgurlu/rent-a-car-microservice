package com.medron.filterservice.business.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterGetAllResponse {
    private String id;
    private UUID carId;
    private UUID modelId;
    private UUID brandId;
    private String modelName;
    private String brandName;
    private String plate;
    private int modelYear;
    private double dailyPrice;
    private String state;
}

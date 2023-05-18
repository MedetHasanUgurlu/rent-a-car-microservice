package com.medron.commonpackage.utils.dto;

import lombok.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private boolean isSuccess;
    private String message;
}
package com.medron.commonpackage.utils.dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseStatus {
    private String state;
    private String message;
}

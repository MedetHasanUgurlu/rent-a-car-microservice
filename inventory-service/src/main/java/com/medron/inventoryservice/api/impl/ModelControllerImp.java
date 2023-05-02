package com.medron.inventoryservice.api.impl;

import com.medron.inventoryservice.api.ModelController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/model")
public class ModelControllerImp implements ModelController {
}

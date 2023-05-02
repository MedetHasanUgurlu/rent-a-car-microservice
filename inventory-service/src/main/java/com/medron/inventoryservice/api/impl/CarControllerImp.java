package com.medron.inventoryservice.api.impl;

import com.medron.inventoryservice.api.CarController;
import com.medron.inventoryservice.constant.PathConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(PathConstant.Brand.BasePath)
public class CarControllerImp implements CarController {
}

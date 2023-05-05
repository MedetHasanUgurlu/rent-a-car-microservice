package com.medron.inventoryservice.config;

import com.medron.commonpackage.utils.mapper.ModelMapperService;
import com.medron.commonpackage.utils.mapper.ModelMapperServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapperService modelMapperService(ModelMapper mapper){
        return new ModelMapperServiceImp(mapper);
    }
}

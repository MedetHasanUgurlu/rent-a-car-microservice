package com.medron.commonpackage.utils.mapper;

import com.medron.commonpackage.utils.annotation.Plate;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelMapperServiceImp implements ModelMapperService{
    private final ModelMapper mapper;

    @Override
    public ModelMapper forResponse() {
        mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        return mapper;
    }

    @Override
    public ModelMapper forRequest() {
        mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        return mapper;
    }
}

package com.medron.filterservice.repository;

import com.medron.filterservice.entity.Filter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FilterRepository extends MongoRepository<Filter,String> {
    void deleteByCarId(UUID carId);
    void deleteAllByBrandId(UUID brandId);
    void deleteAllByModelId(UUID modelId);
    Optional<Filter> findByCarId(UUID carId);
}

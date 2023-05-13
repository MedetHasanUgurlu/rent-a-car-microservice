package com.medron.filterservice.repository;

import com.medron.filterservice.entity.Filter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FilterRepository extends MongoRepository<Filter, UUID> {

}

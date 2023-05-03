package com.medron.inventoryservice.repository;

import com.medron.inventoryservice.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {
    boolean existsById(UUID id);
    boolean existsByNameIgnoreCase(String name);
}

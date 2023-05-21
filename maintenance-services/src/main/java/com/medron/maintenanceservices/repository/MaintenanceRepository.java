package com.medron.maintenanceservices.repository;

import com.medron.maintenanceservices.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, UUID> {
    Maintenance findMaintenanceByCarIdAndIsCompletedFalse(UUID carId);
    boolean existsByCarIdAndIsCompletedIsFalse(UUID carId);

}
package com.medron.inventoryservice.repository;

import com.medron.inventoryservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
    boolean existsByPlateIsIgnoreCase(String plate);
}

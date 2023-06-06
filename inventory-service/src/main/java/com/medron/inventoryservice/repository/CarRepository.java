package com.medron.inventoryservice.repository;


import com.medron.inventoryservice.entity.Car;
import com.medron.inventoryservice.entity.enums.State;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    boolean existsByPlateIsIgnoreCase(String plate);

}

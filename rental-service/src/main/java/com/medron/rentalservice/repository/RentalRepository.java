package com.medron.rentalservice.repository;

import com.medron.rentalservice.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentalRepository extends JpaRepository<Rental,UUID > {
    boolean existsById(UUID id);


}

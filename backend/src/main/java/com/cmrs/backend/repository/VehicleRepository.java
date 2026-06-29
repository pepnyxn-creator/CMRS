package com.cmrs.backend.repository;

import com.cmrs.backend.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByPlateNumberAndProvince(
            String plateNumber,
            String province
    );

    boolean existsByPlateNumberAndProvince(
            String plateNumber,
            String province
    );

}
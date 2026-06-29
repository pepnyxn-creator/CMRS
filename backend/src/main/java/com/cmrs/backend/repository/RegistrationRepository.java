package com.cmrs.backend.repository;

import com.cmrs.backend.entity.Registration;
import com.cmrs.backend.entity.Resident;
import com.cmrs.backend.entity.Vehicle;
import com.cmrs.backend.entity.enums.RegistrationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    boolean existsByVehicleAndStatus(
            Vehicle vehicle,
            RegistrationStatus status
    );

    long countByResidentRoomHistory_ResidentAndStatus(
            Resident resident,
            RegistrationStatus status
    );

    Optional<Registration> findTopByOrderByIdDesc();

    Optional<Registration> findByStickerCode(String stickerCode);

    List<Registration> findByStatus(RegistrationStatus status);

}
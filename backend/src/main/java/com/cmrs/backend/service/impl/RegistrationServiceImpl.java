package com.cmrs.backend.service.impl;

import com.cmrs.backend.dto.request.RegistrationRequest;
import com.cmrs.backend.dto.response.RegistrationResponse;
import com.cmrs.backend.entity.Registration;
import com.cmrs.backend.entity.ResidentRoomHistory;
import com.cmrs.backend.entity.User;
import com.cmrs.backend.entity.Vehicle;
import com.cmrs.backend.entity.enums.RegistrationStatus;
import com.cmrs.backend.exception.BadRequestException;
import com.cmrs.backend.exception.ResourceNotFoundException;
import com.cmrs.backend.mapper.RegistrationMapper;
import com.cmrs.backend.repository.RegistrationRepository;
import com.cmrs.backend.repository.ResidentRoomHistoryRepository;
import com.cmrs.backend.repository.UserRepository;
import com.cmrs.backend.repository.VehicleRepository;
import com.cmrs.backend.service.interfaces.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final ResidentRoomHistoryRepository residentRoomHistoryRepository;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final RegistrationMapper registrationMapper;

    @Override
    public List<RegistrationResponse> findAll() {
        return registrationMapper.toResponse(registrationRepository.findAll());
    }

    @Override
    public RegistrationResponse findById(Long id) {

        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Registration not found"));

        return registrationMapper.toResponse(registration);
    }

    private String generateStickerCode() {

        Optional<Registration> latest =
                registrationRepository.findTopByOrderByIdDesc();

        if (latest.isEmpty()) {
            return "SSC000001";
        }

        String lastCode = latest.get().getStickerCode();

        int number = Integer.parseInt(lastCode.substring(3));

        return String.format("SSC%06d", number + 1);
    }

    @Override
    public RegistrationResponse save(RegistrationRequest request) {

        ResidentRoomHistory history =
                residentRoomHistoryRepository.findById(
                        request.getResidentRoomHistoryId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Resident history not found"));

        Vehicle vehicle =
                vehicleRepository.findById(request.getVehicleId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Vehicle not found"));

        User createdBy =
                userRepository.findById(request.getCreatedBy())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User not found"));

        if (registrationRepository.existsByVehicleAndStatus(
                vehicle,
                RegistrationStatus.ACTIVE)) {

            throw new BadRequestException(
                    "Vehicle is already registered.");
        }

        long total =
                registrationRepository
                        .countByResidentRoomHistory_ResidentAndStatus(
                                history.getResident(),
                                RegistrationStatus.ACTIVE);

        if (total >= 3) {

            throw new BadRequestException(
                    "Resident cannot register more than 3 motorcycles.");
        }

        Registration registration = Registration.builder()
                .residentRoomHistory(history)
                .vehicle(vehicle)
                .createdBy(createdBy)
                .stickerCode(generateStickerCode())
                .status(RegistrationStatus.ACTIVE)
                .registerDate(request.getRegisterDate())
                .unregisterDate(request.getUnregisterDate())
                .printedCount(0)
                .remark(request.getRemark())
                .build();

        registration = registrationRepository.save(registration);

        return registrationMapper.toResponse(registration);
    }

    @Override
    public RegistrationResponse update(Long id, RegistrationRequest request) {

        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Registration not found"));

        ResidentRoomHistory history =
                residentRoomHistoryRepository.findById(
                        request.getResidentRoomHistoryId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Resident history not found"));

        Vehicle vehicle =
                vehicleRepository.findById(request.getVehicleId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Vehicle not found"));

        User createdBy =
                userRepository.findById(request.getCreatedBy())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User not found"));

        registration.setResidentRoomHistory(history);
        registration.setVehicle(vehicle);
        registration.setCreatedBy(createdBy);
        registration.setRegisterDate(request.getRegisterDate());
        registration.setUnregisterDate(request.getUnregisterDate());
        registration.setRemark(request.getRemark());

        registration = registrationRepository.save(registration);

        return registrationMapper.toResponse(registration);
    }

    @Override
    public void cancel(Long id) {

        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Registration not found"));

        registration.setStatus(RegistrationStatus.CANCELLED);
        registration.setUnregisterDate(java.time.LocalDate.now());

        registrationRepository.save(registration);
    }

} 
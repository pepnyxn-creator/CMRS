package com.cmrs.backend.mapper;

import com.cmrs.backend.dto.response.RegistrationResponse;
import com.cmrs.backend.entity.Registration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistrationMapper {

    public RegistrationResponse toResponse(Registration registration) {

        return RegistrationResponse.builder()
                .id(registration.getId())
                .stickerCode(registration.getStickerCode())
                .status(registration.getStatus())

                .residentName(
                        registration.getResidentRoomHistory()
                                .getResident()
                                .getFullName())

                .roomNumber(
                        registration.getResidentRoomHistory()
                                .getRoom()
                                .getRoomNumber())

                .plateNumber(
                        registration.getVehicle()
                                .getPlateNumber())

                .province(
                        registration.getVehicle()
                                .getProvince())

                .registerDate(registration.getRegisterDate())
                .unregisterDate(registration.getUnregisterDate())
                .printedCount(registration.getPrintedCount())
                .lastPrintedAt(registration.getLastPrintedAt())
                .remark(registration.getRemark())

                .createdBy(
                        registration.getCreatedBy()
                                .getFullName())

                .build();
    }

    public List<RegistrationResponse> toResponse(List<Registration> registrations) {

        return registrations.stream()
                .map(this::toResponse)
                .toList();
    }

}
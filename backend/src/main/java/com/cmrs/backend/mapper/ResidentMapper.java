package com.cmrs.backend.mapper;

import com.cmrs.backend.dto.request.ResidentRequest;
import com.cmrs.backend.dto.response.ResidentResponse;
import com.cmrs.backend.entity.Resident;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResidentMapper {

    public Resident toEntity(ResidentRequest request) {

        return Resident.builder()
                .fullName(request.getFullName())
                .phone(request.getPhone())
                .residentType(request.getResidentType())
                .isActive(request.getIsActive())
                .build();
    }

    public ResidentResponse toResponse(Resident resident) {

        return ResidentResponse.builder()
                .id(resident.getId())
                .fullName(resident.getFullName())
                .phone(resident.getPhone())
                .residentType(resident.getResidentType())
                .isActive(resident.getIsActive())
                .build();
    }

    public List<ResidentResponse> toResponse(List<Resident> residents) {

        return residents.stream()
                .map(this::toResponse)
                .toList();
    }
}
package com.cmrs.backend.service.impl;

import com.cmrs.backend.dto.request.ResidentRequest;
import com.cmrs.backend.dto.response.ResidentResponse;
import com.cmrs.backend.entity.Resident;
import com.cmrs.backend.exception.ResourceNotFoundException;
import com.cmrs.backend.mapper.ResidentMapper;
import com.cmrs.backend.repository.ResidentRepository;
import com.cmrs.backend.service.interfaces.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;
    private final ResidentMapper residentMapper;

    @Override
    public List<ResidentResponse> findAll() {
        return residentMapper.toResponse(residentRepository.findAll());
    }

    @Override
    public ResidentResponse findById(Long id) {

        Resident resident = residentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resident not found"));

        return residentMapper.toResponse(resident);
    }

    @Override
    public ResidentResponse save(ResidentRequest request) {

        Resident resident = residentMapper.toEntity(request);

        resident = residentRepository.save(resident);

        return residentMapper.toResponse(resident);
    }

    @Override
    public ResidentResponse update(Long id, ResidentRequest request) {

        Resident resident = residentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resident not found"));

        resident.setFullName(request.getFullName());
        resident.setPhone(request.getPhone());
        resident.setResidentType(request.getResidentType());
        resident.setIsActive(request.getIsActive());

        resident = residentRepository.save(resident);

        return residentMapper.toResponse(resident);
    }

    @Override
    public void deleteById(Long id) {

        if (!residentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resident not found");
        }

        residentRepository.deleteById(id);
    }
}
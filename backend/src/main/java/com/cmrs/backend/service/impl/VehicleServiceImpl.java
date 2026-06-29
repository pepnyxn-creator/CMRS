package com.cmrs.backend.service.impl;

import com.cmrs.backend.dto.request.VehicleRequest;
import com.cmrs.backend.dto.response.VehicleResponse;
import com.cmrs.backend.entity.Vehicle;
import com.cmrs.backend.exception.BadRequestException;
import com.cmrs.backend.exception.ResourceNotFoundException;
import com.cmrs.backend.mapper.VehicleMapper;
import com.cmrs.backend.repository.VehicleRepository;
import com.cmrs.backend.service.interfaces.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Override
    public List<VehicleResponse> findAll() {
        return vehicleMapper.toResponse(vehicleRepository.findAll());
    }

    @Override
    public VehicleResponse findById(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        return vehicleMapper.toResponse(vehicle);
    }

    @Override
    public VehicleResponse save(VehicleRequest request) {

        if (vehicleRepository.existsByPlateNumberAndProvince(
                request.getPlateNumber(),
                request.getProvince())) {

            throw new BadRequestException("Vehicle already exists");
        }

        Vehicle vehicle = vehicleMapper.toEntity(request);

        vehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.toResponse(vehicle);
    }

    @Override
    public VehicleResponse update(Long id, VehicleRequest request) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        vehicle.setPlateNumber(request.getPlateNumber());
        vehicle.setProvince(request.getProvince());
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setColor(request.getColor());
        vehicle.setVehicleImage(request.getVehicleImage());
        vehicle.setPlateImage(request.getPlateImage());
        vehicle.setIsActive(request.getIsActive());

        vehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.toResponse(vehicle);
    }

    @Override
    public void deleteById(Long id) {

        if (!vehicleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehicle not found");
        }

        vehicleRepository.deleteById(id);
    }
}
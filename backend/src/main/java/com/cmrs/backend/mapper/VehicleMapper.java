package com.cmrs.backend.mapper;

import com.cmrs.backend.dto.request.VehicleRequest;
import com.cmrs.backend.dto.response.VehicleResponse;
import com.cmrs.backend.entity.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleMapper {

    public Vehicle toEntity(VehicleRequest request) {

        return Vehicle.builder()
                .plateNumber(request.getPlateNumber())
                .province(request.getProvince())
                .brand(request.getBrand())
                .model(request.getModel())
                .color(request.getColor())
                .vehicleImage(request.getVehicleImage())
                .plateImage(request.getPlateImage())
                .isActive(request.getIsActive())
                .build();
    }

    public VehicleResponse toResponse(Vehicle vehicle) {

        return VehicleResponse.builder()
                .id(vehicle.getId())
                .plateNumber(vehicle.getPlateNumber())
                .province(vehicle.getProvince())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .color(vehicle.getColor())
                .vehicleImage(vehicle.getVehicleImage())
                .plateImage(vehicle.getPlateImage())
                .isActive(vehicle.getIsActive())
                .build();
    }

    public List<VehicleResponse> toResponse(List<Vehicle> vehicles) {

        return vehicles.stream()
                .map(this::toResponse)
                .toList();
    }
}
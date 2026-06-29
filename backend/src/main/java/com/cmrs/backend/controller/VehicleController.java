package com.cmrs.backend.controller;

import com.cmrs.backend.dto.request.VehicleRequest;
import com.cmrs.backend.dto.response.ApiResponse;
import com.cmrs.backend.dto.response.VehicleResponse;
import com.cmrs.backend.service.interfaces.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<VehicleResponse>>> getAllVehicles() {

        return ResponseEntity.ok(
                ApiResponse.<List<VehicleResponse>>builder()
                        .success(true)
                        .message("Vehicles retrieved successfully")
                        .data(vehicleService.findAll())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VehicleResponse>> getVehicleById(@PathVariable Long id) {

        return ResponseEntity.ok(
                ApiResponse.<VehicleResponse>builder()
                        .success(true)
                        .message("Vehicle retrieved successfully")
                        .data(vehicleService.findById(id))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VehicleResponse>> createVehicle(
            @Valid @RequestBody VehicleRequest request) {

        return ResponseEntity.ok(
                ApiResponse.<VehicleResponse>builder()
                        .success(true)
                        .message("Vehicle created successfully")
                        .data(vehicleService.save(request))
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<VehicleResponse>> updateVehicle(
            @PathVariable Long id,
            @Valid @RequestBody VehicleRequest request) {

        return ResponseEntity.ok(
                ApiResponse.<VehicleResponse>builder()
                        .success(true)
                        .message("Vehicle updated successfully")
                        .data(vehicleService.update(id, request))
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteVehicle(@PathVariable Long id) {

        vehicleService.deleteById(id);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Vehicle deleted successfully")
                        .data(null)
                        .build()
        );
    }
}
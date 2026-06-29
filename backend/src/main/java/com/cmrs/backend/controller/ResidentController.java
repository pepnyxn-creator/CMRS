package com.cmrs.backend.controller;

import com.cmrs.backend.dto.request.ResidentRequest;
import com.cmrs.backend.dto.response.ApiResponse;
import com.cmrs.backend.dto.response.ResidentResponse;
import com.cmrs.backend.service.interfaces.ResidentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residents")
@RequiredArgsConstructor
public class ResidentController {

    private final ResidentService residentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ResidentResponse>>> getAllResidents() {

        return ResponseEntity.ok(
                ApiResponse.<List<ResidentResponse>>builder()
                        .success(true)
                        .message("Residents retrieved successfully")
                        .data(residentService.findAll())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ResidentResponse>> getResidentById(@PathVariable Long id) {

        return ResponseEntity.ok(
                ApiResponse.<ResidentResponse>builder()
                        .success(true)
                        .message("Resident retrieved successfully")
                        .data(residentService.findById(id))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ResidentResponse>> createResident(
            @Valid @RequestBody ResidentRequest request) {

        return ResponseEntity.ok(
                ApiResponse.<ResidentResponse>builder()
                        .success(true)
                        .message("Resident created successfully")
                        .data(residentService.save(request))
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ResidentResponse>> updateResident(
            @PathVariable Long id,
            @Valid @RequestBody ResidentRequest request) {

        return ResponseEntity.ok(
                ApiResponse.<ResidentResponse>builder()
                        .success(true)
                        .message("Resident updated successfully")
                        .data(residentService.update(id, request))
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteResident(@PathVariable Long id) {

        residentService.deleteById(id);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Resident deleted successfully")
                        .data(null)
                        .build()
        );
    }
}
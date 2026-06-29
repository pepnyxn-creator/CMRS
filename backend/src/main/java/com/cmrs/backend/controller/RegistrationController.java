package com.cmrs.backend.controller;

import com.cmrs.backend.dto.request.RegistrationRequest;
import com.cmrs.backend.dto.response.ApiResponse;
import com.cmrs.backend.dto.response.RegistrationResponse;
import com.cmrs.backend.service.interfaces.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<RegistrationResponse>>> getAll() {

        return ResponseEntity.ok(
                ApiResponse.<List<RegistrationResponse>>builder()
                        .success(true)
                        .message("Registrations retrieved successfully")
                        .data(registrationService.findAll())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RegistrationResponse>> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ApiResponse.<RegistrationResponse>builder()
                        .success(true)
                        .message("Registration retrieved successfully")
                        .data(registrationService.findById(id))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RegistrationResponse>> create(
            @Valid @RequestBody RegistrationRequest request) {

        return ResponseEntity.ok(
                ApiResponse.<RegistrationResponse>builder()
                        .success(true)
                        .message("Registration created successfully")
                        .data(registrationService.save(request))
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RegistrationResponse>> update(
            @PathVariable Long id,
            @Valid @RequestBody RegistrationRequest request) {

        return ResponseEntity.ok(
                ApiResponse.<RegistrationResponse>builder()
                        .success(true)
                        .message("Registration updated successfully")
                        .data(registrationService.update(id, request))
                        .build()
        );
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<ApiResponse<Object>> cancel(
            @PathVariable Long id) {

        registrationService.cancel(id);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Registration cancelled successfully")
                        .data(null)
                        .build()
        );
    }
}
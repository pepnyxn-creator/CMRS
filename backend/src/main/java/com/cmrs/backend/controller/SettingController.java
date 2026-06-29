package com.cmrs.backend.controller;

import com.cmrs.backend.dto.request.SettingRequest;
import com.cmrs.backend.dto.response.ApiResponse;
import com.cmrs.backend.dto.response.SettingResponse;
import com.cmrs.backend.service.interfaces.SettingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settings")
@RequiredArgsConstructor
public class SettingController {

    private final SettingService settingService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SettingResponse>>> getAll() {

        return ResponseEntity.ok(
                ApiResponse.<List<SettingResponse>>builder()
                        .success(true)
                        .message("Settings retrieved successfully")
                        .data(settingService.findAll())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SettingResponse>> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ApiResponse.<SettingResponse>builder()
                        .success(true)
                        .message("Setting retrieved successfully")
                        .data(settingService.findById(id))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SettingResponse>> create(
            @Valid @RequestBody SettingRequest request) {

        return ResponseEntity.ok(
                ApiResponse.<SettingResponse>builder()
                        .success(true)
                        .message("Setting created successfully")
                        .data(settingService.save(request))
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SettingResponse>> update(
            @PathVariable Long id,
            @Valid @RequestBody SettingRequest request) {

        return ResponseEntity.ok(
                ApiResponse.<SettingResponse>builder()
                        .success(true)
                        .message("Setting updated successfully")
                        .data(settingService.update(id, request))
                        .build()
        );
    }
}
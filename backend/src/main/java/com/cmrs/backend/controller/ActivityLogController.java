package com.cmrs.backend.controller;

import com.cmrs.backend.dto.request.ActivityLogRequest;
import com.cmrs.backend.dto.response.ActivityLogResponse;
import com.cmrs.backend.dto.response.ApiResponse;
import com.cmrs.backend.service.interfaces.ActivityLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
@RequiredArgsConstructor
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ActivityLogResponse>>> getAll() {

        return ResponseEntity.ok(
                ApiResponse.<List<ActivityLogResponse>>builder()
                        .success(true)
                        .message("Activity logs retrieved successfully")
                        .data(activityLogService.findAll())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ActivityLogResponse>> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ApiResponse.<ActivityLogResponse>builder()
                        .success(true)
                        .message("Activity log retrieved successfully")
                        .data(activityLogService.findById(id))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ActivityLogResponse>> create(
            @Valid @RequestBody ActivityLogRequest request) {

        return ResponseEntity.ok(
                ApiResponse.<ActivityLogResponse>builder()
                        .success(true)
                        .message("Activity log created successfully")
                        .data(activityLogService.save(request))
                        .build()
        );
    }
}
package com.cmrs.backend.controller;

import com.cmrs.backend.dto.request.ResidentRoomHistoryRequest;
import com.cmrs.backend.dto.response.ApiResponse;
import com.cmrs.backend.dto.response.ResidentRoomHistoryResponse;
import com.cmrs.backend.service.interfaces.ResidentRoomHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resident-room-history")
@RequiredArgsConstructor
public class ResidentRoomHistoryController {

    private final ResidentRoomHistoryService historyService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ResidentRoomHistoryResponse>>> getAllHistory() {

        return ResponseEntity.ok(
                ApiResponse.<List<ResidentRoomHistoryResponse>>builder()
                        .success(true)
                        .message("Resident room history retrieved successfully")
                        .data(historyService.findAll())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ResidentRoomHistoryResponse>> getHistoryById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ApiResponse.<ResidentRoomHistoryResponse>builder()
                        .success(true)
                        .message("Resident room history retrieved successfully")
                        .data(historyService.findById(id))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ResidentRoomHistoryResponse>> createHistory(
            @Valid @RequestBody ResidentRoomHistoryRequest request) {

        return ResponseEntity.ok(
                ApiResponse.<ResidentRoomHistoryResponse>builder()
                        .success(true)
                        .message("Resident room history created successfully")
                        .data(historyService.save(request))
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ResidentRoomHistoryResponse>> updateHistory(
            @PathVariable Long id,
            @Valid @RequestBody ResidentRoomHistoryRequest request) {

        return ResponseEntity.ok(
                ApiResponse.<ResidentRoomHistoryResponse>builder()
                        .success(true)
                        .message("Resident room history updated successfully")
                        .data(historyService.update(id, request))
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteHistory(
            @PathVariable Long id) {

        historyService.deleteById(id);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Resident room history deleted successfully")
                        .data(null)
                        .build()
        );
    }

}
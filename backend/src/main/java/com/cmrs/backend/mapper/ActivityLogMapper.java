package com.cmrs.backend.mapper;

import com.cmrs.backend.dto.response.ActivityLogResponse;
import com.cmrs.backend.entity.ActivityLog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityLogMapper {

    public ActivityLogResponse toResponse(ActivityLog log) {

        return ActivityLogResponse.builder()
                .id(log.getId())
                .username(log.getUser().getUsername())
                .fullName(log.getUser().getFullName())
                .action(log.getAction())
                .description(log.getDescription())
                .createdAt(log.getCreatedAt())
                .build();
    }

    public List<ActivityLogResponse> toResponse(List<ActivityLog> logs) {

        return logs.stream()
                .map(this::toResponse)
                .toList();
    }

}
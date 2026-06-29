package com.cmrs.backend.service.impl;

import com.cmrs.backend.dto.request.ActivityLogRequest;
import com.cmrs.backend.dto.response.ActivityLogResponse;
import com.cmrs.backend.entity.ActivityLog;
import com.cmrs.backend.entity.User;
import com.cmrs.backend.exception.ResourceNotFoundException;
import com.cmrs.backend.mapper.ActivityLogMapper;
import com.cmrs.backend.repository.ActivityLogRepository;
import com.cmrs.backend.repository.UserRepository;
import com.cmrs.backend.service.interfaces.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;
    private final UserRepository userRepository;
    private final ActivityLogMapper activityLogMapper;

    @Override
    public List<ActivityLogResponse> findAll() {

        return activityLogMapper.toResponse(activityLogRepository.findAll());
    }

    @Override
    public ActivityLogResponse findById(Long id) {

        ActivityLog log = activityLogRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Activity log not found"));

        return activityLogMapper.toResponse(log);
    }

    @Override
    public ActivityLogResponse save(ActivityLogRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        ActivityLog log = ActivityLog.builder()
                .user(user)
                .action(request.getAction())
                .description(request.getDescription())
                .build();

        log = activityLogRepository.save(log);

        return activityLogMapper.toResponse(log);
    }
}
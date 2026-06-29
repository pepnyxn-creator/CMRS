package com.cmrs.backend.service.interfaces;

import com.cmrs.backend.dto.request.ActivityLogRequest;
import com.cmrs.backend.dto.response.ActivityLogResponse;

import java.util.List;

public interface ActivityLogService {

    List<ActivityLogResponse> findAll();

    ActivityLogResponse findById(Long id);

    ActivityLogResponse save(ActivityLogRequest request);

}
package com.cmrs.backend.service.interfaces;

import com.cmrs.backend.dto.request.SettingRequest;
import com.cmrs.backend.dto.response.SettingResponse;

import java.util.List;

public interface SettingService {

    List<SettingResponse> findAll();

    SettingResponse findById(Long id);

    SettingResponse save(SettingRequest request);

    SettingResponse update(Long id, SettingRequest request);

}
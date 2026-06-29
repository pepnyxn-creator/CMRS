package com.cmrs.backend.service.impl;

import com.cmrs.backend.dto.request.SettingRequest;
import com.cmrs.backend.dto.response.SettingResponse;
import com.cmrs.backend.entity.Setting;
import com.cmrs.backend.exception.ResourceNotFoundException;
import com.cmrs.backend.mapper.SettingMapper;
import com.cmrs.backend.repository.SettingRepository;
import com.cmrs.backend.service.interfaces.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {

    private final SettingRepository settingRepository;
    private final SettingMapper settingMapper;

    @Override
    public List<SettingResponse> findAll() {
        return settingMapper.toResponse(settingRepository.findAll());
    }

    @Override
    public SettingResponse findById(Long id) {

        Setting setting = settingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Setting not found"));

        return settingMapper.toResponse(setting);
    }

    @Override
    public SettingResponse save(SettingRequest request) {

        Setting setting = settingMapper.toEntity(request);

        setting = settingRepository.save(setting);

        return settingMapper.toResponse(setting);
    }

    @Override
    public SettingResponse update(Long id, SettingRequest request) {

        Setting setting = settingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Setting not found"));

        setting.setCondoName(request.getCondoName());
        setting.setLogo(request.getLogo());
        setting.setStickerPrefix(request.getStickerPrefix());
        setting.setNextStickerNumber(request.getNextStickerNumber());

        setting = settingRepository.save(setting);

        return settingMapper.toResponse(setting);
    }
}
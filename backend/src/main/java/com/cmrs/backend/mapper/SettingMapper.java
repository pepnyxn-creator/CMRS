package com.cmrs.backend.mapper;

import com.cmrs.backend.dto.request.SettingRequest;
import com.cmrs.backend.dto.response.SettingResponse;
import com.cmrs.backend.entity.Setting;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettingMapper {

    public Setting toEntity(SettingRequest request) {

        return Setting.builder()
                .condoName(request.getCondoName())
                .logo(request.getLogo())
                .stickerPrefix(request.getStickerPrefix())
                .nextStickerNumber(request.getNextStickerNumber())
                .build();
    }

    public SettingResponse toResponse(Setting setting) {

        return SettingResponse.builder()
                .id(setting.getId())
                .condoName(setting.getCondoName())
                .logo(setting.getLogo())
                .stickerPrefix(setting.getStickerPrefix())
                .nextStickerNumber(setting.getNextStickerNumber())
                .build();
    }

    public List<SettingResponse> toResponse(List<Setting> settings) {

        return settings.stream()
                .map(this::toResponse)
                .toList();
    }
}
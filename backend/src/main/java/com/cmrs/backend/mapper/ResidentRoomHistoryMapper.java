package com.cmrs.backend.mapper;

import com.cmrs.backend.dto.response.ResidentRoomHistoryResponse;
import com.cmrs.backend.entity.ResidentRoomHistory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResidentRoomHistoryMapper {

    public ResidentRoomHistoryResponse toResponse(ResidentRoomHistory history) {

        return ResidentRoomHistoryResponse.builder()
                .id(history.getId())
                .residentId(history.getResident().getId())
                .residentName(history.getResident().getFullName())
                .roomId(history.getRoom().getId())
                .roomNumber(history.getRoom().getRoomNumber())
                .moveInDate(history.getMoveInDate())
                .moveOutDate(history.getMoveOutDate())
                .build();
    }

    public List<ResidentRoomHistoryResponse> toResponse(List<ResidentRoomHistory> histories) {

        return histories.stream()
                .map(this::toResponse)
                .toList();
    }

}
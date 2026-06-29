package com.cmrs.backend.mapper;

import com.cmrs.backend.dto.request.RoomRequest;
import com.cmrs.backend.dto.response.RoomResponse;
import com.cmrs.backend.entity.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomMapper {

    public Room toEntity(RoomRequest request) {

        return Room.builder()
                .roomNumber(request.getRoomNumber())
                .isActive(request.getIsActive())
                .build();
    }

    public RoomResponse toResponse(Room room) {

        return RoomResponse.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .isActive(room.getIsActive())
                .build();
    }

    public List<RoomResponse> toResponse(List<Room> rooms) {

        return rooms.stream()
                .map(this::toResponse)
                .toList();
    }

}
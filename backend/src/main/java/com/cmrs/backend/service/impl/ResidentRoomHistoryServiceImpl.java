package com.cmrs.backend.service.impl;

import com.cmrs.backend.dto.request.ResidentRoomHistoryRequest;
import com.cmrs.backend.dto.response.ResidentRoomHistoryResponse;
import com.cmrs.backend.entity.Resident;
import com.cmrs.backend.entity.ResidentRoomHistory;
import com.cmrs.backend.entity.Room;
import com.cmrs.backend.exception.ResourceNotFoundException;
import com.cmrs.backend.mapper.ResidentRoomHistoryMapper;
import com.cmrs.backend.repository.ResidentRepository;
import com.cmrs.backend.repository.ResidentRoomHistoryRepository;
import com.cmrs.backend.repository.RoomRepository;
import com.cmrs.backend.service.interfaces.ResidentRoomHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidentRoomHistoryServiceImpl implements ResidentRoomHistoryService {

    private final ResidentRoomHistoryRepository historyRepository;
    private final ResidentRepository residentRepository;
    private final RoomRepository roomRepository;
    private final ResidentRoomHistoryMapper historyMapper;

    @Override
    public List<ResidentRoomHistoryResponse> findAll() {
        return historyMapper.toResponse(historyRepository.findAll());
    }

    @Override
    public ResidentRoomHistoryResponse findById(Long id) {

        ResidentRoomHistory history = historyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("History not found"));

        return historyMapper.toResponse(history);
    }

    @Override
    public ResidentRoomHistoryResponse save(ResidentRoomHistoryRequest request) {

        Resident resident = residentRepository.findById(request.getResidentId())
                .orElseThrow(() -> new ResourceNotFoundException("Resident not found"));

        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));

        ResidentRoomHistory history = ResidentRoomHistory.builder()
                .resident(resident)
                .room(room)
                .moveInDate(request.getMoveInDate())
                .moveOutDate(request.getMoveOutDate())
                .build();

        history = historyRepository.save(history);

        return historyMapper.toResponse(history);
    }

    @Override
    public ResidentRoomHistoryResponse update(Long id, ResidentRoomHistoryRequest request) {

        ResidentRoomHistory history = historyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("History not found"));

        Resident resident = residentRepository.findById(request.getResidentId())
                .orElseThrow(() -> new ResourceNotFoundException("Resident not found"));

        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));

        history.setResident(resident);
        history.setRoom(room);
        history.setMoveInDate(request.getMoveInDate());
        history.setMoveOutDate(request.getMoveOutDate());

        history = historyRepository.save(history);

        return historyMapper.toResponse(history);
    }

    @Override
    public void deleteById(Long id) {

        if (!historyRepository.existsById(id)) {
            throw new ResourceNotFoundException("History not found");
        }

        historyRepository.deleteById(id);
    }
}
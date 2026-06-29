package com.cmrs.backend.service.interfaces;

import com.cmrs.backend.dto.request.ResidentRoomHistoryRequest;
import com.cmrs.backend.dto.response.ResidentRoomHistoryResponse;

import java.util.List;

public interface ResidentRoomHistoryService {

    List<ResidentRoomHistoryResponse> findAll();

    ResidentRoomHistoryResponse findById(Long id);

    ResidentRoomHistoryResponse save(ResidentRoomHistoryRequest request);

    ResidentRoomHistoryResponse update(Long id, ResidentRoomHistoryRequest request);

    void deleteById(Long id);

}
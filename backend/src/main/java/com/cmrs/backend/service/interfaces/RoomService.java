package com.cmrs.backend.service.interfaces;

import com.cmrs.backend.dto.request.RoomRequest;
import com.cmrs.backend.dto.response.RoomResponse;

import java.util.List;

public interface RoomService {

    List<RoomResponse> findAll();

    RoomResponse findById(Long id);

    RoomResponse save(RoomRequest request);

    RoomResponse update(Long id, RoomRequest request);

    void deleteById(Long id);

}
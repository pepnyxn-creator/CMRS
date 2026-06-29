package com.cmrs.backend.service.interfaces;

import com.cmrs.backend.dto.request.VehicleRequest;
import com.cmrs.backend.dto.response.VehicleResponse;

import java.util.List;

public interface VehicleService {

    List<VehicleResponse> findAll();

    VehicleResponse findById(Long id);

    VehicleResponse save(VehicleRequest request);

    VehicleResponse update(Long id, VehicleRequest request);

    void deleteById(Long id);

}
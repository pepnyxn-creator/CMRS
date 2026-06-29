package com.cmrs.backend.service.interfaces;

import com.cmrs.backend.dto.request.ResidentRequest;
import com.cmrs.backend.dto.response.ResidentResponse;

import java.util.List;

public interface ResidentService {

    List<ResidentResponse> findAll();

    ResidentResponse findById(Long id);

    ResidentResponse save(ResidentRequest request);

    ResidentResponse update(Long id, ResidentRequest request);

    void deleteById(Long id);

}
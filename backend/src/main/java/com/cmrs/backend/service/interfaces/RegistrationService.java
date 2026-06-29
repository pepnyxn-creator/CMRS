package com.cmrs.backend.service.interfaces;

import com.cmrs.backend.dto.request.RegistrationRequest;
import com.cmrs.backend.dto.response.RegistrationResponse;

import java.util.List;

public interface RegistrationService {

    List<RegistrationResponse> findAll();

    RegistrationResponse findById(Long id);

    RegistrationResponse save(RegistrationRequest request);

    RegistrationResponse update(Long id, RegistrationRequest request);

    void cancel(Long id);

}
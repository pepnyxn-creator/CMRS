package com.cmrs.backend.service.interfaces;

import com.cmrs.backend.dto.request.UserRequest;
import com.cmrs.backend.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> findAll();

    UserResponse findById(Long id);

    UserResponse save(UserRequest request);

    UserResponse update(Long id, UserRequest request);

    void deleteById(Long id);

}
package com.cmrs.backend.mapper;

import com.cmrs.backend.dto.request.UserRequest;
import com.cmrs.backend.dto.response.UserResponse;
import com.cmrs.backend.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequest request);

    UserResponse toResponse(User user);

    List<UserResponse> toResponse(List<User> users);

}
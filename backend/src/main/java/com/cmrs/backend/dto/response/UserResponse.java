package com.cmrs.backend.dto.response;

import com.cmrs.backend.entity.enums.UserRole;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;

    private String username;

    private String fullName;

    private UserRole role;

    private Boolean isActive;

}
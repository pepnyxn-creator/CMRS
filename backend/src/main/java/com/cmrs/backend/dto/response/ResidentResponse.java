package com.cmrs.backend.dto.response;

import com.cmrs.backend.entity.enums.ResidentType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentResponse {

    private Long id;

    private String fullName;

    private String phone;

    private ResidentType residentType;

    private Boolean isActive;

}
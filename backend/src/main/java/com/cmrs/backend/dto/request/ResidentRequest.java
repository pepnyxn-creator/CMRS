package com.cmrs.backend.dto.request;

import com.cmrs.backend.entity.enums.ResidentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentRequest {

    @NotBlank(message = "Full name is required")
    @Size(max = 100)
    private String fullName;

    @NotBlank(message = "Phone is required")
    @Size(max = 20)
    private String phone;

    @NotNull(message = "Resident type is required")
    private ResidentType residentType;

    @NotNull(message = "Status is required")
    private Boolean isActive;

}
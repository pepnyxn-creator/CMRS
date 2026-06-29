package com.cmrs.backend.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {

    @NotNull
    private Long residentRoomHistoryId;

    @NotNull
    private Long vehicleId;

    @NotNull
    private Long createdBy;

    @NotNull
    private LocalDate registerDate;

    private LocalDate unregisterDate;

    private String remark;

}
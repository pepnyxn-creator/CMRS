package com.cmrs.backend.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentRoomHistoryRequest {

    @NotNull(message = "Resident is required")
    private Long residentId;

    @NotNull(message = "Room is required")
    private Long roomId;

    @NotNull(message = "Move in date is required")
    private LocalDate moveInDate;

    private LocalDate moveOutDate;

}
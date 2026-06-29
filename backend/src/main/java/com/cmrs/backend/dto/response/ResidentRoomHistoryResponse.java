package com.cmrs.backend.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentRoomHistoryResponse {

    private Long id;

    private Long residentId;

    private String residentName;

    private Long roomId;

    private String roomNumber;

    private LocalDate moveInDate;

    private LocalDate moveOutDate;

}
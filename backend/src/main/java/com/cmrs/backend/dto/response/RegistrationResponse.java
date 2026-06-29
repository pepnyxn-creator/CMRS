package com.cmrs.backend.dto.response;

import com.cmrs.backend.entity.enums.RegistrationStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationResponse {

    private Long id;

    private String stickerCode;

    private RegistrationStatus status;

    private String residentName;

    private String roomNumber;

    private String plateNumber;

    private String province;

    private LocalDate registerDate;

    private LocalDate unregisterDate;

    private Integer printedCount;

    private LocalDateTime lastPrintedAt;

    private String remark;

    private String createdBy;

}
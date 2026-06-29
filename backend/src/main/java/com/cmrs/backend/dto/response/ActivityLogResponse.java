package com.cmrs.backend.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLogResponse {

    private Long id;

    private String username;

    private String fullName;

    private String action;

    private String description;

    private LocalDateTime createdAt;

}
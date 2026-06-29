package com.cmrs.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettingRequest {

    @NotBlank
    @Size(max = 150)
    private String condoName;

    private String logo;

    @NotBlank
    @Size(max = 10)
    private String stickerPrefix;

    @NotNull
    private Integer nextStickerNumber;

}
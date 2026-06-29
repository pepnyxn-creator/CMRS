package com.cmrs.backend.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettingResponse {

    private Long id;

    private String condoName;

    private String logo;

    private String stickerPrefix;

    private Integer nextStickerNumber;

}
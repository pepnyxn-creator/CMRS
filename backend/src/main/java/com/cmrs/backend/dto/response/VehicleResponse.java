package com.cmrs.backend.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponse {

    private Long id;

    private String plateNumber;

    private String province;

    private String brand;

    private String model;

    private String color;

    private String vehicleImage;

    private String plateImage;

    private Boolean isActive;

}
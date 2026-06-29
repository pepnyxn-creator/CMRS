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
public class VehicleRequest {

    @NotBlank(message = "Plate number is required")
    @Size(max = 20)
    private String plateNumber;

    @NotBlank(message = "Province is required")
    @Size(max = 100)
    private String province;

    @NotBlank(message = "Brand is required")
    @Size(max = 100)
    private String brand;

    @NotBlank(message = "Model is required")
    @Size(max = 100)
    private String model;

    @NotBlank(message = "Color is required")
    @Size(max = 50)
    private String color;

    private String vehicleImage;

    private String plateImage;

    @NotNull(message = "Status is required")
    private Boolean isActive;

}
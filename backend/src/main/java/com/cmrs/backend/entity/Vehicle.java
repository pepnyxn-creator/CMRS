package com.cmrs.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(
        name = "vehicles",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_vehicle_plate",
                        columnNames = {"plate_number", "province"}
                )
        }
)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plate_number", nullable = false, length = 20)
    private String plateNumber;

    @Column(nullable = false, length = 100)
    private String province;

    @Column(nullable = false, length = 100)
    private String brand;

    @Column(nullable = false, length = 100)
    private String model;

    @Column(nullable = false, length = 50)
    private String color;

    @Column(name = "vehicle_image")
    private String vehicleImage;

    @Column(name = "plate_image")
    private String plateImage;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @CreationTimestamp
    @JsonIgnore
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
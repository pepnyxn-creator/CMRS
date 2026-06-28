CREATE TABLE vehicles (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    plate_number VARCHAR(20) NOT NULL,

    province VARCHAR(100) NOT NULL,

    brand VARCHAR(100) NOT NULL,

    model VARCHAR(100) NOT NULL,

    color VARCHAR(50) NOT NULL,

    vehicle_image VARCHAR(255) NULL,

    plate_image VARCHAR(255) NULL,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT uk_vehicle_plate
        UNIQUE (plate_number, province)

);
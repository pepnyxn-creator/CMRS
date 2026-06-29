CREATE TABLE registrations (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    resident_room_history_id BIGINT NOT NULL,

    vehicle_id BIGINT NOT NULL,

    sticker_code VARCHAR(50) NOT NULL UNIQUE,

    status ENUM(
        'ACTIVE',
        'CHANGED',
        'EXPIRED',
        'CANCELLED',
        'SUSPENDED'
    ) NOT NULL DEFAULT 'ACTIVE',

    register_date DATE NOT NULL,

    unregister_date DATE NULL,

    printed_count INT NOT NULL DEFAULT 0,

    last_printed_at TIMESTAMP NULL,

    remark VARCHAR(255) NULL,

    created_by BIGINT NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_registration_resident_room_history
        FOREIGN KEY (resident_room_history_id)
        REFERENCES resident_room_history(id),

    CONSTRAINT fk_registration_vehicle
        FOREIGN KEY (vehicle_id)
        REFERENCES vehicles(id),

    CONSTRAINT fk_registration_created_by
        FOREIGN KEY (created_by)
        REFERENCES users(id)

);
CREATE TABLE resident_room_history (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    resident_id BIGINT NOT NULL,

    room_id BIGINT NOT NULL,

    move_in_date DATE NOT NULL,

    move_out_date DATE NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_rrh_resident
        FOREIGN KEY (resident_id)
        REFERENCES residents(id),

    CONSTRAINT fk_rrh_room
        FOREIGN KEY (room_id)
        REFERENCES rooms(id)

);
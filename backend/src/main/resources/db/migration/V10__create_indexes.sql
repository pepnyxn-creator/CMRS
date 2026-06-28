-- ==========================================
-- USERS
-- ==========================================

CREATE INDEX idx_users_username
ON users(username);

-- ==========================================
-- ROOMS
-- ==========================================

CREATE INDEX idx_rooms_room_number
ON rooms(room_number);

-- ==========================================
-- RESIDENTS
-- ==========================================

CREATE INDEX idx_residents_phone
ON residents(phone);

-- ==========================================
-- VEHICLES
-- ==========================================

CREATE INDEX idx_vehicle_plate
ON vehicles(plate_number);

-- ==========================================
-- REGISTRATIONS
-- ==========================================

CREATE INDEX idx_registration_sticker
ON registrations(sticker_code);

CREATE INDEX idx_registration_status
ON registrations(status);
-- ==========================================
-- Default Admin
-- ==========================================

INSERT INTO users (
    username,
    password,
    full_name,
    role
)
VALUES (
    'admin',
    'admin123',
    'Administrator',
    'ADMIN'
);

-- ==========================================
-- System Settings
-- ==========================================

INSERT INTO settings (
    condo_name,
    sticker_prefix,
    next_sticker_number
)
VALUES (
    'S SPACE CONDO',
    'S',
    1
);
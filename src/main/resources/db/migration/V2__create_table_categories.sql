CREATE TABLE IF NOT EXISTS categories (
    id VARCHAR(150) PRIMARY KEY DEFAULT REPLACE(uuid_generate_v4()::text, '-',''),
    title VARCHAR(150) UNIQUE NOT NULL
);
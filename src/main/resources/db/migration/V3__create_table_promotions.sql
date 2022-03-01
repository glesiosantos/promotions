CREATE TABLE IF NOT EXISTS promotions (
    id VARCHAR(150) PRIMARY KEY DEFAULT REPLACE(uuid_generate_v4()::text, '-',''),
    title VARCHAR(150) NOT NULL,
    link_promotion VARCHAR(150) NOT NULL,
    site_promotion VARCHAR(100) NOT NULL,
    descritpion TEXT,
    image_link VARCHAR(150) NOT NULL,
    price DECIMAL(10,2) NOT NULL DEFAULT '0.0',
    total_likes int DEFAULT '0',
    id_category VARCHAR(150) NOT NULL,
    created_at DATE NOT NULL DEFAULT 'now()',
    CONSTRAINT FK_PROMOTION_CATEGORY FOREIGN KEY (id_category) REFERENCES categories (id) ON UPDATE NO ACTION ON DELETE CASCADE
);
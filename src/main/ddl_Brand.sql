CREATE TABLE brand
(
    id            BIGINT       NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL
);
CREATE TABLE brands
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(100)          NULL,
    `description` VARCHAR(255)          NULL,
    CONSTRAINT pk_brands PRIMARY KEY (id)
);
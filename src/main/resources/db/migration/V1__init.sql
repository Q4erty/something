CREATE SCHEMA IF NOT EXISTS alpha;

CREATE TABLE IF NOT EXISTS alpha.product
(
    id      SERIAL PRIMARY KEY,
    title   VARCHAR(255) NOT NULL,
    details TEXT
);
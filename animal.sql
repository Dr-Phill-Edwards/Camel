CREATE TABLE Animal (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    legs SMALLINT NOT NULL,
    flies BOOLEAN NOT NULL
);

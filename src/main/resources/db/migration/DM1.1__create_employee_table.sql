CREATE TABLE IF NOT EXISTS employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    second_name VARCHAR(255),
    email VARCHAR(200) NOT NULL,
    salary_per_hour DOUBLE,
    created_date TIMESTAMP,
    PRIMARY KEY (id)
);
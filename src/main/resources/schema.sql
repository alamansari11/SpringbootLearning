CREATE TABLE IF NOT EXISTS EMPLOYEES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date_of_joining DATE NOT NULL,
    is_active BOOLEAN NOT NULL
);

CREATE DATABASE testdb;
USE testdb;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    department VARCHAR(50),
    salary DECIMAL(10,2)
);

INSERT INTO employees (name, age, department, salary) VALUES
('張三', 30, 'IT', 60000),
('李四', 28, 'HR', 50000),
('王五', 35, 'Finance', 70000);
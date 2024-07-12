DROP DATABASE IF EXISTS cardealership;

CREATE DATABASE cardealership;

CREATE TABLE dealerships (
    dealership_id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(12)
);

CREATE TABLE vehicles (
    vehicle_id SERIAL PRIMARY KEY,
    vin TEXT,
    sold BOOLEAN,
    make TEXT,
    model TEXT,
    year INT,
    color TEXT,
    mileage INT,
    price FLOAT
);

CREATE TABLE inventory (
    dealership_id INT NOT NULL,
    vehicle_id INT NOT NULL,
    FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
);

CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    first_name TEXT,
    last_name TEXT,
    phone_number TEXT,
    address TEXT,
    email TEXT
);

CREATE TABLE sales_contracts (
    sale_id SERIAL PRIMARY KEY,
    vehicle_id INT NOT NULL,
    customer_id INT NOT NULL,
    price FLOAT,
    date DATE NOT NULL DEFAULT CURRENT_DATE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);


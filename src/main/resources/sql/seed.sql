-- Inserting data into dealerships
INSERT INTO dealerships (name, address, phone)
VALUES ('Gru’s Auto Emporium', '123 Minion Lane', '555-123-4567'),
       ('Vector’s Vehicle Vault', '456 Moon Drive', '555-765-4321'),
       ('Nefario Motors', '101 Gadget Grove', '555-111-2222'),
       ('Margo’s Minicars', '202 El Macho Lane', '555-333-4444'),
       ('Edith’s Speedsters', '303 Unicorn Rd', '555-555-6666');

-- Inserting data into vehicles
INSERT INTO vehicles (vin, sold, make, model, year, color, mileage, price)
VALUES ('2FMDK3GC4ABB56789', FALSE, 'Ford', 'Escape', 2021, 'Black', 5000, 25000.00),
       ('1N4AL3AP0FC123456', FALSE, 'Nissan', 'Altima', 2022, 'Silver', 3000, 23000.00),
       ('3FAHP0HA5CR289012', FALSE, 'Chevrolet', 'Malibu', 2020, 'Red', 7000, 21000.00),
       ('1G9DM9E40BR000001', FALSE, 'GruMobile', 'Spaceship', 2021, 'Black', 500, 100000.00),
       ('2H9VM9E42CR000002', FALSE, 'MinionMobile', 'Banana', 2022, 'Yellow', 100, 20000.00),
       ('3J9WM9E44DR000003', FALSE, 'Vector', 'Airship', 2020, 'Orange', 200, 90000.00),
       ('4K9XM9E46ER000004', FALSE, 'Nefario', 'Bike', 2021, 'Green', 300, 15000.00),
       ('5L9YM9E48FR000005', FALSE, 'Margo', 'Scooter', 2022, 'Pink', 100, 5000.00),
       ('6M9ZM9E50GR000006', FALSE, 'Edith', 'Skateboard', 2020, 'Purple', 50, 3000.00),
       ('7N9AN9E52HR000007', FALSE, 'Agnes', 'Unicorn', 2021, 'White', 75, 25000.00),
       ('8O9BN9E54IR000008', FALSE, 'ElMacho', 'Tank', 2022, 'Red', 400, 80000.00),
       ('9P9CN9E56JR000009', FALSE, 'Lucy', 'SpyCar', 2020, 'Silver', 250, 70000.00),
       ('1Q9DN9E58KR000010', FALSE, 'DrNefario', 'Rocket', 2021, 'Blue', 100, 120000.00),
       ('2R9EN9E60LR000011', FALSE, 'Dru', 'Roadster', 2022, 'Gold', 150, 85000.00),
       ('3S9FN9E62MR000012', FALSE, 'Kyle', 'DogVan', 2020, 'Grey', 200, 40000.00),
       ('4T9GN9E64NR000013', FALSE, 'AntiVillainLeague', 'Submarine', 2021, 'Black', 300, 95000.00),
       ('5U9HN9E66OR000014', FALSE, 'Minions', 'IceCreamTruck', 2022, 'White', 100, 30000.00),
       ('6V9IN9E68PR000015', FALSE, 'WildKnuckles', 'Motorcycle', 2020, 'Black', 500, 20000.00);

-- Inserting data into inventory
INSERT INTO inventory (dealership_id, vehicle_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 4),
       (5, 5),
       (4, 6),
       (2, 7),
       (1, 8),
       (1, 9),
       (1, 10),
       (4, 11),
       (5, 12),
       (3, 13),
       (3, 14),
       (3, 15),
       (5, 16),
       (5, 17),
       (2, 18),
       (2, 19),
       (5, 20),
       (1, 21),
       (2, 22),
       (3, 23),
       (4, 24),
       (5, 25),
       (2, 26),
       (3, 27),
       (4, 28);

-- Inserting data into customers
INSERT INTO customers (first_name, last_name, phone_number, address, email)
VALUES ('Felonius', 'Gru', '555-678-1234', '123 Minion Lane', 'gru@despicable.me'),
       ('Lucy', 'Wilde', '555-987-6543', '456 Spy Gear Ave', 'lucy.wilde@secretagent.com'),
       ('Vector', 'Perkins', '555-555-5555', '789 Evil Lair Blvd', 'vector@ohyeah.com'),
       ('Gru', 'Felonius', '555-0101', '123 Evil Street, Freedonia', 'gru@evilmastermind.com'),
       ('Lucy', 'Wilde', '555-0102', '124 Evil Street, Freedonia', 'lucy@secretagent.com'),
       ('Margo', 'Gru', '555-0103', '123 Evil Street, Freedonia', 'margo@minionmail.com'),
       ('Edith', 'Gru', '555-0104', '123 Evil Street, Freedonia', 'edith@minionmail.com'),
       ('Agnes', 'Gru', '555-0105', '123 Evil Street, Freedonia', 'agnes@minionmail.com'),
       ('Vector', 'Perkins', '555-0106', '1 Vector''s Fortress, Freedonia', 'vector@villains.com'),
       ('Dr.', 'Nefario', '555-0107', 'Lab 5, Minion Factory, Freedonia', 'dr.nefario@evilinventions.com');

-- Inserting data into sales_contracts
INSERT INTO sales_contracts (vehicle_id, customer_id, price, date)
VALUES (1, 1, 25000.00, '2023-04-01'),
       (2, 2, 23000.00, '2023-04-02'),
       (3, 3, 21000.00, '2023-04-03'),
       (4, 4, 15500.00, '2023-04-04'),
       (5, 5, 5500.00, '2023-04-05'),
       (6, 1, 108000.00, '2023-04-06'),
       (7, 2, 21500.00, '2023-04-07'),
       (8, 3, 94000.00, '2023-04-08'),
       (9, 4, 15800.00, '2023-04-09'),
       (10, 5, 5700.00, '2023-04-10'),
       (11, 1, 110000.00, '2023-04-11'),
       (12, 2, 22000.00, '2023-04-12'),
       (13, 3, 93000.00, '2023-04-13'),
       (14, 4, 16000.00, '2023-04-14'),
       (15, 5, 5600.00, '2023-04-15');
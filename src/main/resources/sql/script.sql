SELECT * FROM dealerships;

SELECT v.*
FROM vehicles v
         JOIN inventory i ON v.vehicle_id = i.vehicle_id
         JOIN dealerships d ON i.dealership_id = d.dealership_id
WHERE d.dealership_id = 1;

SELECT * FROM vehicles WHERE vin = '2H9VM9E42CR000002';

SELECT name FROM dealerships
            JOIN inventory ON dealerships.dealership_id = inventory.dealership_id
            JOIN vehicles ON inventory.vehicle_id = vehicles.vehicle_id
WHERE vin = '2H9VM9E42CR000002';

SELECT DISTINCT name FROM dealerships d
        JOIN inventory i ON d.dealership_id = i.dealership_id
        JOIN vehicles v ON i.vehicle_id = v.vehicle_id
WHERE make = 'GruMobile' AND model = 'Spaceship';

SELECT s.sale_id, s.vehicle_id, s.customer_id, s.price, s.date, v.make, v.model, v.year
FROM sales_contracts s
         JOIN inventory i ON s.vehicle_id = i.vehicle_id
         JOIN vehicles v ON s.vehicle_id = v.vehicle_id
WHERE i.dealership_id = 4
  AND s.date BETWEEN '2023-01-01' AND '2024-01-31';
1.
SELECT trip_no, plane, town_from, town_to FROM trip
WHERE plane = 'TU-134' ORDER BY time_out DESC;

2.
SELECT * FROM pc WHERE model LIKE '%1%1%';

2.1 (second var)
SELECT DISTINCT model FROM PC 
WHERE model LIKE '%1%1%';

3.

4.
SELECT ship, battle, date 
FROM Battles 
JOIN Outcomes ON battle=name 
WHERE result LIKE 'damaged';

5.
SELECT maker FROM Product 
LEFT JOIN PC 
ON Product.model = PC.model 
where type = 'Printer' 
AND maker = ANY (
	SELECT maker from Product
	JOIN PC
	ON PC.model = Product.model
	where ram <= ALL(
		SELECT ram FROM PC));

6.
SELECT SUBSTRING(place, 1, 1) AS 'Row', 
SUBSTRING(place, 2, 1) AS Place
FROM Pass_in_trip;

7.
SELECT maker 
FROM Product
LEFT JOIN Pc USING (model)
WHERE TYPE = 'PC'
GROUP BY maker
	HAVING COUNT(DISTINCT Pc.model) BETWEEN maker AND COUNT(DISTINCT Product.model) - 1;

8.
SELECT Product.maker,
	COUNT(pc_data.model) AS PC,
	COUNT(laptop_data.model) AS Laptop,
	COUNT(printer_data.model) AS Printer 
FROM Product
LEFT OUTER JOIN 
	(SELECT maker,PC.model FROM PC 
	JOIN Product 
	ON PC.model=Product.model) AS pc_data
ON Product.model=pc_data.model
LEFT OUTER JOIN 
	(SELECT maker,Laptop.model FROM Laptop 
	JOIN Product 
	ON Laptop.model=Product.model) AS laptop_data
ON Product.model=laptop_data.model
LEFT OUTER JOIN 
	(SELECT maker,Printer.model FROM Printer 
	JOIN Product 
	ON Printer.model=Product.model) AS printer_data
ON Product.model=printer_data.model
GROUP BY maker 
ORDER BY 1;

10.
SELECT type, product.model, MAX(price) AS maxPrice
FROM 
	(SELECT model, price 
		FROM Pc
		UNION SELECT model, price  
		FROM Printer
		UNION SELECT model, price 
		FROM Laptop) AS prod JOIN product ON prod.model = product.model 
	GROUP BY product.type ;

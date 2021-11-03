# dbLab

### 2-nd Lab Tasks (V-57)

1. DB "Airport". Find the numbers of all flights on which the plane runs 'TU-134'. Display: trip_no, plane, town_from, town_to. 
Output data sort in descending order by time_out column.

2. DB "Comp. firm". List all PC models that have at least the numbers two units.

3. DB "Ships". Find countries that had classes of both conventional warships 'bb' and classes of cruisers 'bc'. 
Output: country, types from class 'bb', types with class 'bc'.

4. DB "Ships". Find ships "saved for future battles", that is, those that were disabled in one battle ('damaged') and then again took part in battles. 
Display: ship, battle, date.

5. DB "Comp. firm". Find the manufacturers of the printers that make the PC with the least amount of RAM. Print: maker.

6. DB "Airport". For the Pass_in_trip table, the value of the place column split into two columns with comments, for example, 
the first - 'row: 2' and the second is 'place: a'.

7. DB "Comp. firm". Find those PC manufacturers for which not all PC models are available in the PC table (use group tools statistics). Print maker.

8. DB "Comp. firm". For the Product table get the final set in the form of a table with columns maker, pc, laptop and printer, 
in which for each manufacturer must specify the number of different products that it is produced, those products with different (unique) numbers
models in the tables, respectively, PC, Laptop and Printer. (Hint: use subqueries as computational columns).

9. DB "Firm received. recyclables ". Assuming income and expense money at each point of reception is fixed not more often than one once a day 
(Income_o and Outcome_o tables only), write a query from such source data: point (point), date (date), inc (arrival), out (consumption). 
(Tip: Use external connection and operator CASE).

10. DB "Comp. firm". For each product model, print from the entire database its highest price. Output: type, model, maximum price. 
(Hint: use the UNION operator).


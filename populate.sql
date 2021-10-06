INSERT INTO agency_type (name) VALUES
('Event agency'),
('Real estate agency'),
('Staffing agency'),
('Modeling agency'),
('Information agency'),
('Event agency');

INSERT INTO agency (agency_type_id, name_agency) VALUES
(6, 'Piken'),
(6, 'HollyWood'),
(6, 'Applevent'),
(6, 'BananaDay'),
(6, 'Mover'),
(6, 'KinderEvent'),
(6, 'Anima'),
(6, 'JoyLviv'),
(6, 'Zefirka'),
(6, 'HappyDay');

INSERT INTO event (name, event_duration, date_of_the_event, event_address) VALUES
('First Bell', '02:00:00', '2021-09-01 9:00:00.00', 'School Numero 11'),
('First Bell', '02:30:00', '2021-09-01 8:30:00.00', 'School Numero 56'),
('Company Corporate', '06:00:00', '2021-12-31 20:00:00.00', 'Hotel Otaman'),
('Birthday 18 years', '3:30:00', '2021-12-22 17:30:00.00', 'Dovzhenka 16a'),
('First Bell', '02:00:00', '2021-09-01 9:00:00.00', 'Horodotksa 32'),
('Marriage', '12:00:00', '2021-10-15 16:00:00.00', 'Lysenka 1'),
('Kid Birthday', '06:40:00', '2021-11-11 12:30:00.00', 'Vernadskogo 44'),
('First Bell', '02:15:00', '2021-09-01 9:00:00.00', 'School Numero 8'),
('Night House Party', '08:00:00', '2021-12-11 23:30:00.00', '13 Av. Jules Ferry');

INSERT INTO price (salary, agency_salary) VALUES
('10000', '1000'),
('12400', '1240'),
('9000', '600'),
('13000', '1100'),
('8900', '650'),
('8500', '700'),
('13700', '1370'),
('21500', '2150'),
('16000', '2300'),
('9400', '890');

INSERT INTO client (name, last_name) VALUES
('Oleksandr', 'Humeniuk'),
('Ars', 'Siu'),
('Mykhailo', 'Mid'),
('Max', 'Tkachuk'),
('Andrii', 'Shumskyi'),
('Vitalii', 'Musya'),
('Vladuslav', 'Paza'),
('Mykhailo', 'Tanchuk'),
('Anna', 'Monast');

INSERT INTO animator (name, last_name, age, passport) VALUES
('Natalia', 'Pis', 19, 12345),
('Oleksandr', 'Ilukhin', 24, 23456),
('Vadym', 'Zavgorodnii', 27, 34567),
('Volodumur', 'Shabanov', 45, 45789),
('Eugenii', 'Pshenychnyi', 37, 34213),
('Vitalii', 'Break', 21, 65436),
('Artem', 'Rys', 34, 43567),
('Oksana', 'Shevko', 31, 58974),
('Viktoria', 'Lucenko', 22, 38497),
('Den', 'ied', 18, 53478);

INSERT INTO order_client (animator_id, agency_id, event_id, client_id, price_id) VALUES
(2, 1, 3, 6, 5),
(3, 3, 1, 8, 9),
(4, 7, 8, 3, 1),
(6, 3, 6, 1, 7),
(1, 5, 7, 2, 6),
(7, 2, 2, 4, 3),
(1, 4, 5, 6, 4);


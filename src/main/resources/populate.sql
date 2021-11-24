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

INSERT INTO event_address (street, postal_code) VALUES
('School Numero 11', '22-100'),
('School Numero 56', '21-100'),
('Dovzhenka 16a', '11-100'),
('Vernadskogo 44', '15-100'),
('Hotel Otaman', '12-100'),
('Horodotksa 32', '14-100'),
('School Numero 8', '13-100'),
('13 Av. Jules Ferry', '10-100'),
('Lysenka 1', '16-100');

INSERT INTO event (name, event_duration, date_of_the_event, event_address_id) VALUES
('First Bell', '02:00:00', '2021-09-01 9:00:00.00', 1),
('First Bell', '02:30:00', '2021-09-01 8:30:00.00', 2),
('Company Corporate', '06:00:00', '2021-12-31 20:00:00.00', 5),
('Birthday 18 years', '3:30:00', '2021-12-22 17:30:00.00', 3),
('First Bell', '02:00:00', '2021-09-01 9:00:00.00', 6),
('Marriage', '12:00:00', '2021-10-15 16:00:00.00', 9),
('Kid Birthday', '06:40:00', '2021-11-11 12:30:00.00', 4),
('First Bell', '02:15:00', '2021-09-01 9:00:00.00', 7),
('Night House Party', '08:00:00', '2021-12-11 23:30:00.00', 8);

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

INSERT INTO client (name, last_name, phone_number) VALUES
('Oleksandr', 'Humeniuk', '+380 68 522 9948'),
('Ars', 'Siu', '+380 66 337 5846'),
('Mykhailo', 'Mid', '+380 73 238 9446'),
('Max', 'Tkachuk', '+380 50 466 8488'),
('Andrii', 'Shumskyi', '+380 63 911 1585'),
('Vitalii', 'Musya', '+380 66 616 7293'),
('Vladuslav', 'Paza', '+380 50 708 3128'),
('Mykhailo', 'Tanchuk', '+380 66 310 4715'),
('Anna', 'Monast', '+380 67 854 3448');

INSERT INTO animator (name, last_name, age) VALUES
('Natalia', 'Pis', 19),
('Oleksandr', 'Ilukhin', 24),
('Vadym', 'Zavgorodnii', 27),
('Volodumur', 'Shabanov', 45),
('Eugenii', 'Pshenychnyi', 37),
('Vitalii', 'Break', 21),
('Artem', 'Rys', 34),
('Oksana', 'Shevko', 31),
('Viktoria', 'Lucenko', 22),
('Den', 'ied', 18);

INSERT INTO agency_animator (agency_id, animator_id) VALUES
(1, 2),
(2, 3),
(3, 3),
(4, 3),
(5, 1),
(6, 4),
(7, 5),
(8, 6),
(9, 7),
(10, 8),
(9, 9),
(8, 10);


INSERT INTO order_client (animator_id, agency_id, event_id, client_id, price_id) VALUES
(2, 1, 3, 6, 5),
(3, 3, 1, 8, 9),
(4, 7, 8, 3, 1),
(6, 3, 6, 1, 7),
(1, 5, 7, 2, 6),
(7, 2, 2, 4, 3),
(1, 4, 5, 6, 4);


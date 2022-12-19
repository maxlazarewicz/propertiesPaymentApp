insert into `file_data` VALUES
(1,'2022-11-03 18:55:17','string', '','string'),
(2,'2022-11-03 18:55:17','string', '','string1'),
(3,'2022-11-03 19:38:00','string', '','string1');

insert into `lead_status` VALUES
(1,'Nowy','Nowy'),
(2,'Oczekujący','Oczekujący'),
(3,'Zrealizowalny','Zrealizowany'),
(4,'Zakończony','Zakończony');

insert into `property` VALUES
(1,23,'Warszawa',1,'61-222','Mazowieckie','Test1'),
(2,48,'Warszawa',3,'05-520','Mazowieckie','Mirkowska'),
(3,48,'Konstancin',4,'05-525','Mazowieckie','Mirkowska');

insert into `roles` VALUES
(1, 'ROLE_ADMIN', 'Admin'),
(2, 'ROLE_TENANT', 'Tenant'),
(3, 'ROLE_OWNER', 'Owner');

insert into `users` values
(1, 'mxlazarewicz@gmail.com', 'Maks', 'Lazarewicz', 'pass123', '509411644', 'mx_94'),
(2, 'mat34', 'mxlazarewicz@gmail.com', 'Mateusz', 'Kowalski', 'paspas123', '678097654'),
(3, 'kat24', 'mxlazarewicz@gmail.com', 'Katarzyna', 'Kowalska', 'paspaspas321', '540340230');

insert into `leads` VALUES
(1,'2022-10-26 18:31:08',NULL,'333','123','222',1,1,'owner','tenant'),
(2,'2022-10-26 18:53:11',NULL,'333','123','222',2,2,'owner','tenant'),
(3,'2022-11-03 19:33:12',NULL,'1500',NULL,'3242',3,3,'owner','tenant');
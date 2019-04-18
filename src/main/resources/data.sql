INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Rome', 'david@david.com', 'David', 'Hatson', 'VD 345765', '380479873409');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Rome', 'sara@sara.com', 'Sara', 'Hatson', 'VI 749765', '380479809834');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Berlin', 'genri@genri.com', 'Genri', 'Shmid', 'NG 564789', '380485680324');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Paris', 'poly@poly.com', 'Poly', 'Loren', 'OU 949403', '380648390923');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Dublin', 'maykl@maykl.com', 'Maykl', 'Stivenson', 'DF 949734', '380985674389');


INSERT INTO hotel_rooms (count_price, facilitie, finish_date, number_room, price, service, start_date, status, type_room)
VALUES (null, '', '', '1', 100, '', '', false, 'standard');
INSERT INTO hotel_rooms (count_price, facilitie, finish_date, number_room, price, service, start_date, status, type_room)
VALUES (null, '', '', '2', 115, '', '', false, 'standard');
INSERT INTO hotel_rooms (count_price, facilitie, finish_date, number_room, price, service, start_date, status, type_room)
VALUES (168, '', '13.07.2019', '3', 123, '', '07.07.2019', true, 'standard');
INSERT INTO hotel_rooms (count_price, facilitie, finish_date, number_room, price, service, start_date, status, type_room)
VALUES (208, '', '01.05.2019', '4', 180, '', '26.04.2019', true, 'comfort');
INSERT INTO hotel_rooms (count_price, facilitie, finish_date, number_room, price, service, start_date, status, type_room)
VALUES (null, '', '', '5', '195', '', '', false, 'comfort');
INSERT INTO hotel_rooms (count_price, facilitie, finish_date, number_room, price, service, start_date, status, type_room)
VALUES (246, '', '06.06.2019', '6', 200, '', '31.05.2019', true, 'comfort');
INSERT INTO hotel_rooms (count_price, facilitie, finish_date, number_room, price, service, start_date, status, type_room)
VALUES (null, '', '', '7', 256, '', '', false, 'lux');
INSERT INTO hotel_rooms (count_price, facilitie, finish_date, number_room, price, service, start_date, status, type_room)
VALUES (null, '', '', '8', 284, '', '', false, 'lux');
INSERT INTO hotel_rooms (count_price, facilitie, finish_date, number_room, price, service, start_date, status, type_room)
VALUES (null, '', '', '9', 305, '', '', false, 'lux');
INSERT INTO hotel_rooms (count_price, facilitie, finish_date, number_room, price, service, start_date, status, type_room)
VALUES (593 , '', '13.09.2019', '10', 500, '', '05.09.2019', true, 'premium-lux');


INSERT INTO additional_services(price, service_name) VALUES ('15', 'parking');
INSERT INTO additional_services(price, service_name) VALUES ('20', 'Ironing service');
INSERT INTO additional_services(price, service_name) VALUES ('35', 'Dry cleaning');
INSERT INTO additional_services(price, service_name) VALUES ('23', 'Shoeshine');

INSERT INTO additional_facilities(facilitie_name, price) VALUES ('Breakfast in the room', '10');
INSERT INTO additional_facilities(facilitie_name, price) VALUES ('Breakfast', '28');
INSERT INTO additional_facilities(facilitie_name, price) VALUES ('Electric kettle', '3');
INSERT INTO additional_facilities(facilitie_name, price) VALUES ('Hairdryer', '5');
INSERT INTO additional_facilities(facilitie_name, price) VALUES ('Kids'' meals', '32');

INSERT INTO hotel_rooms_profiles(hotel_rooms_id, profile_id) VALUES (10, 1);
INSERT INTO hotel_rooms_profiles(hotel_rooms_id, profile_id) VALUES (10, 2);
INSERT INTO hotel_rooms_profiles(hotel_rooms_id, profile_id) VALUES (6, 3);
INSERT INTO hotel_rooms_profiles(hotel_rooms_id, profile_id) VALUES (4, 4);
INSERT INTO hotel_rooms_profiles(hotel_rooms_id, profile_id) VALUES (3, 5);

INSERT INTO hotel_rooms_additional_facilities(hotel_rooms_id, additional_facilitie_id) VALUES (10, 1);
INSERT INTO hotel_rooms_additional_facilities(hotel_rooms_id, additional_facilitie_id) VALUES (10, 2);
INSERT INTO hotel_rooms_additional_facilities(hotel_rooms_id, additional_facilitie_id) VALUES (10, 4);
INSERT INTO hotel_rooms_additional_facilities(hotel_rooms_id, additional_facilitie_id) VALUES (6, 2);
INSERT INTO hotel_rooms_additional_facilities(hotel_rooms_id, additional_facilitie_id) VALUES (6, 3);
INSERT INTO hotel_rooms_additional_facilities(hotel_rooms_id, additional_facilitie_id) VALUES (4, 4);
INSERT INTO hotel_rooms_additional_facilities(hotel_rooms_id, additional_facilitie_id) VALUES (3, 1);




INSERT INTO hotel_rooms_additional_services(hotel_rooms_id, additional_service_id) VALUES (10, 1);
INSERT INTO hotel_rooms_additional_services(hotel_rooms_id, additional_service_id) VALUES (10, 3);
INSERT INTO hotel_rooms_additional_services(hotel_rooms_id, additional_service_id) VALUES (6, 1);
INSERT INTO hotel_rooms_additional_services(hotel_rooms_id, additional_service_id) VALUES (4, 4);
INSERT INTO hotel_rooms_additional_services(hotel_rooms_id, additional_service_id) VALUES (3, 2);
INSERT INTO hotel_rooms_additional_services(hotel_rooms_id, additional_service_id) VALUES (3, 1);













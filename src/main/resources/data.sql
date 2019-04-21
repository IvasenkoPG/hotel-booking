INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Rome', 'david@david.com', 'David', 'Hatson', 'VD 345765', '380479873409');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Madrid', 'sara@sara.com', 'Sara', 'Gamma', 'VI 749765', '380479809834');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Berlin', 'genri@genri.com', 'Genri', 'Shmid', 'NG 564789', '380485680324');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Paris', 'poly@poly.com', 'Poly', 'Loren', 'OU 949403', '380648390923');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Dublin', 'maykl@maykl.com', 'Maykl', 'Stivenson', 'DF 949734', '380985674389');


INSERT INTO hotel_rooms (count_additional_price, additional_price, count_price, facilitie, number_room, price, service, status, type_room, profile_id)
VALUES (224, 28, 1024, 'Electric kettle', '1', 100, 'parking', true, 'standard', 5);
INSERT INTO hotel_rooms (count_additional_price, additional_price, count_price, facilitie, number_room, price, service,status, type_room, profile_id)
VALUES (null , 28, null , 'Electric kettle', '2', 115, 'parking', false, 'standard', null);
INSERT INTO hotel_rooms (count_additional_price, additional_price, count_price, facilitie, number_room, price, service, status, type_room, profile_id)
VALUES (150,25,888, 'Hairdryer', '3', 123, 'Shoeshine', true, 'standard', 2);
INSERT INTO hotel_rooms (count_additional_price, additional_price, count_price, facilitie, number_room, price, service, status, type_room, profile_id)
VALUES (96, 48, 456, 'Breakfast', '4', 180, 'Shoeshine', true, 'comfort',4);
INSERT INTO hotel_rooms (count_additional_price, additional_price, count_price, facilitie, number_room, price, service, status, type_room, profile_id)
VALUES (null, 43, null, 'Breakfast', '5', 195, 'Shoeshine', false, 'comfort', null);
INSERT INTO hotel_rooms (count_additional_price, additional_price, count_price, facilitie, number_room, price, service, status, type_room, profile_id)
VALUES (180, 36, 1180, 'Breakfast', '6', 200, 'Ironing service', true, 'comfort', 3);
INSERT INTO hotel_rooms (count_additional_price, additional_price, count_price, facilitie, number_room, price, service, status, type_room, profile_id)
VALUES (null, 52, null, 'Breakfast in the room', '7', 256, 'Ironing service', false, 'lux', null);
INSERT INTO hotel_rooms (count_additional_price, additional_price, count_price, facilitie, number_room, price, service, status, type_room, profile_id)
VALUES (null, 52, null, 'Breakfast in the room', '8', 284, 'Ironing service', false, 'lux', null);
INSERT INTO hotel_rooms (count_additional_price, additional_price, count_price, facilitie, number_room, price, service, status, type_room, profile_id)
VALUES (null, 51, null, 'Breakfast in the room', '9', 305, 'Dry cleaning', false, 'lux', null);
INSERT INTO hotel_rooms (count_additional_price, additional_price, count_price, facilitie, number_room, price, service, status, type_room, profile_id)
VALUES (348, 58, 3348 , 'Breakfast in the room', '10', 500, 'Dry cleaning', true, 'premium-lux', 1);


INSERT INTO reservation_date(finish_date, start_date) VALUES ('2019-09-13', '2019-09-05');
INSERT INTO reservation_date(finish_date, start_date) VALUES ('2019-06-06', '2019-05-31');
INSERT INTO reservation_date(finish_date, start_date) VALUES ('2019-05-01', '2019-04-26');
INSERT INTO reservation_date(finish_date, start_date) VALUES ('2019-07-13', '2019-07-07');
INSERT INTO reservation_date(finish_date, start_date) VALUES ('2019-04-29', '2019-04-27');

INSERT INTO hotel_rooms_reservation_dates(hotel_rooms_id, reservation_dates_id) VALUES (1,1);
INSERT INTO hotel_rooms_reservation_dates(hotel_rooms_id, reservation_dates_id) VALUES (3,2);
INSERT INTO hotel_rooms_reservation_dates(hotel_rooms_id, reservation_dates_id) VALUES (4,5);
INSERT INTO hotel_rooms_reservation_dates(hotel_rooms_id, reservation_dates_id) VALUES (6,3);
INSERT INTO hotel_rooms_reservation_dates(hotel_rooms_id, reservation_dates_id) VALUES (10,4);















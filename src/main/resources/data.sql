INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Rome', 'david@david.com', 'David', 'Hatson', 'VD345765', '380479873409');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Madrid', 'sara@sara.com', 'Sara', 'Gamma', 'VI749765', '380479809834');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Berlin', 'genri@genri.com', 'Genri', 'Shmid', 'NG564789', '380485680324');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Paris', 'poly@poly.com', 'Poly', 'Loren', 'OU949403', '380648390923');
INSERT INTO profile (address, email, first_name, last_name, passport, telephone)
VALUES ('Dublin', 'maykl@maykl.com', 'Maykl', 'Stivenson', 'DF949734', '380985674389');


INSERT INTO hotel_rooms (additional_price_for_option, facilitie, number_room, price_room, service, type_room)
VALUES (28, 'Electric kettle', '1', 100, 'parking', 'standard');
INSERT INTO hotel_rooms (additional_price_for_option, facilitie, number_room, price_room, service, type_room)
VALUES (28, 'Electric kettle', '2', 115, 'parking', 'standard');
INSERT INTO hotel_rooms (additional_price_for_option, facilitie, number_room, price_room, service, type_room)
VALUES (25, 'Hairdryer', '3', 123, 'Shoeshine', 'standard');
INSERT INTO hotel_rooms (additional_price_for_option, facilitie, number_room, price_room, service, type_room)
VALUES (48, 'Breakfast', '4', 180, 'Shoeshine', 'comfort');
INSERT INTO hotel_rooms (additional_price_for_option, facilitie, number_room, price_room, service, type_room)
VALUES (43, 'Breakfast', '5', 195, 'Shoeshine', 'comfort');
INSERT INTO hotel_rooms (additional_price_for_option, facilitie, number_room, price_room, service, type_room)
VALUES (36, 'Breakfast', '6', 200, 'Ironing service', 'comfort');
INSERT INTO hotel_rooms (additional_price_for_option, facilitie, number_room, price_room, service, type_room)
VALUES (52, 'Breakfast in the room', '7', 256, 'Ironing service', 'lux');
INSERT INTO hotel_rooms (additional_price_for_option, facilitie, number_room, price_room, service, type_room)
VALUES (52, 'Breakfast in the room', '8', 284, 'Ironing service', 'lux');
INSERT INTO hotel_rooms (additional_price_for_option, facilitie, number_room, price_room, service, type_room)
VALUES (51, 'Breakfast in the room', '9', 305, 'Dry cleaning', 'lux');
INSERT INTO hotel_rooms (additional_price_for_option, facilitie, number_room, price_room, service, type_room)
VALUES (58, 'Breakfast in the room', '10', 500, 'Dry cleaning', 'premium-lux');


INSERT INTO reservation_hotel_room(additional_price_for_option_count, finish_date, price_room_count, start_date, hotel_rooms_id, profiles_id)
VALUES (224, '2019-09-13', 800, '2019-09-05', 1, 1);
INSERT INTO reservation_hotel_room(additional_price_for_option_count, finish_date, price_room_count, start_date, hotel_rooms_id, profiles_id)
VALUES (168, '2019-06-06', 690, '2019-05-31', 2, 2);
INSERT INTO reservation_hotel_room(additional_price_for_option_count, finish_date, price_room_count, start_date, hotel_rooms_id, profiles_id)
VALUES (125, '2019-05-01', 615, '2019-04-26', 3, 3);
INSERT INTO reservation_hotel_room(additional_price_for_option_count, finish_date, price_room_count, start_date, hotel_rooms_id, profiles_id)
VALUES (228, '2019-07-13', 1080, '2019-07-07', 4, 4);
INSERT INTO reservation_hotel_room(additional_price_for_option_count, finish_date, price_room_count, start_date, hotel_rooms_id, profiles_id)
VALUES (86, '2019-04-29', 390, '2019-04-27', 5, 5);














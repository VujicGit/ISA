insert into country (name) values ('Srbija');

insert into city (name, zip_code, country_id) values ('Novi Sad', '21000', 1);

insert into location (latitude, longitude) values (45.267136, 19.833549);
insert into location (latitude, longitude) values (45.24915928867009, 19.84284031690104);

insert into address (number, street, city_id, location_id) values ('8', 'Maksima Gorkog', 1, 1);
insert into address (number, street, city_id, location_id) values ('9', 'Maksima Gorkog', 1, 2);


insert into users (email, gender, identification_number, name, password, password_changed, phone, role, surname, verified, address_id)
    values ('user1@gmail.com', 0, '25029920098', 'Marko', 'markic', false, '065/322322', 3, 'Markovic', false, 1);

insert into employee (id) values (1);

insert into dermatologist (id, grade) values (1, 5.5);

insert into pharmacy (description, address_id) values ('Apoteka 1', 2);

insert into pharmacys_dermatolostist (pharmacy_id, dermatologist_id) values (1, 1);
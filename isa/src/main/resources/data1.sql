insert into country (name) values ('Srbija');

insert into city (name, zip_code, country_id) values ('Novi Sad', '21000', 1);

insert into location (latitude, longitude) values (45.267136, 19.833549);
insert into location (latitude, longitude) values (45.24915928867009, 19.84284031690104);
insert into location (latitude, longitude) values (45.24993937456046, 19.84684437097689);
insert into location (latitude, longitude) values (45.250312839697166, 19.84671996728179);

insert into address (number, street, city_id, location_id) values ('8', 'Maksima Gorkog', 1, 1);
insert into address (number, street, city_id, location_id) values ('9', 'Maksima Gorkog', 1, 2);
insert into address (number, street, city_id, location_id) values ('10', 'Maksima Gorkog', 1, 3);
insert into address (number, street, city_id, location_id) values ('11', 'Maksima Gorkog', 1, 4);

insert into pharmacy (description, address_id) values ('Apoteka 1', 2);

insert into users (email, gender, identification_number, name, password, password_changed, phone, role, surname, verified, address_id)
    values ('user1@gmail.com', 0, '25029920098', 'Marko', 'markic', false, '065/322322', 3, 'Markovic', false, 1);

insert into users (email, gender, identification_number, name, password, password_changed, phone, role, surname, verified, address_id)
    values ('user2@gmail.com', 0, '22039920028', 'Petar', 'pera', false, '065/323232', 2, 'Petrovic', false, 3);

insert into users (email, gender, identification_number, name, password, password_changed, phone, role, surname, verified, address_id)
    values ('user3@gmail.com', 0, '22049910028', 'Isak', 'ajzak', false, '065/323212', 1, 'Isakovic', false, 4);

insert into employee (id) values (1);
insert into employee (id) values (2);

insert into dermatologist (id, grade) values (1, 5.5);

insert into pharmacist (id, pharmacy_id, grade) values (2, 1, 8.2);

insert into pharmacy_administrator (id, pharmacy_id) values (3, 1);

insert into pharmacys_dermatolostist (pharmacy_id, dermatologist_id) values (1, 1);

insert into ingredient (name) values ('ibuprofen');

insert into drug (code, composition, contraindications, daily_dose, drug_class, form, loyalty_points, manufacturer, name, note, prescription_type, type)
    values ('M01AE01', 'Sastav 1', 'Brufen is contraindicated in patients with hypersensitivity to the active substance or to any of the excipients.', 'Two times a day', 3, 7, 4, 'Hemofarm', 'Brufen', 'Note 1', 1, 3);

insert into drug (code, composition, contraindications, daily_dose, drug_class, form, loyalty_points, manufacturer, name, note, prescription_type, type)
    values ('M01AE02', 'Sastav 2', 'Aspirin is contraindicated in patients with hypersensitivity to the active substance or to any of the excipients.', 'Two times a day', 3, 7, 4, 'Hemofarm', 'Aspirin', 'Note 2', 1, 3);


insert into drug_ingredient (drug_id, ingredient_id) values (1, 1);
insert into drug_ingredient(drug_id, ingredient_id) values (2, 1);

insert into item (quantity, drug_id) values (100, 1);

insert into warehouse (pharmacy_id) values (1);

insert into warehouse_items (warehouse_id, items_id) values (1, 1);

insert into pricelist (pharmacy_id) values (1);

insert into promotion (description, promotion_start, promotion_end, pharmacy_id)
    values ('20% popusta na brufen do kraja meseca1', '2021-08-17T00:00:00', '2021-09-17T00:00:00', 1);
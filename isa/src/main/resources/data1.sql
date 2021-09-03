insert into country (name) values ('Srbija');

insert into city (name, zip_code, country_id) values ('Novi Sad', '21000', 1);


insert into address (number, street, city_id, latitude, longitude) values ('8', 'Maksima Gorkog', 1, 45.267136, 19.833549);
insert into address (number, street, city_id, latitude, longitude) values ('9', 'Maksima Gorkog', 1, 45.24915928867009, 19.84284031690104);
insert into address (number, street, city_id, latitude, longitude) values ('10', 'Maksima Gorkog', 1, 45.24993937456046, 19.84684437097689);
insert into address (number, street, city_id, latitude, longitude) values ('11', 'Maksima Gorkog', 1, 45.250312839697166, 19.84671996728179);
insert into address (number, street, city_id, latitude, longitude) values ('12', 'Maksima Gorkog', 1, 45.816407202210186, 19.640509353806817);
insert into address (number, street, city_id, latitude, longitude) values ('13', 'Maksima Gorkog', 1, 45.25038975236708, 19.84697265563544);

insert into pharmacy (name, description, address_id) values ('Apoteka 1', 'Apoteka 1', 2);

insert into users (email, gender, identification_number, name, password, password_changed, phone, role, surname, verified, address_id, first_time_logged_in)
    values ('bojanvjc1@gmail.com', 0, '25029920098', 'Marko', 'markic', false, '065/322322', 3, 'Markovic', false, 1, false);

insert into users (email, gender, identification_number, name, password, password_changed, phone, role, surname, verified, address_id, first_time_logged_in)
    values ('user2@gmail.com', 0, '22039920028', 'Petar', 'pera', false, '065/323232', 2, 'Petrovic', false, 3, false);

insert into users (email, gender, identification_number, name, password, password_changed, phone, role, surname, verified, address_id, first_time_logged_in)
    values ('user3@gmail.com', 0, '22049910028', 'Isak', '$2a$10$yiJVwyT4eF/UboEM9oPpYOyIou86mFPnVvYC8YtgFGcy76BV9wJQy', false, '065/323212', 1, 'Isakovic', false, 4, false);

insert into users (email, gender, identification_number, name, password, password_changed, phone, role, surname, verified, address_id, first_time_logged_in)
    values ('bojanvjc@gmail.com', 0, '12029960028', 'Jovan', 'joca', false, '065/313222', 5, 'Jovanovic', false, 5, false);

insert into users (email, gender, identification_number, name, password, password_changed, phone, role, surname, verified, address_id, first_time_logged_in)
    values ('bojanvjc1@gmail.com', 0, '12129960328', 'Igor', '$2a$10$VV9ooBhZ4qRowDIOEmjUxuTJdK5rBoWed59p.L92Awp/Bwgbcd54O', false, '065/313222', 4, 'Jovanovic', false, 6, false);

insert into employee (id) values (1);
insert into employee (id) values (2);

insert into dermatologist (id, grade) values (1, 5.5);

insert into pharmacist (id, pharmacy_id, grade) values (2, 1, 8.2);

insert into pharmacy_administrator (id, pharmacy_id) values (3, 1);

--insert into dermatologist_pharmacies (pharmacy_id, dermatologist_id) values (1, 1);

insert into patient (penalties, id) values (0, 4);

insert into supplier (id) values (5);

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

insert into subscription (pharmacy_id) values (1);

insert into subscription_patient (subscription_id, patient_id) values (1, 4);

insert into dermatologist_vacation_request (admin_response, vacation_start, vacation_end, status, dermatologist_id, pharmacy_id) values (null, '2021-08-20T00:00:00', '2021-09-10T00:00:00', 1, 1, 1);
insert into authority (id, name) values (1, 'ROLE_PHARMACY_ADMIN');

insert into user_authority (user_id, authority_id) values (3, 1);

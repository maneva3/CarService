DROP TABLE IF EXISTS car_brand;
DROP TABLE IF EXISTS job_state;
DROP TABLE IF EXISTS job_type;
DROP TABLE IF EXISTS car_center;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS service_job;

CREATE TABLE car_brand
(
    name VARCHAR(20) PRIMARY KEY
);

CREATE TABLE job_state
(
    name VARCHAR(20) PRIMARY KEY
);

CREATE TABLE job_type
(
    name VARCHAR(30) PRIMARY KEY
);

CREATE TABLE car_center
(
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            VARCHAR(20) NOT NULL,
    work_with_brand VARCHAR(20),
    FOREIGN KEY (work_with_brand) REFERENCES car_brand (name)-- other CarCenter-specific columns
);

CREATE TABLE user
(
    email        VARCHAR(30) PRIMARY KEY,
    first_name   VARCHAR(15)  NOT NULL,
    last_name    VARCHAR(15)  NOT NULL,
    phone_number VARCHAR(13)  NOT NULL,
    password     VARCHAR(255) NOT NULL
);

CREATE TABLE customer
(
    email VARCHAR(30) PRIMARY KEY REFERENCES user (email)
);

CREATE TABLE employee
(
    email      VARCHAR(30) PRIMARY KEY REFERENCES user (email),
    working_at INTEGER NOT NULL,
    FOREIGN KEY (working_at) REFERENCES car_center (id)
);

CREATE TABLE car
(
    vin           VARCHAR(17) PRIMARY KEY,
    license_plate VARCHAR(8)  NOT NULL,
    brand         VARCHAR(20) NOT NULL,
    model         VARCHAR(15) NOT NULL,
    year          DATE        NOT NULL,
    owner_email   VARCHAR(30) NOT NULL,
    FOREIGN KEY (brand) REFERENCES car_brand (name),
    FOREIGN KEY (owner_email) REFERENCES customer (email)
);

CREATE TABLE appointment
(
    id                  INTEGER PRIMARY KEY AUTOINCREMENT,
    customer_email      VARCHAR(30) NOT NULL,
    car_center_id       INTEGER     NOT NULL,
    car_license_plate   VARCHAR(8)  NOT NULL,
    date_created        DATE        NOT NULL,
    date_of_appointment DATE        NOT NULL,
    has_passed          BOOLEAN     NOT NULL,
    FOREIGN KEY (customer_email) REFERENCES customer (email),
    FOREIGN KEY (car_center_id) REFERENCES car_center (id),
    FOREIGN KEY (car_license_plate) REFERENCES car (license_plate)
);

CREATE TABLE service_job
(
    id             INTEGER PRIMARY KEY AUTOINCREMENT,
    employee_email VARCHAR(30) NOT NULL,
    type           VARCHAR     NOT NULL,
    date_started   DATE,
    date_finished  DATE,
    price          DECIMAL(10, 2) CHECK (price >= 0),
    state          VARCHAR     NOT NULL,
    appointment_id INTEGER,
    FOREIGN KEY (employee_email) REFERENCES employee (email),
    FOREIGN KEY (type) REFERENCES job_type (name),
    FOREIGN KEY (state) REFERENCES job_state (name),
    FOREIGN KEY (appointment_id) REFERENCES appointment (id)
);

INSERT INTO car_brand (name)
VALUES ('Audi'),
       ('BMW'),
       ('Chevrolet'),
       ('Ford'),
       ('Honda'),
       ('Hyundai'),
       ('Mercedes-Benz'),
       ('Nissan'),
       ('Toyota'),
       ('Volkswagen');

INSERT INTO job_state (name)
VALUES ('Completed'),
       ('In Progress'),
       ('Pending');

INSERT INTO job_type (name)
VALUES ('Brake Repair'),
       ('Diagnostics'),
       ('Engine Diagnostics'),
       ('Filter Change'),
       ('Oil Change'),
       ('Paint and Body Work'),
       ('Transmission Service'),
       ('Tune-up'),
       ('Wheel Alignment'),
       ('Windshield Replacement');

INSERT INTO car_center (name, work_with_brand)
VALUES ('Autospace', 'Honda'),
       ('Car Fixers', NULL),
       ('Wheels Doc', NULL);

INSERT INTO user (email, first_name, last_name, phone_number, password)
VALUES ('ivan.ivanov@gmail.com', 'Ivan', 'Ivanov', '+359123456789',
        '$2a$10$hrk6viZxBViCG9YMVQmnb.OIn2W.Rm4EBA9XDD268L1Fjfs0nJJXu'),
       ('m.petkova@mail.bg', 'Mariya', 'Petkova', '+359987654321',
        '$2a$10$15kPfILvlBl9rMNYyiOidOoL0/rYia.BBxcKyaMSXUSp09E/NuVya'),
       ('g_georgiev@abv.bg', 'Georgi', 'Georgiev', '+359876543210',
        '$2a$10$Hng3B1TjiyA8t7.L4/ASU.Y4bGCmwMWax/peoeT2huQUK8AGbP3Fq'),
       ('stoyanova.elena@gmail.com', 'Elena', 'Stoyanova', '+359558325555',
        '$2a$10$4WeFZDHCmvsRjTZS2xDXZOaP.G8rugc6I.eqNrQuyem10gim1re4q'),
       ('petar.h.dimitrov@mail.bg', 'Petar', 'Dimitrov', '+359123123123',
        '$2a$10$8HllG1QttBfIgZWvkFZ8H.EuX.033nV1DndyWaaLs0q960iOCtd7q'),
       ('ivan-nikolov@gmail.com', 'Ivan', 'Nikolov', '+359888811111',
        '$2a$10$6wf26z7WaeBKsZhu09wMCewZHrO7AUP1E/urgCljtL7KE0DazEt.q'),
       ('georgiev.g@gmail.com', 'Grigor', 'Georgiev', '+359888822222',
        '$2a$10$lrc4LtYTNrUzJiWSXi85k.3MMB6VCLzKbUPGem2s9vWbjc0X6K4gG'),
       ('p.dimitrov@gmail.com', 'Pavel', 'Dimitrov', '+359888833333',
        '$2a$10$8Ipdd8S.feF/AdPMUYtjpe1hS.QHZAz8woph5YsvxfAc/XbEQF6yO'),
       ('stefanov92@mail.bg', 'Stefan', 'Stefanov', '+359888844444',
        '$2a$10$cmzP8PFqudDJImyWF68GeeY1F6wOYxskbPyLV4aoxhCAXV6lvgUj.'),
       ('nikolan@mail.bg', 'Nikola', 'Nikolov', '+359888855555',
        '$2a$10$Vj/rw2ua4gp2xWF8ev9rPuzd7g9LE99Ol.y8.uEtgQB4gw/veVGlW'),
       ('alexander.hr@abv.bg', 'Alexander', 'Petkov', '+359888866666',
        '$2a$10$103FLNjm/BrceCTDxZ56WeQtcCylKLyjGG9Zg/cAFXeLXoy1CDzY.'),
       ('petkov@gmail.com', 'Ivan', 'Petkov', '+359888877777',
        '$2a$10$l2grgVl93wI/wWqm7XGEVevSteGRUB/tIh1vyVeGza6aldwV/3F3O');

INSERT INTO customer (email)
VALUES ('ivan.ivanov@gmail.com'),
       ('m.petkova@mail.bg'),
       ('g_georgiev@abv.bg'),
       ('stoyanova.elena@gmail.com'),
       ('petar.h.dimitrov@mail.bg');

INSERT INTO employee (email, working_at)
VALUES ('ivan-nikolov@gmail.com', '1'),
       ('georgiev.g@gmail.com', '2'),
       ('p.dimitrov@gmail.com', '3'),
       ('stefanov92@mail.bg', '3'),
       ('nikolan@mail.bg', '1'),
       ('alexander.hr@abv.bg', '2'),
       ('petkov@gmail.com', '2');

INSERT INTO car (vin, license_plate, brand, model, year, owner_email)
VALUES ('123A456B789C01234', 'СА1234АВ', 'Audi', 'A4', '2022', 'ivan.ivanov@gmail.com'),
       ('456D789E012F34567', 'PB2345EH', 'BMW', 'X5', '2020', 'stoyanova.elena@gmail.com'),
       ('789G012H345I67890', 'CO3453EE', 'Chevrolet', 'Cruze', '2021', 'petar.h.dimitrov@mail.bg'),
       ('012J345K678L90123', 'CT4560GH', 'Ford', 'Focus', '2019', 'g_georgiev@abv.bg'),
       ('345M678N901O23456', 'EB5679HD', 'Honda', 'Civic', '2020', 'm.petkova@mail.bg'),
       ('678P901Q234R56789', 'CB6278KK', 'Hyundai', 'Elantra', '2022', 'ivan.ivanov@gmail.com');

INSERT INTO appointment (customer_email, car_center_id, car_license_plate, date_created, date_of_appointment,
                         has_passed)
VALUES ('ivan.ivanov@gmail.com', 2, 'СА1234АВ', '2022-01-15', '2022-02-01', 1),
       ('m.petkova@mail.bg', 1, 'EB5679HD', '2024-02-10', '2024-03-05', 0),
       ('g_georgiev@abv.bg', 3, 'CT4560GH', '2023-03-20', '2023-04-15', 1),
       ('stoyanova.elena@gmail.com', 2, 'PB2345EH', '2024-03-05', '2024-03-21', 0),
       ('petar.h.dimitrov@mail.bg', 3, 'CO3453EE', '2024-02-15', '2024-06-10', 0),
       ('ivan.ivanov@gmail.com', 2, 'CB6278KK', '2024-02-20', '2024-03-25', 0),
       ('m.petkova@mail.bg', 1, 'EB5679HD', '2023-07-10', '2023-08-05', 1);

INSERT INTO service_job (employee_email, type, date_started, date_finished, price, state, appointment_id)
VALUES ('ivan-nikolov@gmail.com', 'Brake Repair', '2022-02-01', '2022-02-02', 120.50, 'Completed', 1),
       ('georgiev.g@gmail.com', 'Oil Change', '2024-03-05', '2024-03-06', 80.00, 'In Progress', 2),
       ('p.dimitrov@gmail.com', 'Diagnostics', '2023-04-15', '2023-04-16', 150.25, 'Completed', 3),
       ('stefanov92@mail.bg', 'Wheel Alignment', '2024-02-21', '2024-03-22', 90.75, 'In Progress', 4),
       ('nikolan@mail.bg', 'Engine Diagnostics', '2024-04-10', NULL, NULL, 'Pending', 5),
       ('alexander.hr@abv.bg', 'Paint and Body Work', '2024-03-25', NULL, NULL, 'Pending', 6),
       ('petkov@gmail.com', 'Filter Change', '2023-08-05', '2023-08-06', 65.80, 'Completed', 7);
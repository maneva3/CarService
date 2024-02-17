CREATE TABLE car_brand
(
    name VARCHAR(20) PRIMARY KEY
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

CREATE TABLE job_state
(
    name VARCHAR(20) PRIMARY KEY
);

INSERT INTO job_state (name)
VALUES ('Completed'),
       ('In Progress'),
       ('Pending');

CREATE TABLE job_type
(
    name VARCHAR(30) PRIMARY KEY
);

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

CREATE TABLE car_center
(
    id                 SERIAL PRIMARY KEY,
    name               VARCHAR(20) NOT NULL,
    working_with_brand VARCHAR(20),
    FOREIGN KEY (working_with_brand) REFERENCES car_brand (name)-- other CarCenter-specific columns
);

CREATE TABLE customer
(
    email        VARCHAR(30) PRIMARY KEY,
    first_name   VARCHAR(15) NOT NULL,
    last_name    VARCHAR(15) NOT NULL,
    phone_number VARCHAR(15) NOT NULL
);

CREATE TABLE employee
(
    email        VARCHAR(30) PRIMARY KEY,
    first_name   VARCHAR(15) NOT NULL,
    last_name    VARCHAR(15) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    working_at   INTEGER     NOT NULL,
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
    id                  SERIAL PRIMARY KEY,
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

DROP TABLE IF EXISTS customer;
-- DROP TABLE IF EXISTS service_job;
-- DROP TABLE IF EXISTS appointment;

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
    id                 INTEGER PRIMARY KEY AUTOINCREMENT,
    name               VARCHAR(20) NOT NULL,
    working_with_brand VARCHAR(20),
    FOREIGN KEY (working_with_brand) REFERENCES car_brand (name)-- other CarCenter-specific columns
);

CREATE TABLE customer
(
    email        VARCHAR(30) PRIMARY KEY,
    first_name   VARCHAR(15) NOT NULL,
    last_name    VARCHAR(15) NOT NULL,
    phone_number VARCHAR(13) NOT NULL
);

CREATE TABLE employee
(
    email        VARCHAR(30) PRIMARY KEY,
    first_name   VARCHAR(15) NOT NULL,
    last_name    VARCHAR(15) NOT NULL,
    phone_number VARCHAR(13) NOT NULL,
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

INSERT INTO car_center (name, working_with_brand)
VALUES ('Autospace', 'Honda'),
       ('Car Fixers', NULL),
       ('Wheels Doc', NULL);


CREATE DATABASE oficinaMecanica;
USE oficinaMecanica;

CREATE TABLE users(
    id_user INT PRIMARY KEY AUTO_INCREMENT,
    name_user VARCHAR(100) NOT NULL,
    password_user VARCHAR(100) NOT NULL
);

CREATE TABLE vehicles(
    id_vehicle INT PRIMARY KEY AUTO_INCREMENT,

    name_driver VARCHAR(150) NOT NULL,
    cpf_driver VARCHAR(20) NOT NULL UNIQUE,
    phone_driver VARCHAR(20) NOT NULL,

    type_vehicle VARCHAR(50) NOT NULL,
    model_vehicle VARCHAR(100) NOT NULL,
    plate_vehicle VARCHAR(20) NOT NULL UNIQUE,
    color_vehicle VARCHAR(50) NOT NULL,
    year_vehicle INT NOT NULL,

    date_arrival_vehicle DATE NOT NULL,
    reason_vehicle TEXT NOT NULL,
    diagnosis_vehicle TEXT NOT NULL,

    status_register ENUM(
        'PENDENTE',
        'EM ANDAMENTO',
        'PRONTO',
        'DESATIVADO'
    ) NOT NULL DEFAULT 'PENDENTE',

    active_register BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO users(name_user, password_user)
VALUES("admin","123");

SELECT * FROM users;
SELECT * FROM vehicles;
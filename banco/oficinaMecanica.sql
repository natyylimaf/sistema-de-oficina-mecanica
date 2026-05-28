CREATE DATABASE oficinaMecanica;
USE oficinaMecanica;

CREATE TABLE users(
	id_user INT PRIMARY KEY	 AUTO_INCREMENT,
    name_user VARCHAR(100) NOT NULL,
    password_user VARCHAR(100) NOT NULL
);

CREATE TABLE vehicles(
		id_vehicle INT PRIMARY KEY AUTO_INCREMENT ,
        
        name_driver VARCHAR(150) NOT NULL,
        cpf_driver VARCHAR(20) NOT NULL UNIQUE,
        phone_driver VARCHAR(20) NOT NULL,
        
        model_vehicle VARCHAR(100) NOT NULL,
        plate_vehicle VARCHAR(20) NOT NULL UNIQUE,
        color_vehicle VARCHAR(50) NOT NULL,
        year_vehicle INT NOT NULL,
        date_arrival_vehicle DATE NOT NULL,
        reason_vehicle TEXT NOT NULL,
        diagnosis_vehicle TEXT NOT NULL,
        
        status_register VARCHAR(50) NOT NULL DEFAULT "PENDENTE",
        active_register BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO users(name_user, password_user)
VALUES("admin", "123");

INSERT INTO vehicles(name_driver, cpf_driver, phone_driver, model_vehicle, plate_vehicle, color_vehicle,
 year_vehicle, date_arrival_vehicle, reason_vehicle, diagnosis_vehicle, status_register, active_register)
 VALUES(
		"Carlos Henrique", "123.456.789-00", "(27) 99999-1111", "Honda Civic","ABC1D23","Preto",2020,"2026-05-26","Barulho no motor","Necessário trocar correia","PENDENTE",TRUE),
        ("Mariana Souza","987.654.321-00","(27) 98888-2222","Chevrolet Onix","BRA2E45","Branco",2022,"2026-05-25","Freio falhando","Pastilhas desgastadas","EM ANDAMENTO",TRUE),
		("Fernanda Lima","741.852.963-11","(27) 97777-3333","Toyota Corolla","XYZ9K87","Prata",2019,"2026-05-20","Troca de óleo","Serviço realizado com sucesso","PRONTO",TRUE
);

SELECT * FROM users;
SELECT * FROM vehicles;
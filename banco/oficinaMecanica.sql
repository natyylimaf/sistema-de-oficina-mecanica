CREATE DATABASE oficinaMecanica;
USE oficinaMecanica;

-- ==========================
-- TABELA DE USUÁRIOS
-- ==========================
CREATE TABLE usuarios(
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nome_usuario VARCHAR(100) NOT NULL,
    senha_usuario VARCHAR(100) NOT NULL
);

-- ==========================
-- TABELA DE VEÍCULOS
-- ==========================
CREATE TABLE veiculos(
    id_veiculo INT PRIMARY KEY AUTO_INCREMENT,

    nome_motorista VARCHAR(150) NOT NULL,
    cpf_motorista VARCHAR(20) NOT NULL,
    telefone_motorista VARCHAR(20) NOT NULL,

    modelo VARCHAR(100) NOT NULL,
    placa VARCHAR(20) NOT NULL UNIQUE,
    cor VARCHAR(50) NOT NULL,
    ano INT NOT NULL,

    data_chegada DATE NOT NULL,

    motivo TEXT,
    diagnostico TEXT NOT NULL,

    tipo_veiculo VARCHAR(20) NOT NULL,

    status_cadastro VARCHAR(50) NOT NULL DEFAULT 'PENDENTE',

    registro_ativo BOOLEAN NOT NULL DEFAULT TRUE
);

-- ==========================
-- TABELA DE CARROS
-- ==========================
CREATE TABLE carros(
    id_carro INT PRIMARY KEY AUTO_INCREMENT,
    id_veiculo INT NOT NULL,

    quantidade_portas INT NOT NULL,

    FOREIGN KEY (id_veiculo)
    REFERENCES veiculos(id_veiculo)
);

-- ==========================
-- TABELA DE MOTOS
-- ==========================
CREATE TABLE motos(
    id_moto INT PRIMARY KEY AUTO_INCREMENT,
    id_veiculo INT NOT NULL,

    cilindradas INT NOT NULL,

    FOREIGN KEY (id_veiculo)
    REFERENCES veiculos(id_veiculo)
);

-- ==========================
-- TABELA DE ORÇAMENTOS
-- ==========================
CREATE TABLE orcamentoVeiculo(
    id_orcamento INT PRIMARY KEY AUTO_INCREMENT,

    mao_obra DECIMAL(10,2) DEFAULT 0.00,
    valor_pecas DECIMAL(10,2) DEFAULT 0.00,
    valor_total DECIMAL(10,2) DEFAULT 0.00,

    id_veiculo INT NOT NULL,

    FOREIGN KEY(id_veiculo)
    REFERENCES veiculos(id_veiculo)
);



-- ==========================
-- USUÁRIO PADRÃO
-- ==========================
INSERT INTO usuarios(nome_usuario, senha_usuario)
VALUES ('admin', '123');

-- ==========================
-- VEÍCULO 1 - CARRO
-- ==========================
INSERT INTO veiculos(
    nome_motorista,
    cpf_motorista,
    telefone_motorista,
    modelo,
    placa,
    cor,
    ano,
    data_chegada,
    motivo,
    diagnostico,
    tipo_veiculo
)
VALUES(
    'Carlos Henrique',
    '123.456.789-00',
    '(27) 99999-1111',
    'Honda Civic',
    'ABC1D23',
    'Preto',
    2020,
    '2026-05-26',
    'Barulho no motor',
    'Necessário trocar correia',
    'CARRO'
);

INSERT INTO carros(id_veiculo, quantidade_portas)
VALUES (1, 4);

-- ==========================
-- VEÍCULO 2 - MOTO
-- ==========================
INSERT INTO veiculos(
    nome_motorista,
    cpf_motorista,
    telefone_motorista,
    modelo,
    placa,
    cor,
    ano,
    data_chegada,
    motivo,
    diagnostico,
    tipo_veiculo
)
VALUES(
    'Mariana Souza',
    '987.654.321-00',
    '(27) 98888-2222',
    'Honda CG 160',
    'BRA2E45',
    'Vermelha',
    2022,
    '2026-05-25',
    'Falha na partida',
    'Problema na bateria',
    'MOTO'
);

INSERT INTO motos(id_veiculo, cilindradas)
VALUES (2, 160);

-- ==========================
-- VEÍCULO 3 - CARRO
-- ==========================
INSERT INTO veiculos(
    nome_motorista,
    cpf_motorista,
    telefone_motorista,
    modelo,
    placa,
    cor,
    ano,
    data_chegada,
    motivo,
    diagnostico,
    tipo_veiculo
)
VALUES(
    'Fernanda Lima',
    '741.852.963-11',
    '(27) 97777-3333',
    'Toyota Corolla',
    'XYZ9K87',
    'Prata',
    2019,
    '2026-05-20',
    'Troca de óleo',
    'Serviço realizado com sucesso',
    'CARRO'
);

INSERT INTO carros(id_veiculo, quantidade_portas)
VALUES (3, 4);

-- ==========================
-- VEÍCULO 4 - MOTO
-- ==========================
INSERT INTO veiculos(
    nome_motorista,
    cpf_motorista,
    telefone_motorista,
    modelo,
    placa,
    cor,
    ano,
    data_chegada,
    motivo,
    diagnostico,
    tipo_veiculo
)
VALUES(
    'João Pedro',
    '321.654.987-22',
    '(27) 99666-4444',
    'Yamaha Fazer 250',
    'MOT4A21',
    'Azul',
    2021,
    '2026-05-18',
    'Barulho na corrente',
    'Necessário ajuste e lubrificação',
    'MOTO'
);

INSERT INTO motos(id_veiculo, cilindradas)
VALUES (4, 250);


-- ==========================
-- VEÍCULO 5 - CARRO
-- ==========================
INSERT INTO veiculos(
    nome_motorista,
    cpf_motorista,
    telefone_motorista,
    modelo,
    placa,
    cor,
    ano,
    data_chegada,
    motivo,
    diagnostico,
    tipo_veiculo
)
VALUES(
    'Lucas Martins',
    '852.741.963-33',
    '(27) 99555-7777',
    'Volkswagen Gol',
    'GOL5B12',
    'Branco',
    2018,
    '2026-05-17',
    'Problema no freio',
    'Troca das pastilhas necessária',
    'CARRO'
);

INSERT INTO carros(id_veiculo, quantidade_portas)
VALUES (5, 4);


-- ==========================
-- VEÍCULO 6 - MOTO
-- ==========================
INSERT INTO veiculos(
    nome_motorista,
    cpf_motorista,
    telefone_motorista,
    modelo,
    placa,
    cor,
    ano,
    data_chegada,
    motivo,
    diagnostico,
    tipo_veiculo
)
VALUES(
    'Amanda Costa',
    '963.258.741-44',
    '(27) 99444-8888',
    'Honda Biz 125',
    'BIZ6C34',
    'Vermelha',
    2023,
    '2026-05-15',
    'Revisão preventiva',
    'Veículo em boas condições',
    'MOTO'
);

INSERT INTO motos(id_veiculo, cilindradas)
VALUES (6, 125);

-- ==========================
-- VEÍCULO 7 - CARRO
-- ==========================
INSERT INTO veiculos(
    nome_motorista,
    cpf_motorista,
    telefone_motorista,
    modelo,
    placa,
    cor,
    ano,
    data_chegada,
    motivo,
    diagnostico,
    tipo_veiculo
)
VALUES(
    'Gabriel Souza',
    '159.357.258-55',
    '(27) 99333-9999',
    'Chevrolet Onix',
    'ONX7D89',
    'Cinza',
    2024,
    '2026-05-14',
    'Luz da injeção acesa',
    'Necessário scanner para diagnóstico',
    'CARRO'
);

INSERT INTO carros(id_veiculo, quantidade_portas)
VALUES (7, 4);
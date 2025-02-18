CREATE TABLE IF NOT EXISTS bank_account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    balance DECIMAL(10,2),
    titular VARCHAR(100) NOT NULL,
    document VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    renda_mensal DECIMAL(10,2) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    tipo_conta VARCHAR(50) NOT NULL
);
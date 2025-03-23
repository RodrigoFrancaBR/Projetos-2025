-- -----------------------------------------------------
-- Schema bank_account_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS bank_account_db;
CREATE SCHEMA bank_account_db;
SET SCHEMA bank_account_db;

-- -----------------------------------------------------
-- Table bank_account_db.tb_agency
-- -----------------------------------------------------
DROP TABLE IF EXISTS tb_agency;
CREATE TABLE tb_agency (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  email VARCHAR(100) NOT NULL,
  telephone VARCHAR(11) NOT NULL,
  adress VARCHAR(100) NOT NULL,
  UNIQUE (name),
  UNIQUE (cnpj),
  UNIQUE (adress)
);

-- -----------------------------------------------------
-- Table bank_account_db.tb_account_holder
-- -----------------------------------------------------
DROP TABLE IF EXISTS tb_account_holder;
CREATE TABLE tb_account_holder (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  cpf_cnpj VARCHAR(14) NOT NULL,
  email VARCHAR(100) NOT NULL,
  telephone VARCHAR(11) NOT NULL,
  address VARCHAR(45) NOT NULL,
  agency_id INT NOT NULL,
  UNIQUE (name),
  UNIQUE (cpf_cnpj),
  CONSTRAINT fk_tb_account_holder_tb_agency
    FOREIGN KEY (agency_id)
    REFERENCES tb_agency (id)
);

-- -----------------------------------------------------
-- Table bank_account_db.tb_bank_account
-- -----------------------------------------------------
DROP TABLE IF EXISTS tb_bank_account;
CREATE TABLE tb_bank_account (
  id INT PRIMARY KEY AUTO_INCREMENT,
  account_number VARCHAR(20) NOT NULL,
  account_type VARCHAR(10) CHECK (account_type IN ('CURRENT', 'SAVINGS', 'SALARY')),
  balance DECIMAL(10,2) NOT NULL,
  daily_withdrawal_limit DECIMAL(10,2) NOT NULL,
  account_holder_id INT NOT NULL,
  UNIQUE (account_number),
  CONSTRAINT fk_tb_bank_account_tb_account_holder
    FOREIGN KEY (account_holder_id)
    REFERENCES tb_account_holder (id)
);

-- -----------------------------------------------------
-- Table bank_account_db.tb_transaction
-- -----------------------------------------------------
DROP TABLE IF EXISTS tb_transaction;
CREATE TABLE tb_transaction (
  id INT PRIMARY KEY AUTO_INCREMENT,
  transaction_type VARCHAR(10) CHECK (transaction_type IN ('WITHDRAWAL', 'DEPOSIT', 'TRANSFER')),
  amount DECIMAL(10,2) NOT NULL,
  transaction_date TIMESTAMP NOT NULL,
  origin_account_id INT NOT NULL,
  target_account_id INT NOT NULL
);

-- -----------------------------------------------------
-- Table bank_account_db.tb_bank_account_has_tb_transaction
-- -----------------------------------------------------
DROP TABLE IF EXISTS tb_bank_account_has_tb_transaction;
CREATE TABLE tb_bank_account_has_tb_transaction (
  bank_account_id INT NOT NULL,
  transaction_id INT NOT NULL,
  PRIMARY KEY (bank_account_id, transaction_id),
  CONSTRAINT fk_tb_bank_account_has_tb_transaction_tb_bank_account
    FOREIGN KEY (bank_account_id)
    REFERENCES tb_bank_account (id),
  CONSTRAINT fk_tb_bank_account_has_tb_transaction_tb_transaction
    FOREIGN KEY (transaction_id)
    REFERENCES tb_transaction (id)
);
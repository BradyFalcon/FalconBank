CREATE TABLE accounts (
  number VARCHAR(100) NOT NULL,
  balance DOUBLE NULL,
  CONSTRAINT pk_accounts PRIMARY KEY (number)
);

CREATE TABLE transactions (
  id INT AUTO_INCREMENT NOT NULL,
  amount DOUBLE NULL,
  type VARCHAR(10) NULL,
  date datetime NULL,
  CONSTRAINT pk_transactions PRIMARY KEY (id)
);

CREATE TABLE users (
  id INT NOT NULL,
  first_name VARCHAR(50) NULL,
  last_name VARCHAR(50) NULL,
  email VARCHAR(50) NULL,
  password VARCHAR(50) NULL,
  CONSTRAINT pk_users PRIMARY KEY (id)
);

INSERT INTO `falconbankdb`.`transactions` (`amount`, `date`, `type`, `account_number`) VALUES ('100', '2021-12-02', 'CREDIT', '1');
CREATE TABLE USUARIO(
	ID INTEGER NOT NULL PRIMARY KEY IDENTITY,
	NOME VARCHAR(50) NOT NULL,
	NOME_USUARIO VARCHAR(25) NOT NULL,
	SENHA VARCHAR(32) NOT NULL
);

CREATE TABLE BEBIDA(
	ID INTEGER NOT NULL PRIMARY KEY IDENTITY,
	MARCA VARCHAR(50) NOT NULL,
	SABOR VARCHAR(50) NOT NULL,
	VOLUME VARCHAR(50) NOT NULL,
	PRECO DOUBLE NOT NULL
);

CREATE TABLE PIZZA(
	ID INTEGER NOT NULL PRIMARY KEY IDENTITY,
	NOME VARCHAR(50) NOT NULL,
	INGREDIENTES VARCHAR(500) NOT NULL,
	PRECO_P DOUBLE NOT NULL,
	PRECO_M DOUBLE NOT NULL,
	PRECO_G DOUBLE NOT NULL,
	PRECO_GG DOUBLE NOT NULL
);

CREATE TABLE CLIENTE(
	ID INTEGER NOT NULL PRIMARY KEY IDENTITY,
	NOME VARCHAR(50) NOT NULL,
	CPF VARCHAR(15) NOT NULL,
	RG VARCHAR(10) NOT NULL,
	DATA_NASCIMENTO DATE NOT NULL,
	SEXO CHAR NOT NULL,
	TELEFONE VARCHAR(13) NOT NULL,
	ENDERECO VARCHAR(300) NOT NULL,
        VALOR_DEVIDO DOUBLE,
        DIVIDE_EM INT,
);

CREATE TABLE ITENS_PEDIDO(
	ID INT IDENTITY  NOT NULL,
        QUANTIDADE INT NOT NULL,
        ID_PIZZA INT,
        ID_BEBIDA INT,
	ID_PEDIDO INTEGER NOT NULL,
	FOREIGN KEY(ID_PIZZA) REFERENCES PIZZA(ID),
        FOREIGN KEY(ID_BEBIDA) REFERENCES BEBIDA(ID)
);

CREATE TABLE PEDIDO(
	ID INTEGER IDENTITY NOT NULL,
	VALOR_TOTAL DOUBLE,
        DATA DATE,
	ID_CLIENTE INTEGER DEFAULT 0,
        STATUS STATUS BOOLEAN DEFAULT TRUE,
        FOREIGN KEY(ID_CLIENTE) REFERENCES CLIENTE(ID)
);
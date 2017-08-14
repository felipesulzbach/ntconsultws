
-------------------------------------------------------------------------
--------- Informacoes para criacao do Banco de Dados PostgreSQL ---------
-------------------------------------------------------------------------

/*
  bd: ntconsultwsdb
  port: 5432
  user: postgre
  password: admin
*/

------------------------------------------------------------------------





-------------------------------------------------------------------------
---------------------------- Querys Uteis -------------------------------
-------------------------------------------------------------------------

-- Retorna data em double.
SELECT date_part('day', TIMESTAMP '2001-02-16 20:38:40');

-- Busca data hora atual do sistema.
SELECT now();

-- Busca data atual do sistema.
SELECT CURRENT_DATE;

-- Retorana data hora em timestamp.
SELECT TIMESTAMP '2001-02-16 20:38:40';

------------------------------------------------------------------------





-------------------------------------------------------------------------
---------------------------- Querys Uteis -------------------------------
-------------------------------------------------------------------------

-- Cria tabela CLIENTE.
CREATE TABLE CLIENTE (
    ID            INTEGER PRIMARY KEY NOT NULL,
    DES_NOME      VARCHAR(40) NOT NULL,
    NUM_CPF_CNPJ  VARCHAR(16) NOT NULL,
    DT_NASCIMENTO TIMESTAMP,
	VLR_COMPRA    REAL,
	FLG_ATIVO     VARCHAR(1) DEFAULT '0'
);



-- Insere registros para teste.
INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (1, 'Cliente Um', '11111111111', TIMESTAMP '2012-01-05 13:15:10', 20.50, '1');

INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (2, 'Cliente Dois', '44444444444444', TIMESTAMP '2013-02-10 15:20:20', 35.32, '1');

INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (3, 'Cliente Tres', '22222222222', TIMESTAMP '2014-03-15 17:25:30', 50.75, '0');

INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (4, 'Cliente Quatro', '55555555555555', TIMESTAMP '2015-04-20 19:30:40', 90.38, '0');

INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (5, 'Cliente Cinco', '33333333333', TIMESTAMP '2016-05-25 21:35:50', 120.12, '1');

INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (6, 'Cliente Seis', '66666666666666', TIMESTAMP '2017-06-30 23:40:58', 200.87, '1');

COMMIT;



-- Query para editar valores manualmente.
SELECT *
  FROM CLIENTE c
 WHERE c.id = 1
FOR UPDATE;





--http://localhost:8080/ntconsultws-war/ClienteService?wsdl




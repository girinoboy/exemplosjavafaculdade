CREATE TABLE pessoa
(
nome varchar(80),
idade integer,
sexo varchar(20),
uf varchar(2),
email varchar(80) PRIMARY KEY,
quem_sou varchar(2000),
senha varchar(20)
)

CREATE TABLE outrasInformacoes
(
filho varchar(80),
alcool varchar(30),
cigarro varchar(20),
escolaridade varchar(50),
trabalho varchar(1000),
hobby varchar(1000),
email varchar(80) references PESSOA(email)
)
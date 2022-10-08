create table cliente (
id_cliente serial NOT NULL,
nome varchar(60),
cpf varchar(11),
email varchar(50),
data_nascimento date,
PRIMARY KEY (id_cliente));

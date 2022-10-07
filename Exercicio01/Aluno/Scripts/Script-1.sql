create table cliente (
id serial,
nome varchar(40) not null,
cpf varchar(11) not null,
email varchar (100),
data_nascimento date,
primary key (id));
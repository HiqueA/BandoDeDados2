

create table Colaborador(
id bigint(20) not null auto_increment,
cpf varchar(225) default null,
nome varchar(10) default null,
endereco varchar(255) default null,
email varchar(255) default null,
qantidadeDeFilhos int(11) not null,
primary key(id));

create table Departamento(
id bigint(20) not null auto_increment,
nome varchar(225) default null,
primary key(id));
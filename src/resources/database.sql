create database if not exists DataFarmaBanco;
use DataFarmaBanco;
create table if not exists fornecedores (
    id integer primary key auto_increment unique,
    nome varchar(50) unique not null,
    telefone varchar(50) unique not null,
    email varchar(50) unique not null,
    cnpj varchar(50) unique not null,
    endereco varchar (50),
    cep varchar(20)
);

create table if not exists teste (
    id integer primary key auto_increment unique,
    nome varchar(50) unique not null
);

create table if not exists medicamentos(
    id int unique primary key auto_increment,
    nome varchar(60) not null unique,
    tarja varchar(20) default('branca') not null,  -- Vermelha,vermelha_retenção,preta,amarela
    preco float not null,
    forncedor_nome varchar(20) not null,
    cod_barras int not null unique,
    dosagem int not null,
    tipo varchar(20) default('comprimidos') not null,
    qtd_produtos int not null not null,
    lote varchar(30) not null unique,
    data_inserida date not null,
    data_vencimento date not null,
    qtd_estoque int not null,
    forncedor_id int references fornecedores(id)
);

create table if not exists funcionarios(
	id 		    integer		       primary key auto_increment,
	nome 	    varchar(50)	       unique not null,
	data_nasc	date 	           unique not null,
	cpf 	    varchar(15)		   unique not null,
	cargo 	    varchar(30)		   not null,
	salario     int		   not null,
        senha varchar(30) not null
);

create table if not exists vendas  (
    funcionario_id int references funcionarios(id),
    medicamento_id int references medicamentos(id),
    qtd_vendidas int,
    data_venda date
);

insert into funcionarios values (null,'Robson','10/10/1990','93753409022','Farmacêutico',10000,'123mudar');
insert into funcionarios values (null,'Gabriel','11/11/1980','19158112014','Atendente',1000,'mudar123');
insert into funcionarios values (null,'Erick','1/12/1970','40326060057','Atendente',2000,'mudar123');
insert into funcionarios values (null,'Rafael','2/01/2000','62291449052','Atendente',3000,'mudar123');
insert into funcionarios values (null,'Leonidas','12/03/1999','43050231050','Atendente',1500,'mudar123');
insert into funcionarios values (null,'Thalles','21/05/1998','40326060057','Atendente',6000,'mudar123');
insert into funcionarios values (null,'Michel','22/02/1997','39976787073','Atendente',900,'mudar123');
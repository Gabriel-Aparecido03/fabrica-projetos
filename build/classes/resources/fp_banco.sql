create database if not exists DataFarma;
use DataFarma;

create table if not exists fornecedores (
    id integer primary key auto_increment unique,
    nome varchar(50) unique not null,
    telefone varchar(50) unique not null,
    email varchar(50) unique not null,
    cnpj varchar(50) unique not null,
    endereço varchar (50),
    prazo_entrega varchar(50) not null,
    cep varchar(20)
);

create table if not exists teste (
    id integer primary key auto_increment unique,
    nome varchar(50) unique not null,
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

create table funcionarios(
    id 		    integer		       primary key auto_increment,
    nome 	    varchar(50)	       unique not null,
    data_nasc	date 	           unique not null,
    cpf 	    varchar(15)		   unique not null,
    cargo 	    varchar(30)		   not null,
    salario     varchar(30)		   not null
);

create table vendas (
    funcionario_id int references funcionarios(id),
    medicamento_id int references medicamentos(id),
    qtd_vendidas int,
    data_venda date
);

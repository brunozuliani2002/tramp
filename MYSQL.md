# create database trampo;
use trampo;
create table tbusuarios(
id INT AUTO_INCREMENT PRIMARY KEY,
login varchar (50) not null,
senha varchar (15) not null
);

select * from tbusuarios;

create table tbcarros(
id INT AUTO_INCREMENT PRIMARY KEY,
carro varchar (50) not null,
preco varchar (20) not null
);

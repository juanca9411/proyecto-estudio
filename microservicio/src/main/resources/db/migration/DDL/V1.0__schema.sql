create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table vehiculo(
idvehiculo int(11) not null auto_increment,
placa varchar(45) not null,.
cilindraje int(11),
tipo varchar(45),
 primary key (idvehiculo,placa)
);

create table orden(
id_orden int(11) not null auto_increment,
placa varchar(45) not null,.
fecha_ingreso DATE,
fecha_salida DATE,
valor_total DOUBLE,
 primary key (id_orden)
);
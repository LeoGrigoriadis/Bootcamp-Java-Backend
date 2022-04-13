create database Comercio;
use Comercio;

create table Cliente(
	id int not null unique,
    nombre varchar(45) not null,
    apellido varchar(45) not null,
    dni int not null unique,
    direccion varchar(45) not null,
    fechaNacimiento date,
    vendedor_id int not null
);
create table Vendedor(
	id int not null unique,
    nombre varchar(45) not null,
    apellido varchar(45) not null,
    dni int not null unique,
    direccion varchar(45) not null,
    fechaNacimiento date
);
create table Productos(
	codigoProd int not null unique,
    precioUnitario double not null,
    cantidad int not null,
    stockMin int not null
);
create table Producto_cliente(
	producto_id int not null,
    cliente_id int not null
);
create table Facturacion(
	numFactura int not null unique,
    fecha datetime not null,
    cliente_id int not null,
    vendedor_id int not null,
    productos_id int not null
);

 
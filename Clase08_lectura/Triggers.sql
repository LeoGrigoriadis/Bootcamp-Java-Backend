CREATE TABLE deleteCliente(
	id int not null primary key,
    nombre varchar(45) not null,
    apellido varchar(45) not null,
    dni int not null unique,
    direccion varchar(45) not null,
    fechaNacimiento date,
    vendedor_id int not null
    );

DELIMITER $$
CREATE OR REPLACE TRIGGER comercio 
BEFORE DELETE ON cliente
FOR EACH ROW BEGIN 
	INSERT INTO deleteCliente(id, nombre, apellido, dni, direccion, fechaNacimiento, vendedor_id) 
    VALUES (null, old.nombre, old.apellido, old.dni, old.direccion, old.fechaNacimiento, old.vendedor_id);
END;$$


CREATE OR REPLACE TRIGGER comercio 
BEFORE DELETE ON cliente
FOR EACH ROW 
	INSERT INTO deleteCliente(id, nombre, apellido, dni, direccion, fechaNacimiento, vendedor_id) 
    VALUES (null, old.nombre, old.apellido, old.dni, old.direccion, old.fechaNacimiento, old.vendedor_id)
END;

DELETE FROM cliente where id=4;
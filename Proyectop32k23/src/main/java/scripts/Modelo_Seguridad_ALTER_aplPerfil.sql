/*Alan Abimael Galicia Ruano; 9959-21-3632*/
/*Fecha: 10/04/2023*/
USE `proyectop312023` ;
alter table tbl_aplicacionperfil 
add perEditar varchar(1) not null,
add perIngresar varchar(1) not null,
add perEliminar varchar(1) not null,
add perVer varchar(1) not null;
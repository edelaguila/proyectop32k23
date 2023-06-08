USE `proyectop312023` ;
alter table tbl_bitacora add bitnombrepc varchar(50) not null;
alter table tbl_aplicacionusuario add ins varchar (1) not null;
alter table tbl_aplicacionusuario add upd varchar (1) not null;
alter table tbl_aplicacionusuario add del varchar (1) not null;
alter table tbl_aplicacionusuario add pri varchar (1) not null;
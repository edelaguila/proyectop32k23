CREATE SCHEMA IF NOT EXISTS `scriptInventarios` DEFAULT CHARACTER SET utf8 ;
USE `scriptInventarios` ;

CREATE TABLE IF NOT EXISTS tbl_Marcas (
	marCodigo int not null auto_increment,
	marNombre VARCHAR(60),
	marExistencias integer,
    marPrecios double,
    marEstatus CHAR,
	PRIMARY KEY (marCodigo) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_Lineas (
	linCodigo int not null auto_increment,
	linNombre VARCHAR(60),
    linPrecios double,
    linEstatus CHAR,
	PRIMARY KEY (linCodigo) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_Productos (
	proCodigo int not null auto_increment,
	linCodigo int not null,
    marCodigo int not null,
	proNombre VARCHAR(60),
    proPrecios double,
    proExistencias integer,
    proEstatus VARCHAR(60),
	PRIMARY KEY (proCodigo),
    foreign key (linCodigo) REFERENCES tbl_Lineas (linCodigo),
    foreign key (marCodigo) REFERENCES tbl_Marcas (marCodigo))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_Bodegas (
	bodCodigo int not null auto_increment,
	bodNombre VARCHAR(60),
    bodDescripcion VARCHAR(60),
    bodFechaIngreso DATE,
    bodFechaSalida DATE,
    bodEstatus CHAR,
	PRIMARY KEY (bodCodigo))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_Existencias (
    proCodigo int not null,
    bodCodigo int not null,
    exiSaldo integer,
    primary key (proCodigo, bodCodigo),
    foreign key (proCodigo) REFERENCES tbl_Productos (proCodigo),
    foreign key (bodCodigo) REFERENCES tbl_Bodegas (bodCodigo))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_Movimientos (
	movCodigo int not null auto_increment,
    movDescripcion VARCHAR(60),
	movEfecto CHAR,
    movEstatus char, 
	PRIMARY KEY (movCodigo))
ENGINE = InnoDB CHARACTER SET = latin1;

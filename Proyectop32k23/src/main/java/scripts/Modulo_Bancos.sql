CREATE SCHEMA IF NOT EXISTS `proyectop312023` DEFAULT CHARACTER SET utf8 ;
USE `proyectop312023` ;

#Tablas necesarias para modulo Bancos

CREATE TABLE IF NOT EXISTS tbl_tipoPersona (
	perTipoId INT(5) NOT NULL,
	tipPerDescripcion VARCHAR(45) NOT NULL,
	tipPerEstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (perTipoId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_personas (
	perId INT(5) NOT NULL,
	perNombre VARCHAR(45) NOT NULL,
	perTipoId INT(5) NOT NULL,
	perEstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (perId),
	FOREIGN KEY (perTipoId) REFERENCES tbl_tipoPersona (perTipoId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_tipoCuentas (
	cueTipoId INT(5),
	cueTipoDescripcion VARCHAR(45),
	cueTipoEstatus VARCHAR(1),
	PRIMARY KEY (cueTipoId))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_cuentas (
	cueId INT(5) NOT NULL,
	cueNumero INT(15) NOT NULL,
	cueSaldo DECIMAL(20,5) NOT NULL,
   	perId INT(5) NOT NULL,
	cueTipoId INT(5) NOT NULL,
	cueestatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (cueId),
	FOREIGN KEY (perId) REFERENCES tbl_personas (perId),
	FOREIGN KEY (cueTipoId) REFERENCES tbl_tipoCuentas (cueTipoId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_conceptos (
	concId INT(5) NOT NULL,
	concNombre VARCHAR(45) NOT NULL,
	concDescripcion VARCHAR(100) NOT NULL,
	concEfecto VARCHAR(1) NOT NULL,
	concEstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (concId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_tipoMovimiento (
	tipMovId INT(5) NOT NULL,
	tipMovNombre VARCHAR(15) NOT NULL,
	tipMovEstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (tipMovId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_moneda (
	tipModId INT(5) NOT NULL,
	tipMondNombre VARCHAR(15) NOT NULL,
	tipMondAbreviacion VARCHAR(4) NOT NULL,
	tipModValor DECIMAL(5,3) NOT NULL,
	PRIMARY KEY (tipModId))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_bancoExterno (
	codBanco INT(5) NOT NULL,
	banNombre VARCHAR(45) NOT NULL,
	banPaís VARCHAR (45) NOT NULL,
	tipModId INT(5) NOT NULL,
	PRIMARY KEY (codBanco),
	FOREIGN KEY (tipModId) REFERENCES tbl_moneda (tipModId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_cuentaEmpresa (
	cueEmId INT(5) NOT NULL,
	cueNumeroEm INT (15) NOT NULL,
	cueSaldoEm DECIMAL(50,5) NOT NULL,
	tipoCuentaEm VARCHAR(20) NOT NULL,
	cueEstatusEm VARCHAR(1) NOT NULL,
	codBanco INT(5) NOT NULL,
	PRIMARY KEY (cueEmId),
	FOREIGN KEY (codBanco) REFERENCES tbl_bancoExterno (codBanco))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_movimientosEncabezado (
	movId INT(5) NOT NULL,
	codBanco INT(5) NOT NULL,
	cueId INT(5) NOT NULL,
	tipMovId INT(5) NOT NULL,
	movFecha datetime NULL,
	cueEmId INT(5) NOT NULL,
	PRIMARY KEY (MovId,codBanco,tipMovId),
	FOREIGN KEY (codBanco) REFERENCES tbl_bancoExterno (codBanco),
	FOREIGN KEY (cueId) REFERENCES tbl_cuentas (cueId),
	FOREIGN KEY (cueEmId) REFERENCES tbl_cuentaEmpresa (cueEmId),
	FOREIGN KEY (tipMovId) REFERENCES tbl_tipoMovimiento (tipMovId))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_movimientosDetalle(
	movDetId INT(5) NOT NULL,
    	movId INT(5) NOT NULL,
    	movCosto DECIMAL(20,5) NOT NULL,
	concId INT(5) NOT NULL,
	movSaldo DECIMAL(20,5) NOT NULL,
	tipModId INT(5) NOT NULL,
	PRIMARY KEY (movDetId,movCosto,tipModId),
	FOREIGN KEY (movId) REFERENCES tbl_movimientosEncabezado (movId),
	FOREIGN KEY (concId) REFERENCES tbl_conceptos (concId),
	FOREIGN KEY (tipModId) REFERENCES tbl_tipoMoneda (tipModId))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE SCHEMA IF NOT EXISTS `proyectop312023` DEFAULT CHARACTER SET utf8 ;
USE `proyectop312023` ;

#Las puse acá solo para que me funcione a mi en las pruebas, despues se borra

CREATE TABLE IF NOT EXISTS tbl_Clientes (
	clId int auto_increment,
    clFecha datetime NULL, 
    clNombre VARCHAR(40) NOT NULL,
    clNit varchar (25) NOT NULL,
    clDebe VARCHAR (25) NOT NULL,
    clHaber VARCHAR (25) NOT NULL,
    clNoFactura varchar (25) NOT NULL,
    PRIMARY KEY(clId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS tbl_Proveedores (
	prId int auto_increment,
    prFecha datetime NULL, 
    prNombre VARCHAR(40) NOT NULL,
    prNit varchar (25) NOT NULL,
    prSaldo VARCHAR (25) NOT NULL,
    prDeuda VARCHAR (25) NOT NULL,
    prNoFactura VARCHAR (25) NOT NULL,
    PRIMARY KEY(prId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#Tablas necesarias para modulo Bancos

CREATE TABLE IF NOT EXISTS tbl_tipoPersonaBancos (
	perTipoId INT(5) NOT NULL,
	tipPerDescripcion VARCHAR(45) NOT NULL,
	tipPerEstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (perTipoId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_personasBancos (
	perId INT(5) NOT NULL,
	perNombre VARCHAR(45) NOT NULL,
	perTipoId INT(5) NOT NULL,
	perEstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (perId),
	FOREIGN KEY (perTipoId) REFERENCES tbl_tipoPersonaBancos (perTipoId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_tipoCuentasBancos (
	cueTipoId INT(5),
	cueTipoDescripcion VARCHAR(45),
	cueTipoEstatus VARCHAR(1),
	PRIMARY KEY (cueTipoId))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_cuentasBancos (
	cueId INT(5) NOT NULL,
	cueNumero INT(15) NOT NULL,
	cueSaldo DECIMAL(20,5) NOT NULL,
   	perId INT(5) NOT NULL,
	cueTipoId INT(5) NOT NULL,
	cueestatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (cueId),
	FOREIGN KEY (perId) REFERENCES tbl_personasBancos (perId),
	FOREIGN KEY (cueTipoId) REFERENCES tbl_tipoCuentasBancos (cueTipoId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_conceptosBancos (
	concId INT(5) NOT NULL,
	concNombre VARCHAR(45) NOT NULL,
	concDescripcion VARCHAR(100) NOT NULL,
	concEfecto VARCHAR(1) NOT NULL,
	concEstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (concId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_tipoMovimientoBancos (
	tipMovId INT(5) NOT NULL,
	tipMovNombre VARCHAR(15) NOT NULL,
	tipMovEstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (tipMovId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_monedaBancos (
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
	FOREIGN KEY (tipModId) REFERENCES tbl_monedaBancos (tipModId) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_cuentaEmpresaBancos (
	cueEmId INT(5) NOT NULL,
	cueNumeroEm INT (15) NOT NULL,
	cueSaldoEm DECIMAL(50,5) NOT NULL,
	tipoCuentaEm VARCHAR(20) NOT NULL,
	cueEstatusEm VARCHAR(1) NOT NULL,
	codBanco INT(5) NOT NULL,
	PRIMARY KEY (cueEmId),
	FOREIGN KEY (codBanco) REFERENCES tbl_bancoExterno (codBanco))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_movimientosEncabezadoBancos (
	movId INT(5) NOT NULL,
	codBanco INT(5) NOT NULL,
	cueId INT(5) NOT NULL,
	tipMovId INT(5) NOT NULL,
	movFecha datetime NULL,
	cueEmId INT(5) NOT NULL,
	PRIMARY KEY (MovId,codBanco,tipMovId),
	FOREIGN KEY (codBanco) REFERENCES tbl_bancoExterno (codBanco),
	FOREIGN KEY (cueId) REFERENCES tbl_cuentasBancos (cueId),
	FOREIGN KEY (cueEmId) REFERENCES tbl_cuentaEmpresaBancos (cueEmId),
	FOREIGN KEY (tipMovId) REFERENCES tbl_tipoMovimientoBancos (tipMovId))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_movimientosDetalleBancos(
	movDetId INT(5) NOT NULL,
    	movId INT(5) NOT NULL,
    	movCosto DECIMAL(20,5) NOT NULL,
	concId INT(5) NOT NULL,
	movSaldo DECIMAL(20,5) NOT NULL,
	tipModId INT(5) NOT NULL,
	PRIMARY KEY (movDetId,movCosto,tipModId),
	FOREIGN KEY (movId) REFERENCES tbl_movimientosEncabezadoBancos (movId),
	FOREIGN KEY (concId) REFERENCES tbl_conceptosBancos (concId),
	FOREIGN KEY (tipModId) REFERENCES tbl_monedaBancos (tipModId))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_boletaClientesBancos (
	bolId int NOT NULL,
	bolCodigo INT(5) NOT NULL, 
	bolFechaEmision datetime NOT NULL,
	concId INT(5) NOT NULL,
	concNombre VARCHAR(45) NOT NULL, 
	cueNumero INT(15) NOT NULL, 
	concEfecto VARCHAR(1) NOT NULL,
	perTipoId INT(5) NOT NULL, 
	concEstatus VARCHAR(1) NOT NULL, 
	clNombre VARCHAR(40) NOT NULL, 
	clId INT NOT NULL,
	clNit VARCHAR(25) NOT NULL, 
	PRIMARY KEY (bolId,bolCodigo),
	FOREIGN KEY (clId) REFERENCES tbl_Clientes (clId))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_comprobanteProveedoresBancos (
	comId int auto_increment NOT NULL,
	concNombre VARCHAR(45) NOT NULL, 
	banNombre VARCHAR(45) NOT NULL,
	conFechaEmision datetime NOT NULL,
 	conFechaVencimiento datetime NOT NULL,
	prNombre VARCHAR(40) NOT NULL, 
	MovCosto DECIMAL(20,5) NOT NULL, 
	ConcDescripcion VARCHAR(100) NOT NULL, 
	tipMovid INT(5) NOT NULL, 
	cueId INT(5) NOT NULL,
	cueNumero INT(15) NOT NULL,
	prSaldo VARCHAR(25) NOT NULL,
	prDeuda VARCHAR(25) NOT NULL, 
	PRIMARY KEY (comId),
	FOREIGN KEY (tipMovId) REFERENCES tbl_tipoMovimientoBancos (tipMovId),
	FOREIGN KEY (cueId) REFERENCES tbl_cuentasBancos (cueId))
ENGINE = InnoDB CHARACTER SET = latin1;
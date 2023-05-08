CREATE SCHEMA IF NOT EXISTS `proyectop312023` DEFAULT CHARACTER SET utf8 ;
USE `proyectop312023` ;

CREATE TABLE IF NOT EXISTS tbl_tipousuario (
	tipuid INT NOT NULL AUTO_INCREMENT,
	tipunombre VARCHAR(60) NOT NULL,
	tipuestatus VARCHAR(60) NOT NULL,
	PRIMARY KEY (tipuid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_usuario (
	usuid INT NOT NULL AUTO_INCREMENT,
	usunombre VARCHAR(45) NOT NULL,
	usucontrasena VARCHAR(25) NOT NULL,
	usuultimasesion DATE,
	usuestatus VARCHAR(1) NOT NULL,
	usunombrereal VARCHAR(60),
	usucorreoe VARCHAR(60),
	usutelefono VARCHAR(25),
	usudireccion VARCHAR(80),
    tipuid INT NOT NULL,
	PRIMARY KEY (usuid),
    FOREIGN KEY (tipuid) REFERENCES tbl_tipousuario (tipuid)
    )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_perfil (
    perid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pernombre VARCHAR(30) NOT NULL,
    perestatus VARCHAR (30) NOT NULL
)ENGINE=InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_aplicacion (
	aplid int NOT NULL AUTO_INCREMENT,
	aplnombre VARCHAR(50),
	aplestatus VARCHAR(50),
	PRIMARY KEY (aplid)
) ENGINE=InnoDB CHARACTER SET = latin1;    

CREATE TABLE IF NOT EXISTS tbl_modulo (
	modid INT NOT NULL AUTO_INCREMENT,
	modnombre VARCHAR(60) NOT NULL,
	modestatus VARCHAR(60) NOT NULL,
	PRIMARY KEY (modid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_aplicacionmodulo (
	aplid INT NOT NULL,
    modid INT NOT NULL,
    PRIMARY KEY (aplid, modid),
    FOREIGN KEY (aplid) REFERENCES tbl_aplicacion ( aplid),
    FOREIGN KEY (modid) REFERENCES tbl_modulo (modid) )
    ENGINE = InnoDB CHARACTER SET = latin1;
    
 CREATE TABLE IF NOT EXISTS tbl_aplicacionperfil(
	aplid INT NOT NULL,
    perid INT NOT NULL,
    PRIMARY KEY(aplid, perid),
    FOREIGN KEY (aplid) REFERENCES tbl_aplicacion (aplid),     
    FOREIGN KEY (perid) REFERENCES tbl_perfil (perid)
 ) ENGINE=InnoDB CHARACTER SET = latin1;     

CREATE TABLE IF NOT EXISTS tbl_aplicacionusuario (
	aplid INT NOT NULL,
	usuid INT NOT NULL,
	PRIMARY KEY (aplid, usuid), 
	FOREIGN KEY (aplid) references tbl_aplicacion (aplid),
	FOREIGN KEY (usuid) references tbl_usuario (usuid)
) ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_perfilusuario (
	perid int NOT NULL,
	usuid int NOT NULL,
	PRIMARY KEY (perid, usuid),
	FOREIGN KEY (perid) REFERENCES tbl_perfil (perid),
	FOREIGN KEY (usuid) REFERENCES tbl_usuario (usuid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS tbl_bitacora (
    bitid int auto_increment PRIMARY KEY,
    bitfecha datetime NULL, 
	bitaccion VARCHAR(10) NOT NULL,
    bitip VARCHAR(25) NOT NULL,
    usuid INT NOT NULL,
    aplid INT NOT NULL,
	FOREIGN KEY (aplid) references tbl_aplicacion (aplid),
	FOREIGN KEY (usuid) references tbl_usuario (usuid)    
) ENGINE=InnoDB DEFAULT CHARSET=latin1;	

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

CREATE TABLE IF NOT EXISTS tbl_cuentas (
	cueId INT(5) NOT NULL,
	cueNumero INT(15) NOT NULL,
	cueSaldo DECIMAL(20,5) NOT NULL,
   	perId INT(5) NOT NULL,
	cueTipo VARCHAR(20) NOT NULL,
	cueestatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (cueId),
	FOREIGN KEY (perId) REFERENCES tbl_personas (perId) )
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

CREATE TABLE IF NOT EXISTS tbl_tipoMoneda (
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
	FOREIGN KEY (tipModId) REFERENCES tbl_tipoMoneda (tipModId) )
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
	PRIMARY KEY (MovId),
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
	PRIMARY KEY (movDetId),
	FOREIGN KEY (movId) REFERENCES tbl_movimientosEncabezado (movId),
	FOREIGN KEY (concId) REFERENCES tbl_conceptos (concId),
	FOREIGN KEY (tipModId) REFERENCES tbl_tipoMoneda (tipModId))
ENGINE = InnoDB CHARACTER SET = latin1;

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

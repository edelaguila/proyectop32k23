CREATE SCHEMA IF NOT EXISTS `proyectop312023` DEFAULT CHARACTER SET utf8 ;
USE `proyectop312023` ;

CREATE TABLE IF NOT EXISTS tbl_cliente (
	clId int auto_increment,
    clNombre VARCHAR(40) NOT NULL,
    cldireccion VARCHAR(40) NOT NULL,
    cltelefono VARCHAR(40) NOT NULL,
    clemail VARCHAR(40) NOT NULL,
    clNit varchar (25) NOT NULL,
	clHaber DOUBLE NOT NULL,
    clDebe DOUBLE NOT NULL,
	PRIMARY KEY (clId))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_vendedores (
	venid INT NOT NULL AUTO_INCREMENT,
	vennombre VARCHAR(60) NOT NULL,
    vendireccion VARCHAR(40) NOT NULL,
    ventelefono VARCHAR(40) NOT NULL,
    venemail VARCHAR(40) NOT NULL,
	PRIMARY KEY (venid))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_pedido (
	pedid INT NOT NULL AUTO_INCREMENT,
    clId INT NOT NULL,
	pedfecha DATE NOT NULL,
    pedTotalGeneral DOUBLE NOT NULL,
	PRIMARY KEY (pedid),
	FOREIGN KEY (clId) REFERENCES tbl_cliente (clId))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_pedidodetalle(
	pedid INT NOT NULL, 
    proCodigo INT NOT NULL,
    proPrecios DOUBLE NOT NULL,
    prodcantidad INT NOT NULL,
    pedTotalInd DOUBLE NOT NULL,
	PRIMARY KEY (pedid, proCodigo),
	FOREIGN KEY (pedid) references tbl_pedido (pedid),
    FOREIGN KEY (proCodigo) references tbl_Productos (proCodigo))
    ENGINE = InnoDB CHARACTER SET = latin1;
    
CREATE TABLE IF NOT EXISTS tbl_cotizacion (
	cotid INT NOT NULL AUTO_INCREMENT,
	clId INT NOT NULL,
    venid INT NOT NULL,
	cotfecha DATE NOT NULL,
    cotTotalGeneral DOUBLE NOT NULL,
	PRIMARY KEY (cotid),
    FOREIGN KEY (venid) REFERENCES tbl_vendedores (venid),
    FOREIGN KEY (clId) REFERENCES tbl_cliente (clId))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_cotdetalle(
	cotid INT NOT NULL, 
    proCodigo INT NOT NULL,
    proPrecios DOUBLE NOT NULL,
    cotprodcantidad INT NOT NULL,
    cotTotalInd DOUBLE NOT NULL,
	PRIMARY KEY (cotid, proCodigo),
	FOREIGN KEY (cotid) references tbl_cotizacion (cotid),
    FOREIGN KEY (proCodigo) references tbl_Productos (proCodigo))
    ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_tienda (
	tieid INT NOT NULL AUTO_INCREMENT,
	tienombre VARCHAR(60) NOT NULL,
	tiedireccion VARCHAR(60) NOT NULL,
    tietipo VARCHAR(60) NOT NULL,
	PRIMARY KEY (tieid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_factura (
	facid INT NOT NULL AUTO_INCREMENT,    
    pedid INT NOT NULL,
    clId INT NOT NULL,
    venid INT NOT NULL,
    tieid INT NOT NULL,
	facTotalGeneral DOUBLE NOT NULL,
	PRIMARY KEY (facid),
    FOREIGN KEY (clId) REFERENCES tbl_cliente (clId),
    FOREIGN KEY (venid) REFERENCES tbl_vendedores (venid),
    FOREIGN KEY (tieid) REFERENCES tbl_tienda (tieid),
	FOREIGN KEY (pedid) REFERENCES tbl_pedido (pedid))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_facturadetalle (
    facid INT NOT NULL,
    clId INT NOT NULL,
    facfecha DATE NOT NULL,
    factdescuento DOUBLE NOT NULL,
    facimpuestos DOUBLE NOT NULL,
    factotalInd DOUBLE NOT NULL,
	PRIMARY KEY (facid, clId),
	FOREIGN KEY (facid) REFERENCES tbl_factura (facid),
    FOREIGN KEY (clId) REFERENCES tbl_cliente (clId))
ENGINE = InnoDB CHARACTER SET = latin1;








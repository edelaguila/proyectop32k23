CREATE SCHEMA IF NOT EXISTS `proyectop3` DEFAULT CHARACTER SET utf8 ;
USE `proyectop3` ;

CREATE TABLE tblProveedor (
  idproveedor INT PRIMARY KEY,
  nombre VARCHAR(255),
  direccion VARCHAR(255),
  telefono INT(20),
  email VARCHAR(255)
) ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE tbl_Compra (
  id_compra INTEGER PRIMARY KEY,
  id_proveedor INTEGER NOT NULL,
  fecha_compra DATE NOT NULL,
  total_compra DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (id_proveedor) REFERENCES tbl_Proveedor(id_proveedor)
) ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE tbl_Producto (
  id_producto INTEGER PRIMARY KEY,
  nombre_producto VARCHAR(50) NOT NULL,
  descripcion_producto VARCHAR(200),
  precio_unitario DECIMAL(10, 2) NOT NULL,
  existencias_total INT NOT NULL
) ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE tbl_Factura (
  id_factura INTEGER PRIMARY KEY,
  id_compra INTEGER NOT NULL,
  fecha_factura DATE NOT NULL,
  total_factura DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (id_compra) REFERENCES tbl_Compra(id_compra)
) ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE tbl_Clasificacion (
  id_clasificacion INTEGER PRIMARY KEY,
  nombre_clasificacion VARCHAR(50) NOT NULL
) ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE tbl_Bodega (
  id_bodega INTEGER PRIMARY KEY,
  nombre_bodega VARCHAR(50) NOT NULL,
  direccion_bodega VARCHAR(100) NOT NULL,
  telefono VARCHAR(20)
) ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE tbl_Detalle_Compra (
id_detalle_compra INTEGER PRIMARY KEY,
id_producto INTEGER NOT NULL,
cantidad INTEGER NOT NULL,
precio_unitario DECIMAL(10, 2) NOT NULL,
id_bodega INTEGER NOT NULL,
id_clasificacion INTEGER NOT NULL,
FOREIGN KEY (id_producto) REFERENCES tbl_Producto(id_producto),
FOREIGN KEY (id_bodega) REFERENCES tbl_Bodega(id_bodega),
FOREIGN KEY (id_clasificacion) REFERENCES tbl_Clasificacion(id_clasificacion)
) ENGINE = InnoDB CHARACTER SET = latin1;

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
    ) ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_tipousuario (
	tipuid INT NOT NULL AUTO_INCREMENT,
	tipunombre VARCHAR(60) NOT NULL,
	tipuestatus VARCHAR(60) NOT NULL,
	PRIMARY KEY (tipuid) )
ENGINE = InnoDB CHARACTER SET = latin1;

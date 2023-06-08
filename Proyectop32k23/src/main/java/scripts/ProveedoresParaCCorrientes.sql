use proyectop312023;
CREATE TABLE IF NOT EXISTS tbl_Proveedores (
    prId int,
    prFecha datetime NULL, 
    prNombre VARCHAR(40) NOT NULL,
    prNit varchar (25) NOT NULL,
    prNoFactura VARCHAR (25) NOT NULL,
    prTotalFactura double,
    PRIMARY KEY(prNoFactura)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
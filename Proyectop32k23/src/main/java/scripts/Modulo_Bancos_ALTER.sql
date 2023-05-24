USE `proyectop312023` ;
alter table tbl_bancoExterno add estatus varchar(1) not null;
alter table tbl_tipoPersonaBancos modify tipPerEstatus varchar(15) not null;

-- Agregar clave foránea a las tablas que contienen el campo "cueTipoId"
-- Tabla: tbl_cuentasBancos
ALTER TABLE tbl_cuentasBancos ADD CONSTRAINT FK_cueTipoId_cuentasBancos
FOREIGN KEY (cueTipoId) REFERENCES tbl_tipoCuentasBancos(cueTipoId);

-- Cambiar campo por llave foránea
-- Primero, eliminamos la columna tipoCuentaEm
ALTER TABLE tbl_cuentaEmpresaBancos DROP COLUMN tipoCuentaEm;
-- Luego, agregamos la columna cueTipoId
ALTER TABLE tbl_cuentaEmpresaBancos ADD cueTipoId INT(5) NOT NULL;
-- A continuación, agregamos la clave foránea
ALTER TABLE tbl_cuentaEmpresaBancos ADD CONSTRAINT FK_cueTipoId_cuentaEmpresaBancos
FOREIGN KEY (cueTipoId) REFERENCES tbl_tipoCuentasBancos(cueTipoId);

-- Modificando el tamaño del VARCHAR del estatus
ALTER TABLE tbl_tipoMovimientoBancos modify tipMovEstatus varchar(15) not null;
ALTER TABLE tbl_cuentasBancos modify cueestatus varchar(15) not null;

-- modificamos el tipo de dato de fecha para movimiento encabezado de un DATETIME a un DATE
ALTER TABLE tbl_movimientosencabezadobancos modify movFecha DATE;

-- agregamos status a tipo moneda
ALTER TABLE tbl_monedabancos add estatus varchar(1) not null;
-- Modificamos el tipo de dato de la tabla comprobante proveedor de DATETIME a DATE
ALTER TABLE tbl_comprobanteProveedoresBancos modify conFechaEmision DATE;
ALTER TABLE tbl_comprobanteProveedoresBancos modify conFechaVencimiento DATE;

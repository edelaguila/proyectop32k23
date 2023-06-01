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

-- modificamos los datos de fecha en comprobante proveedores
ALTER TABLE tbl_comprobanteProveedoresBancos modify conFechaEmision DATE;
-- eliminamos las columnas redundantes en comprobante proveedores
ALTER TABLE tbl_comprobanteProveedoresBancos DROP COLUMN concNombre;
ALTER TABLE tbl_comprobanteProveedoresBancos DROP COLUMN banNombre;
ALTER TABLE tbl_comprobanteProveedoresBancos DROP COLUMN conFechaVencimiento;
ALTER TABLE tbl_comprobanteProveedoresBancos DROP COLUMN prNombre;
ALTER TABLE tbl_comprobanteProveedoresBancos DROP COLUMN MovCosto;
ALTER TABLE tbl_comprobanteProveedoresBancos DROP COLUMN ConcDescripcion;
ALTER TABLE tbl_comprobanteProveedoresBancos DROP COLUMN cueNumero;
ALTER TABLE tbl_comprobanteProveedoresBancos DROP COLUMN prSaldo;
ALTER TABLE tbl_comprobanteProveedoresBancos DROP COLUMN prDeuda;

-- Agregamos las nuevos campos que serian llaves foraneas
ALTER TABLE tbl_comprobanteProveedoresBancos ADD concId INT(5) NOT NULL;
ALTER TABLE tbl_comprobanteProveedoresBancos ADD codBanco INT(5) NOT NULL;
ALTER TABLE tbl_comprobanteProveedoresBancos ADD movDetId INT(5) NOT NULL;
ALTER TABLE tbl_comprobanteProveedoresBancos ADD idproveedor INT(5) NOT NULL;

ALTER TABLE tbl_comprobanteProveedoresBancos  ADD CONSTRAINT FK_concId_comprobanteProveedoresBancos
FOREIGN KEY (concId) REFERENCES tbl_conceptosbancos(concId);

ALTER TABLE tbl_comprobanteProveedoresBancos  ADD CONSTRAINT FK_codBanco_comprobanteProveedoresBancos
FOREIGN KEY (codBanco) REFERENCES tbl_bancoexterno (codBanco);

ALTER TABLE tbl_comprobanteProveedoresBancos  ADD CONSTRAINT FK_movDetId_comprobanteProveedoresBancos
FOREIGN KEY (movDetId) REFERENCES tbl_movimientosdetallebancos(movDetId);

ALTER TABLE tbl_comprobanteProveedoresBancos  ADD CONSTRAINT FK_idproveedor_ccorrientesprov
FOREIGN KEY (idproveedor) REFERENCES tblProveedor(idproveedor);

--Cambios para Cuentas Bancos
--Primero cambiamos el parametro de entrada de 5 digitos a 10
ALTER TABLE tbl_cuentasBancos modify cueId INT(10) NOT NULL;

--Eliminamos la columna de cueNumero
ALTER TABLE tbl_cuentasBancos DROP COLUMN cueNumero;

--Agregamos parametros/columnas nuevas que se necesitan
ALTER TABLE tbl_cuentasBancos ADD tipModId INT(5) NOT NULL;
ALTER TABLE tbl_cuentasBancos ADD codBanco INT(5) NOT NULL;

-- A continuación, agregamos las llaves foráneas
ALTER TABLE tbl_cuentasBancos ADD CONSTRAINT FK_tipModId_cuentasBancos
FOREIGN KEY (tipModId) REFERENCES tbl_monedaBancos(tipModId);

ALTER TABLE tbl_cuentasBancos ADD CONSTRAINT FK_codBanco_cuentasBancos
FOREIGN KEY (codBanco) REFERENCES tbl_bancoExterno(codBanco);

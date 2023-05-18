USE `proyectop312023` ;

CREATE TABLE IF NOT EXISTS tbl_cCorrientes (
	ccid int auto_increment,
    cctipo VARCHAR (25) NOT NULL,
    ccidtipo INT NOT NULL,
    ccfecha DATE,
    ccnombretipo VARCHAR (45) NOT NULL,
    NoFactura VARCHAR (25) NOT NULL,
    ccTotalFactura VARCHAR (25) NOT NULL,
    ccSaldo VARCHAR (25) NOT NULL,
    ccDeuda VARCHAR (25) NOT NULL,
    PRIMARY KEY(ccId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
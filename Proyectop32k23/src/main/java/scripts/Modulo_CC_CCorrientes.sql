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
    PRIMARY KEY(ccid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS tbl_cCorrientesProv (
    cpid int auto_increment,
    cptipo VARCHAR (25) NOT NULL,
    cpidprov INT NOT NULL,
    cpfecha DATE,
    cpnombretipo VARCHAR (45) NOT NULL,
    NpFactura VARCHAR (25) NOT NULL,
    cpTotalFactura VARCHAR (25) NOT NULL,
    cpconcelación VARCHAR (25) NOT NULL,
    cpSaldo VARCHAR (25) NOT NULL,
    PRIMARY KEY(ccid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
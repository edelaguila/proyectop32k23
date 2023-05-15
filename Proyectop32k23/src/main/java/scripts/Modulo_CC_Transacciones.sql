USE `proyectop312023` ;
/*Alan Abimael Galicia Ruano; 9959-21-3632*/
CREATE TABLE IF NOT EXISTS tbl_transaciones_cc (
    tracodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    traNombre VARCHAR(30) NOT NULL,
    traEstatus VARCHAR (30) NOT NULL,
    traEfecto VARCHAR (1) NOT NULL
)ENGINE=InnoDB CHARACTER SET = latin1;
CREATE DATABASE reto;

USE reto;

/*Table structure for table `producto` */

DROP TABLE IF EXISTS nave;

CREATE TABLE nave(
  idnave int(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(20) DEFAULT NULL,
  altura double DEFAULT NULL,
  peso double DEFAULT NULL,
  tipo varchar(20) DEFAULT NULL,
  fini double DEFAULT NULL,
  ffin varchar(20) DEFAULT NULL,
  foto longblob,
  PRIMARY KEY (idnave)
);
-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.21-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para laboratoriojpa
CREATE DATABASE IF NOT EXISTS `laboratoriojpa` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `laboratoriojpa`;


-- Volcando estructura para tabla laboratoriojpa.analisis
CREATE TABLE IF NOT EXISTS `analisis` (
  `cveAnalisis` varchar(10) NOT NULL,
  `nombre` varchar(35) NOT NULL,
  `frecuencia` double NOT NULL,
  PRIMARY KEY (`cveAnalisis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla laboratoriojpa.analisis: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `analisis` DISABLE KEYS */;
INSERT INTO `analisis` (`cveAnalisis`, `nombre`, `frecuencia`) VALUES
	('A0001', 'Medición de Colesterol', 2),
	('A0002', 'Medición de Presion', 1.5),
	('A0003', 'Medición de glucosa', 1),
	('A0004', 'Analisis de Sangre', 4);
/*!40000 ALTER TABLE `analisis` ENABLE KEYS */;


-- Volcando estructura para tabla laboratoriojpa.materiales
CREATE TABLE IF NOT EXISTS `materiales` (
  `clave` varchar(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  PRIMARY KEY (`clave`),
  CONSTRAINT `fk_materiales_productos1` FOREIGN KEY (`clave`) REFERENCES `productos` (`clave`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla laboratoriojpa.materiales: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `materiales` DISABLE KEYS */;
INSERT INTO `materiales` (`clave`, `cantidad`) VALUES
	('889', 56),
	('MKZ40', 454);
/*!40000 ALTER TABLE `materiales` ENABLE KEYS */;


-- Volcando estructura para tabla laboratoriojpa.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `clave` varchar(10) NOT NULL,
  `nombre` varchar(35) NOT NULL,
  `unidad` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`clave`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla laboratoriojpa.productos: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`clave`, `nombre`, `unidad`) VALUES
	('888', 'ghghgh', 'jkj'),
	('8888', 'sasdf', 'pz'),
	('889', 'jarabe', 'Ik'),
	('MKZ40', 'Desecador', 'Pz'),
	('MMA012', 'Matraz Kitazato', 'Pz'),
	('MME038', 'Mechero Bunsen', 'Pz'),
	('MME20', 'Probeta', 'Pz'),
	('MME21', 'Probetas', 'Pz'),
	('MS10', 'Mechero de Bunsen', 'Pz'),
	('MTU012', 'Pipeta', 'Pz'),
	('MVA001', 'Vaso de precipitado', 'Pz');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;


-- Volcando estructura para tabla laboratoriojpa.reactivos
CREATE TABLE IF NOT EXISTS `reactivos` (
  `clave` varchar(10) NOT NULL,
  `cantidad` double NOT NULL,
  PRIMARY KEY (`clave`),
  CONSTRAINT `fk_reactivos_productos1` FOREIGN KEY (`clave`) REFERENCES `productos` (`clave`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla laboratoriojpa.reactivos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `reactivos` DISABLE KEYS */;
/*!40000 ALTER TABLE `reactivos` ENABLE KEYS */;


-- Volcando estructura para tabla laboratoriojpa.reqmateriales
CREATE TABLE IF NOT EXISTS `reqmateriales` (
  `cveReq` varchar(10) NOT NULL,
  `cveAnalisis` varchar(10) NOT NULL,
  `clave` varchar(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  PRIMARY KEY (`cveReq`),
  KEY `fk_reqMateriales_productos1` (`clave`),
  KEY `fk_reqMateriales_analisis1` (`cveAnalisis`),
  CONSTRAINT `fk_reqMateriales_analisis1` FOREIGN KEY (`cveAnalisis`) REFERENCES `analisis` (`cveAnalisis`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reqMateriales_productos1` FOREIGN KEY (`clave`) REFERENCES `productos` (`clave`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla laboratoriojpa.reqmateriales: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `reqmateriales` DISABLE KEYS */;
/*!40000 ALTER TABLE `reqmateriales` ENABLE KEYS */;


-- Volcando estructura para tabla laboratoriojpa.reqreactivos
CREATE TABLE IF NOT EXISTS `reqreactivos` (
  `cveReq` varchar(10) NOT NULL,
  `cveAnalisis` varchar(10) NOT NULL,
  `clave` varchar(10) NOT NULL,
  `cantidad` double NOT NULL,
  PRIMARY KEY (`cveReq`),
  KEY `fk_reqReactivos_analisis` (`cveAnalisis`),
  KEY `fk_reqReactivos_productos1` (`clave`),
  CONSTRAINT `fk_reqReactivos_analisis` FOREIGN KEY (`cveAnalisis`) REFERENCES `analisis` (`cveAnalisis`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reqReactivos_productos1` FOREIGN KEY (`clave`) REFERENCES `productos` (`clave`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla laboratoriojpa.reqreactivos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `reqreactivos` DISABLE KEYS */;
/*!40000 ALTER TABLE `reqreactivos` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

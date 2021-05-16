-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: Teatro
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1

CREATE DATABASE Teatro;
use Teatro;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Acomodador`
--

DROP TABLE IF EXISTS `Acomodador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Acomodador` (
  `idAcomodador` int NOT NULL,
  PRIMARY KEY (`idAcomodador`),
  KEY `fk_Acomodador_EmpleadoDeTeatro1_idx` (`idAcomodador`),
  CONSTRAINT `fk_Acomodador_EmpleadoDeTeatro1` FOREIGN KEY (`idAcomodador`) REFERENCES `EmpleadoDeteatro` (`idEmpleadoDeTeatro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Acomodador`
--

LOCK TABLES `Acomodador` WRITE;
/*!40000 ALTER TABLE `Acomodador` DISABLE KEYS */;
INSERT INTO `Acomodador` VALUES (2),(9);
/*!40000 ALTER TABLE `Acomodador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Beneficio`
--

DROP TABLE IF EXISTS `Beneficio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Beneficio` (
  `idBeneficio` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `importe` double NOT NULL,
  `reporte` double NOT NULL,
  `idBono` int DEFAULT NULL,
  `idTaquillero` int DEFAULT NULL,
  PRIMARY KEY (`idBeneficio`),
  KEY `fk_Beneficio_Bono1_idx` (`idBono`),
  CONSTRAINT `fk_Beneficio_Bono1` FOREIGN KEY (`idBono`) REFERENCES `Bono` (`idBono`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Beneficio`
--

LOCK TABLES `Beneficio` WRITE;
/*!40000 ALTER TABLE `Beneficio` DISABLE KEYS */;
INSERT INTO `Beneficio` VALUES (1,'2019-09-14',20.65,684.25,1,1),(2,'2014-06-08',25.84,957.03,2,4);
/*!40000 ALTER TABLE `Beneficio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Bono`
--

DROP TABLE IF EXISTS `Bono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Bono` (
  `idBono` int NOT NULL AUTO_INCREMENT,
  `mes` int NOT NULL,
  `tipo` char(1) NOT NULL,
  `idUsuario` int NOT NULL,
  PRIMARY KEY (`idBono`,`idUsuario`),
  KEY `fk_Bono_Usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_Bono_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bono`
--

LOCK TABLES `Bono` WRITE;
/*!40000 ALTER TABLE `Bono` DISABLE KEYS */;
INSERT INTO `Bono` VALUES (1,5,'P',1),(2,3,'C',2);
/*!40000 ALTER TABLE `Bono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Coste`
--

DROP TABLE IF EXISTS `Coste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Coste` (
  `idCoste` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `importe` double NOT NULL,
  `idLimpieza` int DEFAULT NULL,
  `idNomina` int DEFAULT NULL,
  `idAcomodador` int DEFAULT NULL,
  PRIMARY KEY (`idCoste`),
  KEY `fk_Coste_Nonima1_idx` (`idNomina`),
  CONSTRAINT `fk_Coste_Nonima1` FOREIGN KEY (`idNomina`) REFERENCES `Nonima` (`idNonima`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Coste`
--

LOCK TABLES `Coste` WRITE;
/*!40000 ALTER TABLE `Coste` DISABLE KEYS */;
INSERT INTO `Coste` VALUES (1,'2021-05-16',26.95,5,NULL,NULL),(2,'2020-12-31',59.92,NULL,1,NULL),(3,'2018-09-19',35.64,NULL,NULL,2);
/*!40000 ALTER TABLE `Coste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Direccion`
--

DROP TABLE IF EXISTS `Direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Direccion` (
  `idDireccion` int NOT NULL,
  `aniosCargo` int DEFAULT NULL,
  PRIMARY KEY (`idDireccion`),
  KEY `fk_Direccion_EmpleadoDeOficina1_idx` (`idDireccion`),
  CONSTRAINT `fk_Direccion_EmpleadoDeOficina1` FOREIGN KEY (`idDireccion`) REFERENCES `EmpleadoDeOficina` (`idEmpleadoDeOficina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Direccion`
--

LOCK TABLES `Direccion` WRITE;
/*!40000 ALTER TABLE `Direccion` DISABLE KEYS */;
INSERT INTO `Direccion` VALUES (8,10);
/*!40000 ALTER TABLE `Direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Empleado`
--

DROP TABLE IF EXISTS `Empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Empleado` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `nif` char(9) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` char(9) NOT NULL,
  `idFranquicia` int NOT NULL,
  `idNonima` int NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `fk_Empleado_Franquicia_idx` (`idFranquicia`),
  KEY `fk_Empleado_Nonima1_idx` (`idNonima`),
  CONSTRAINT `fk_Empleado_Franquicia` FOREIGN KEY (`idFranquicia`) REFERENCES `Franquicia` (`idFranquicia`),
  CONSTRAINT `fk_Empleado_Nonima1` FOREIGN KEY (`idNonima`) REFERENCES `Nonima` (`idNonima`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empleado`
--

LOCK TABLES `Empleado` WRITE;
/*!40000 ALTER TABLE `Empleado` DISABLE KEYS */;
INSERT INTO `Empleado` VALUES (1,'Stefan','Olmo','12345678A','Montenegro','978654123',1,1,'abc123.'),(2,'Daniel','Garcia','97865412B','Santander','456123788',2,2,'abc123.'),(3,'Juan','Perez','78945612A','Madrid','789456126',3,3,'abc123.'),(4,'Alex','Perez','98745612A','Ramales','897456245',1,2,'abc123.'),(5,'Guillermo','Illera','78945612K','Laredo','789456123',2,1,'abc123.'),(6,'Sandra','Burgos','78956789K','Castro','794561235',3,3,'abc123.'),(7,'Mario','Araujo','78945612A','Laredo','897459323',1,1,'abc123.'),(8,'Sergio','Sierra','78945612P','Salamanca','789656123',2,2,'abc123.'),(9,'Esteban','Calvo','78945619V','Zaragoza','456189364',3,3,'abc123.'),(10,'Diego','Smolov','89456915H','Serbia','987451384',1,1,'abc123.');
/*!40000 ALTER TABLE `Empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EmpleadoDeOficina`
--

DROP TABLE IF EXISTS `EmpleadoDeOficina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EmpleadoDeOficina` (
  `idEmpleadoDeOficina` int NOT NULL,
  `aniosPlantilla` int DEFAULT NULL,
  PRIMARY KEY (`idEmpleadoDeOficina`),
  KEY `fk_EmpleadoDeOficina_Empleado1_idx` (`idEmpleadoDeOficina`),
  CONSTRAINT `fk_EmpleadoDeOficina_Empleado1` FOREIGN KEY (`idEmpleadoDeOficina`) REFERENCES `Empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EmpleadoDeOficina`
--

LOCK TABLES `EmpleadoDeOficina` WRITE;
/*!40000 ALTER TABLE `EmpleadoDeOficina` DISABLE KEYS */;
INSERT INTO `EmpleadoDeOficina` VALUES (6,2),(7,8),(8,10);
/*!40000 ALTER TABLE `EmpleadoDeOficina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EmpleadoDeTeatro`
--

DROP TABLE IF EXISTS `EmpleadoDeTeatro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EmpleadoDeTeatro` (
  `idEmpleadoDeTeatro` int NOT NULL,
  `categoria` char(1) NOT NULL,
  `idGrupoDeTrabajo` int NOT NULL,
  PRIMARY KEY (`idEmpleadoDeTeatro`),
  KEY `fk_EmpleadoDeTeatro_Empleado1_idx` (`idEmpleadoDeTeatro`),
  KEY `fk_EmpleadoDeTeatro_GrupoDeTrabajo1_idx` (`idGrupoDeTrabajo`),
  CONSTRAINT `fk_EmpleadoDeTeatro_Empleado1` FOREIGN KEY (`idEmpleadoDeTeatro`) REFERENCES `Empleado` (`idEmpleado`),
  CONSTRAINT `fk_EmpleadoDeTeatro_GrupoDeTrabajo1` FOREIGN KEY (`idGrupoDeTrabajo`) REFERENCES `GrupoDeTrabajo` (`idGrupoDeTrabajo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EmpleadoDeTeatro`
--

LOCK TABLES `EmpleadoDeTeatro` WRITE;
/*!40000 ALTER TABLE `EmpleadoDeTeatro` DISABLE KEYS */;
INSERT INTO `EmpleadoDeTeatro` VALUES (1,'A',1),(2,'B',2),(3,'C',1),(4,'D',2),(8,'A',1),(9,'B',2),(10,'C',1);
/*!40000 ALTER TABLE `EmpleadoDeTeatro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Franquicia`
--

DROP TABLE IF EXISTS `Franquicia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Franquicia` (
  `idFranquicia` int NOT NULL AUTO_INCREMENT,
  `fechaCreacion` date NOT NULL,
  `ubicacion` varchar(80) NOT NULL,
  `accesibilidad` tinyint(1) NOT NULL,
  PRIMARY KEY (`idFranquicia`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Franquicia`
--

LOCK TABLES `Franquicia` WRITE;
/*!40000 ALTER TABLE `Franquicia` DISABLE KEYS */;
INSERT INTO `Franquicia` VALUES (1,'2010-10-20','Santander',1),(2,'2015-05-20','Valencia',0),(3,'2020-09-21','Madrid',1);
/*!40000 ALTER TABLE `Franquicia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GrupoDeTrabajo`
--

DROP TABLE IF EXISTS `GrupoDeTrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `GrupoDeTrabajo` (
  `idGrupoDeTrabajo` int NOT NULL AUTO_INCREMENT,
  `semana` int DEFAULT NULL,
  `mes` int DEFAULT NULL,
  `idFranquicia` int NOT NULL,
  PRIMARY KEY (`idGrupoDeTrabajo`),
  KEY `fk_GrupoDeTrabajo_Franquicia1_idx` (`idFranquicia`),
  CONSTRAINT `fk_Grupo De Trabajo_Franquicia2` FOREIGN KEY (`idFranquicia`) REFERENCES `Franquicia` (`idFranquicia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GrupoDeTrabajo`
--

LOCK TABLES `GrupoDeTrabajo` WRITE;
/*!40000 ALTER TABLE `GrupoDeTrabajo` DISABLE KEYS */;
INSERT INTO `GrupoDeTrabajo` VALUES (1,2,3,1),(2,2,7,2);
/*!40000 ALTER TABLE `GrupoDeTrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Informe`
--

DROP TABLE IF EXISTS `Informe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Informe` (
  `idInforme` int NOT NULL AUTO_INCREMENT,
  `mesyano` date NOT NULL,
  `balance` double NOT NULL,
  `idSecretariado` int NOT NULL,
  `idFranquicia` int NOT NULL,
  `idCoste` int NOT NULL,
  `idBeneficio` int NOT NULL,
  PRIMARY KEY (`idInforme`),
  KEY `fk_Informe_Franquicia1_idx` (`idFranquicia`),
  KEY `fk_Informe_Coste1_idx` (`idCoste`),
  KEY `fk_Informe_Beneficio1_idx` (`idBeneficio`),
  CONSTRAINT `fk_Informe_Beneficio1` FOREIGN KEY (`idBeneficio`) REFERENCES `Beneficio` (`idBeneficio`),
  CONSTRAINT `fk_Informe_Coste1` FOREIGN KEY (`idCoste`) REFERENCES `Coste` (`idCoste`),
  CONSTRAINT `fk_Informe_Franquicia1` FOREIGN KEY (`idFranquicia`) REFERENCES `Franquicia` (`idFranquicia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Informe`
--

LOCK TABLES `Informe` WRITE;
/*!40000 ALTER TABLE `Informe` DISABLE KEYS */;
INSERT INTO `Informe` VALUES (1,'2020-05-16',958.845,6,1,1,2),(2,'2015-06-17',156.8,7,2,2,1);
/*!40000 ALTER TABLE `Informe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Limpieza`
--

DROP TABLE IF EXISTS `Limpieza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Limpieza` (
  `idLimpieza` int NOT NULL,
  PRIMARY KEY (`idLimpieza`),
  KEY `fk_Limpieza_EmpleadoDeTeatro1_idx` (`idLimpieza`),
  CONSTRAINT `fk_Limpieza_EmpleadoDeTeatro1` FOREIGN KEY (`idLimpieza`) REFERENCES `EmpleadoDeTeatro` (`idEmpleadoDeTeatro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Limpieza`
--

LOCK TABLES `Limpieza` WRITE;
/*!40000 ALTER TABLE `Limpieza` DISABLE KEYS */;
INSERT INTO `Limpieza` VALUES (3),(8);
/*!40000 ALTER TABLE `Limpieza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Nonima`
--

DROP TABLE IF EXISTS `Nonima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Nonima` (
  `idNonima` int NOT NULL AUTO_INCREMENT,
  `mesyano` date NOT NULL,
  `idSecretariado` int NOT NULL,
  `idDireccion` int NOT NULL,
  PRIMARY KEY (`idNonima`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Nonima`
--

LOCK TABLES `Nonima` WRITE;
/*!40000 ALTER TABLE `Nonima` DISABLE KEYS */;
INSERT INTO `Nonima` VALUES (1,'2020-05-27',7,5),(2,'2021-09-06',6,5),(3,'2021-05-20',6,5);
/*!40000 ALTER TABLE `Nonima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Secretariado`
--

DROP TABLE IF EXISTS `Secretariado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Secretariado` (
  `idSecretariado` int NOT NULL,
  PRIMARY KEY (`idSecretariado`),
  KEY `fk_Secretariado_EmpleadoDeOficina1_idx` (`idSecretariado`),
  CONSTRAINT `fk_Secretariado_EmpleadoDeOficina1` FOREIGN KEY (`idSecretariado`) REFERENCES `EmpleadoDeOficina` (`idEmpleadoDeOficina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Secretariado`
--

LOCK TABLES `Secretariado` WRITE;
/*!40000 ALTER TABLE `Secretariado` DISABLE KEYS */;
INSERT INTO `Secretariado` VALUES (6),(7);
/*!40000 ALTER TABLE `Secretariado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Taquillero`
--

DROP TABLE IF EXISTS `Taquillero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Taquillero` (
  `idTaquillero` int NOT NULL,
  PRIMARY KEY (`idTaquillero`),
  KEY `fk_Taquillero_EmpleadoDeTeatro1_idx` (`idTaquillero`),
  CONSTRAINT `fk_Taquillero_EmpleadoDeTeatro1` FOREIGN KEY (`idTaquillero`) REFERENCES `EmpleadoDeTeatro` (`idEmpleadoDeTeatro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Taquillero`
--

LOCK TABLES `Taquillero` WRITE;
/*!40000 ALTER TABLE `Taquillero` DISABLE KEYS */;
INSERT INTO `Taquillero` VALUES (1),(4),(10);
/*!40000 ALTER TABLE `Taquillero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `nif` char(9) NOT NULL,
  `telefono` char(9) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'guillermo','illera','98765432A','456123789','guillermo@guillermo.com','abc123.'),(2,'alex','perez','78945613J','789456123','alex@alex.com','abc123.'),(3,'sandra','burgos','123456789','789123456','sandra@sandra.com','abc123.'),(4,'PRUEBA','PRUEBA','12312312A','123123123','alexperez@alexperez.com','827ccb0eea8a706c4c34a16891f84e7b');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-14 14:43:54

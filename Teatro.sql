-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: teatro
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `acomodador`
--

DROP TABLE IF EXISTS `acomodador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acomodador` (
  `idAcomodador` int NOT NULL,
  PRIMARY KEY (`idAcomodador`),
  KEY `fk_Acomodador_EmpleadoDeTeatro1_idx` (`idAcomodador`),
  CONSTRAINT `fk_Acomodador_EmpleadoDeTeatro1` FOREIGN KEY (`idAcomodador`) REFERENCES `empleadodeteatro` (`idEmpleadoDeTeatro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acomodador`
--

LOCK TABLES `acomodador` WRITE;
/*!40000 ALTER TABLE `acomodador` DISABLE KEYS */;
INSERT INTO `acomodador` VALUES (2),(9);
/*!40000 ALTER TABLE `acomodador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beneficio`
--

DROP TABLE IF EXISTS `beneficio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beneficio` (
  `idBeneficio` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `importe` double NOT NULL,
  `reporte` double NOT NULL,
  `idBono` int DEFAULT NULL,
  `idTaquillero` int DEFAULT NULL,
  PRIMARY KEY (`idBeneficio`),
  KEY `fk_Beneficio_Bono1_idx` (`idBono`),
  CONSTRAINT `fk_Beneficio_Bono1` FOREIGN KEY (`idBono`) REFERENCES `bono` (`idBono`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficio`
--

LOCK TABLES `beneficio` WRITE;
/*!40000 ALTER TABLE `beneficio` DISABLE KEYS */;
INSERT INTO `beneficio` VALUES (1,'2019-09-14',20.65,684.25,1,1),(2,'2014-06-08',25.84,957.03,2,4);
/*!40000 ALTER TABLE `beneficio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bono`
--

DROP TABLE IF EXISTS `bono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bono` (
  `idBono` int NOT NULL AUTO_INCREMENT,
  `mes` int NOT NULL,
  `tipo` char(1) COLLATE utf8mb4_general_ci NOT NULL,
  `idUsuario` int NOT NULL,
  PRIMARY KEY (`idBono`,`idUsuario`),
  KEY `fk_Bono_Usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_Bono_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bono`
--

LOCK TABLES `bono` WRITE;
/*!40000 ALTER TABLE `bono` DISABLE KEYS */;
INSERT INTO `bono` VALUES (1,5,'P',1),(2,3,'C',2);
/*!40000 ALTER TABLE `bono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coste`
--

DROP TABLE IF EXISTS `coste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coste` (
  `idCoste` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `importe` double NOT NULL,
  `idLimpieza` int DEFAULT NULL,
  `idNomina` int DEFAULT NULL,
  `idAcomodador` int DEFAULT NULL,
  PRIMARY KEY (`idCoste`),
  KEY `fk_Coste_Nonima1_idx` (`idNomina`),
  CONSTRAINT `fk_Coste_Nonima1` FOREIGN KEY (`idNomina`) REFERENCES `nonima` (`idNonima`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coste`
--

LOCK TABLES `coste` WRITE;
/*!40000 ALTER TABLE `coste` DISABLE KEYS */;
INSERT INTO `coste` VALUES (1,'2021-05-16',26.95,5,NULL,NULL),(2,'2020-12-31',59.92,NULL,1,NULL),(3,'2018-09-19',35.64,NULL,NULL,2);
/*!40000 ALTER TABLE `coste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccion` (
  `idDireccion` int NOT NULL,
  `aniosCargo` int DEFAULT NULL,
  PRIMARY KEY (`idDireccion`),
  KEY `fk_Direccion_EmpleadoDeOficina1_idx` (`idDireccion`),
  CONSTRAINT `fk_Direccion_EmpleadoDeOficina1` FOREIGN KEY (`idDireccion`) REFERENCES `empleadodeoficina` (`idEmpleadoDeOficina`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES (8,10);
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `nif` char(9) COLLATE utf8mb4_general_ci NOT NULL,
  `direccion` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` char(9) COLLATE utf8mb4_general_ci NOT NULL,
  `idFranquicia` int NOT NULL,
  `idNonima` int NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `fk_Empleado_Franquicia_idx` (`idFranquicia`),
  KEY `fk_Empleado_Nonima1_idx` (`idNonima`),
  CONSTRAINT `fk_Empleado_Franquicia` FOREIGN KEY (`idFranquicia`) REFERENCES `franquicia` (`idFranquicia`),
  CONSTRAINT `fk_Empleado_Nonima1` FOREIGN KEY (`idNonima`) REFERENCES `nonima` (`idNonima`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Stefan','Olmo','12345678A','Montenegro','978654123',1,1,'abc123.'),(2,'Daniel','Garcia','97865412B','Santander','456123788',2,2,'abc123.'),(3,'Juan','Perez','78945612A','Madrid','789456126',3,3,'abc123.'),(4,'Alex','Perez','98745612A','Ramales','897456245',1,2,'abc123.'),(6,'Sandra','Burgos','78956789K','Castro','794561235',3,3,'abc123.'),(7,'Mario','Araujo','78945612A','Laredo','897459323',1,1,'abc123.'),(8,'Sergio','Sierra','78945612P','Salamanca','789656123',2,2,'abc123.'),(9,'Esteban','Calvo','78945619V','Zaragoza','456189364',3,3,'abc123.');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleadodeoficina`
--

DROP TABLE IF EXISTS `empleadodeoficina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleadodeoficina` (
  `idEmpleadoDeOficina` int NOT NULL,
  `aniosPlantilla` int DEFAULT NULL,
  PRIMARY KEY (`idEmpleadoDeOficina`),
  KEY `fk_EmpleadoDeOficina_Empleado1_idx` (`idEmpleadoDeOficina`),
  CONSTRAINT `fk_EmpleadoDeOficina_Empleado1` FOREIGN KEY (`idEmpleadoDeOficina`) REFERENCES `empleado` (`idEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleadodeoficina`
--

LOCK TABLES `empleadodeoficina` WRITE;
/*!40000 ALTER TABLE `empleadodeoficina` DISABLE KEYS */;
INSERT INTO `empleadodeoficina` VALUES (6,2),(7,8),(8,10);
/*!40000 ALTER TABLE `empleadodeoficina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleadodeteatro`
--

DROP TABLE IF EXISTS `empleadodeteatro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleadodeteatro` (
  `idEmpleadoDeTeatro` int NOT NULL,
  `categoria` char(1) COLLATE utf8mb4_general_ci NOT NULL,
  `idGrupoDeTrabajo` int NOT NULL,
  PRIMARY KEY (`idEmpleadoDeTeatro`),
  KEY `fk_EmpleadoDeTeatro_Empleado1_idx` (`idEmpleadoDeTeatro`),
  KEY `fk_EmpleadoDeTeatro_GrupoDeTrabajo1_idx` (`idGrupoDeTrabajo`),
  CONSTRAINT `fk_EmpleadoDeTeatro_Empleado1` FOREIGN KEY (`idEmpleadoDeTeatro`) REFERENCES `empleado` (`idEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_EmpleadoDeTeatro_GrupoDeTrabajo1` FOREIGN KEY (`idGrupoDeTrabajo`) REFERENCES `grupodetrabajo` (`idGrupoDeTrabajo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleadodeteatro`
--

LOCK TABLES `empleadodeteatro` WRITE;
/*!40000 ALTER TABLE `empleadodeteatro` DISABLE KEYS */;
INSERT INTO `empleadodeteatro` VALUES (1,'A',1),(2,'B',2),(3,'C',1),(4,'D',2),(8,'A',1),(9,'B',2);
/*!40000 ALTER TABLE `empleadodeteatro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `franquicia`
--

DROP TABLE IF EXISTS `franquicia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `franquicia` (
  `idFranquicia` int NOT NULL AUTO_INCREMENT,
  `fechaCreacion` date NOT NULL,
  `ubicacion` varchar(80) COLLATE utf8mb4_general_ci NOT NULL,
  `accesibilidad` tinyint(1) NOT NULL,
  PRIMARY KEY (`idFranquicia`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `franquicia`
--

LOCK TABLES `franquicia` WRITE;
/*!40000 ALTER TABLE `franquicia` DISABLE KEYS */;
INSERT INTO `franquicia` VALUES (1,'2010-10-20','Santander',1),(2,'2015-05-20','Valencia',0),(3,'2020-09-21','Madrid',1);
/*!40000 ALTER TABLE `franquicia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupodetrabajo`
--

DROP TABLE IF EXISTS `grupodetrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupodetrabajo` (
  `idGrupoDeTrabajo` int NOT NULL AUTO_INCREMENT,
  `semana` int DEFAULT NULL,
  `mes` int DEFAULT NULL,
  `idFranquicia` int NOT NULL,
  PRIMARY KEY (`idGrupoDeTrabajo`),
  KEY `fk_GrupoDeTrabajo_Franquicia1_idx` (`idFranquicia`),
  CONSTRAINT `fk_Grupo De Trabajo_Franquicia2` FOREIGN KEY (`idFranquicia`) REFERENCES `franquicia` (`idFranquicia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupodetrabajo`
--

LOCK TABLES `grupodetrabajo` WRITE;
/*!40000 ALTER TABLE `grupodetrabajo` DISABLE KEYS */;
INSERT INTO `grupodetrabajo` VALUES (1,2,3,1),(2,2,7,2);
/*!40000 ALTER TABLE `grupodetrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informe`
--

DROP TABLE IF EXISTS `informe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informe` (
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
  CONSTRAINT `fk_Informe_Beneficio1` FOREIGN KEY (`idBeneficio`) REFERENCES `beneficio` (`idBeneficio`),
  CONSTRAINT `fk_Informe_Coste1` FOREIGN KEY (`idCoste`) REFERENCES `coste` (`idCoste`),
  CONSTRAINT `fk_Informe_Franquicia1` FOREIGN KEY (`idFranquicia`) REFERENCES `franquicia` (`idFranquicia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informe`
--

LOCK TABLES `informe` WRITE;
/*!40000 ALTER TABLE `informe` DISABLE KEYS */;
INSERT INTO `informe` VALUES (1,'2020-05-16',958.845,6,1,1,2),(2,'2015-06-17',156.8,7,2,2,1);
/*!40000 ALTER TABLE `informe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `limpieza`
--

DROP TABLE IF EXISTS `limpieza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `limpieza` (
  `idLimpieza` int NOT NULL,
  PRIMARY KEY (`idLimpieza`),
  KEY `fk_Limpieza_EmpleadoDeTeatro1_idx` (`idLimpieza`),
  CONSTRAINT `fk_Limpieza_EmpleadoDeTeatro1` FOREIGN KEY (`idLimpieza`) REFERENCES `empleadodeteatro` (`idEmpleadoDeTeatro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `limpieza`
--

LOCK TABLES `limpieza` WRITE;
/*!40000 ALTER TABLE `limpieza` DISABLE KEYS */;
INSERT INTO `limpieza` VALUES (3),(8);
/*!40000 ALTER TABLE `limpieza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nonima`
--

DROP TABLE IF EXISTS `nonima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nonima` (
  `idNonima` int NOT NULL AUTO_INCREMENT,
  `mesyano` date NOT NULL,
  `idSecretariado` int NOT NULL,
  `idDireccion` int NOT NULL,
  PRIMARY KEY (`idNonima`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nonima`
--

LOCK TABLES `nonima` WRITE;
/*!40000 ALTER TABLE `nonima` DISABLE KEYS */;
INSERT INTO `nonima` VALUES (1,'2020-05-27',7,5),(2,'2021-09-06',6,5),(3,'2021-05-20',6,5);
/*!40000 ALTER TABLE `nonima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretariado`
--

DROP TABLE IF EXISTS `secretariado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `secretariado` (
  `idSecretariado` int NOT NULL,
  PRIMARY KEY (`idSecretariado`),
  KEY `fk_Secretariado_EmpleadoDeOficina1_idx` (`idSecretariado`),
  CONSTRAINT `fk_Secretariado_EmpleadoDeOficina1` FOREIGN KEY (`idSecretariado`) REFERENCES `empleadodeoficina` (`idEmpleadoDeOficina`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretariado`
--

LOCK TABLES `secretariado` WRITE;
/*!40000 ALTER TABLE `secretariado` DISABLE KEYS */;
INSERT INTO `secretariado` VALUES (6),(7);
/*!40000 ALTER TABLE `secretariado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taquillero`
--

DROP TABLE IF EXISTS `taquillero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taquillero` (
  `idTaquillero` int NOT NULL,
  PRIMARY KEY (`idTaquillero`),
  KEY `fk_Taquillero_EmpleadoDeTeatro1_idx` (`idTaquillero`),
  CONSTRAINT `fk_Taquillero_EmpleadoDeTeatro1` FOREIGN KEY (`idTaquillero`) REFERENCES `empleadodeteatro` (`idEmpleadoDeTeatro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taquillero`
--

LOCK TABLES `taquillero` WRITE;
/*!40000 ALTER TABLE `taquillero` DISABLE KEYS */;
INSERT INTO `taquillero` VALUES (1),(4);
/*!40000 ALTER TABLE `taquillero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `nif` char(9) COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` char(9) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'guillermo','illera','98765432A','456123789','guillermo@guillermo.com','abc123.'),(2,'alex','perez','78945613J','789456123','alex@alex.com','abc123.'),(3,'sandra','burgos','123456789','789123456','sandra@sandra.com','abc123.'),(4,'PRUEBA','PRUEBA','12312312A','123123123','alexperez@alexperez.com','827ccb0eea8a706c4c34a16891f84e7b');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-25 15:46:00

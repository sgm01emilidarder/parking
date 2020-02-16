-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: parking-manager
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `factures`
--

DROP TABLE IF EXISTS `factures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factures` (
  `fac_id` int(11) NOT NULL AUTO_INCREMENT,
  `fac_data` date NOT NULL,
  `fac_hora_inici` time NOT NULL,
  `fac_hora_final` time NOT NULL,
  `fac_preu` double NOT NULL,
  `fac_usu_id` int(11) NOT NULL,
  `fac_par_id` int(11) NOT NULL,
  `fac_vehicle` varchar(7) NOT NULL,
  PRIMARY KEY (`fac_id`),
  KEY `fac_usu_fk_idx` (`fac_usu_id`),
  KEY `fac_par_fk_idx` (`fac_par_id`),
  CONSTRAINT `fac_par_fk` FOREIGN KEY (`fac_par_id`) REFERENCES `parkings` (`par_id`),
  CONSTRAINT `fac_usu_fk` FOREIGN KEY (`fac_usu_id`) REFERENCES `usuaris` (`usu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factures`
--

LOCK TABLES `factures` WRITE;
/*!40000 ALTER TABLE `factures` DISABLE KEYS */;
/*!40000 ALTER TABLE `factures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parkings`
--

DROP TABLE IF EXISTS `parkings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parkings` (
  `par_id` int(11) NOT NULL AUTO_INCREMENT,
  `par_municipi` varchar(100) DEFAULT NULL,
  `par_numPlaces` int(11) DEFAULT NULL,
  `par_direccio` varchar(100) DEFAULT NULL,
  `par_horaInici` time DEFAULT NULL,
  `par_horaFi` time DEFAULT NULL,
  `par_preuHora` double DEFAULT NULL,
  `par_imatge` varchar(45) DEFAULT NULL,
  `par_tipus` enum('cubierto','asfaltado','tierra') DEFAULT NULL,
  PRIMARY KEY (`par_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parkings`
--

LOCK TABLES `parkings` WRITE;
/*!40000 ALTER TABLE `parkings` DISABLE KEYS */;
INSERT INTO `parkings` VALUES (1,'Palma',100,'Carrer del Marquès de la Fontsanta, 52','08:00:00','22:00:00',5,'palma.jpg','cubierto'),(2,'Alaró',180,'Plaça Clastra de son Togores, 30','08:00:00','20:00:00',3,'alaro.jpg','tierra'),(3,'Inca',300,'Plaça Mare de Déu de Lluch','06:00:00','23:00:00',6,'inca.jpg','asfaltado');
/*!40000 ALTER TABLE `parkings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuaris`
--

DROP TABLE IF EXISTS `usuaris`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuaris` (
  `usu_id` int(11) NOT NULL AUTO_INCREMENT,
  `usu_nom` varchar(20) DEFAULT NULL,
  `usu_llinatges` varchar(30) DEFAULT NULL,
  `usu_username` varchar(45) DEFAULT NULL,
  `usu_password` varchar(200) DEFAULT NULL,
  `usu_matricula1` varchar(7) NOT NULL,
  `usu_matricula2` varchar(7) DEFAULT NULL,
  `usu_matricula3` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`usu_id`),
  UNIQUE KEY `usu_username_UNIQUE` (`usu_username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuaris`
--

LOCK TABLES `usuaris` WRITE;
/*!40000 ALTER TABLE `usuaris` DISABLE KEYS */;
INSERT INTO `usuaris` VALUES (4,'admin','admin','admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','0','0','0');
/*!40000 ALTER TABLE `usuaris` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-16 14:31:02

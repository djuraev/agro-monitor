-- MySQL dump 10.13  Distrib 5.7.37, for Linux (x86_64)
--
-- Host: localhost    Database: agromon
-- ------------------------------------------------------
-- Server version	5.7.37-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `sequence` int(11) NOT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  `admin_type` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `surname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (0,1,0,'Uzbekistan','125','admin','adminuz'),(1,1,0,'Uzbekistan','125','super admin','sudo');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `api_info`
--

DROP TABLE IF EXISTS `api_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `api_info` (
  `sequence` int(11) NOT NULL,
  `api_key` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `api_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_expired` bit(1) NOT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `api_info`
--

LOCK TABLES `api_info` WRITE;
/*!40000 ALTER TABLE `api_info` DISABLE KEYS */;
INSERT INTO `api_info` VALUES (16,'agromon','b5efce714742cc3aba8062b29f8c86f1',_binary '\0'),(17,'demo','https://youtu.be/LP9YK_vKeMM',_binary '\0'),(18,'about','This is Agromon App Demo',_binary '\0'),(19,'b5efce714742cc3aba8062b29f8c86f1','agromon',_binary '\0'),(20,'https://youtu.be/LP9YK_vKeMM','demo',_binary '\0'),(21,'This is Agromon App','info',_binary '\0'),(22,'This is Agromon App.','about',_binary '');
/*!40000 ALTER TABLE `api_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claim`
--

DROP TABLE IF EXISTS `claim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `claim` (
  `sequence` int(11) NOT NULL AUTO_INCREMENT,
  `area_ton` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `crop_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `farmer_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `farmer_phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `field_id` int(11) DEFAULT NULL,
  `field_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB AUTO_INCREMENT=323 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim`
--

LOCK TABLES `claim` WRITE;
/*!40000 ALTER TABLE `claim` DISABLE KEYS */;
INSERT INTO `claim` VALUES (322,'12','Wheat','Shovkat','Shovkat','998988',2,'Bug\'doyzor Lalmi','Submitted','998988','27/01/2022 13:09:37',NULL);
/*!40000 ALTER TABLE `claim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crop`
--

DROP TABLE IF EXISTS `crop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crop` (
  `sequence` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `extra_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crop`
--

LOCK TABLES `crop` WRITE;
/*!40000 ALTER TABLE `crop` DISABLE KEYS */;
INSERT INTO `crop` VALUES (1,'WHT','Wheat is a grass widely cultivated for its seed, a cereal grain which is a worldwide staple food. The many species of wheat together make up the genus Triticum; the most widely grown is common wheat.','Wheat'),(2,'CTN','Cotton is a soft, fluffy staple fiber that grows in a boll, or protective case, around the seeds of the cotton plants of the genus Gossypium in the mallow family Malvaceae.','Cotton'),(3,'BRLY','Barley, a member of the grass family, is a major cereal grain grown in temperate climates globally. It was one of the first cultivated grains, particularly in Eurasia as early as 10,000 years ago.','Barley'),(4,'MZE','Maize, also known as corn, is a cereal grain first domesticated by indigenous peoples in southern Mexico about 10,000 years ago.','Maize');
/*!40000 ALTER TABLE `crop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crop_yield`
--

DROP TABLE IF EXISTS `crop_yield`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crop_yield` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `field_id` int(11) DEFAULT NULL,
  `value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `year` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=320 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crop_yield`
--

LOCK TABLES `crop_yield` WRITE;
/*!40000 ALTER TABLE `crop_yield` DISABLE KEYS */;
INSERT INTO `crop_yield` VALUES (51,'Wheat',23,'56','Text_2010'),(52,'Wheat',23,'','Text_2011'),(53,'Wheat',23,'','Text_2012'),(54,'Wheat',23,'56','Text_2013'),(55,'Wheat',23,'','Text_2014'),(56,'Wheat',23,'23','Text_2015'),(57,'Wheat',23,'','Text_2016'),(58,'Wheat',23,'11','Text_2017'),(59,'Wheat',23,'','Text_2018'),(60,'Wheat',23,'','Text_2019'),(61,'Wheat',23,'98','Text_2020'),(62,'Wheat',23,'','Text_2021'),(63,'Wheat',24,'12','Text_2010'),(64,'Wheat',24,'32','Text_2011'),(65,'Wheat',24,'15','Text_2012'),(66,'Wheat',24,'','Text_2013'),(67,'Wheat',24,'','Text_2014'),(68,'Wheat',24,'','Text_2015'),(69,'Wheat',24,'','Text_2016'),(70,'Wheat',24,'','Text_2017'),(71,'Wheat',24,'','Text_2018'),(72,'Wheat',24,'','Text_2019'),(73,'Wheat',24,'','Text_2020'),(74,'Wheat',24,'','Text_2021'),(281,'Wheat',2,'18.85','Text_2010'),(282,'Wheat',2,'45','Text_2011'),(283,'Wheat',2,'23','Text_2012'),(284,'Wheat',2,'34','Text_2013'),(285,'Wheat',2,'3.5','Text_2014'),(286,'Wheat',2,'22','Text_2015'),(287,'Wheat',2,'25.9','Text_2016'),(288,'Wheat',2,'50','Text_2017'),(289,'Wheat',2,'31','Text_2018'),(290,'Wheat',2,'20','Text_2019'),(291,'Wheat',2,'18','Text_2020'),(292,'Wheat',2,'30.5','Text_2021'),(308,'Cotton',3,'12.03','Text_2010'),(309,'Cotton',3,'34','Text_2011'),(310,'Cotton',3,'50','Text_2012'),(311,'Cotton',3,'12','Text_2013'),(312,'Cotton',3,'45','Text_2014'),(313,'Cotton',3,'55','Text_2015'),(314,'Cotton',3,'78','Text_2016'),(315,'Cotton',3,'5','Text_2017'),(316,'Cotton',3,'43','Text_2018'),(317,'Cotton',3,'23','Text_2019'),(318,'Cotton',3,'67','Text_2020'),(319,'Cotton',3,'80','Text_2021');
/*!40000 ALTER TABLE `crop_yield` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district` (
  `sequence` int(11) NOT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `region_sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (7,1,'Shakhrisabz',4),(276,1,'Bulungur',275);
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district_metric`
--

DROP TABLE IF EXISTS `district_metric`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district_metric` (
  `sequence` int(11) NOT NULL AUTO_INCREMENT,
  `crop_id` int(11) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL,
  `metric_id` int(11) DEFAULT NULL,
  `value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `year` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district_metric`
--

LOCK TABLES `district_metric` WRITE;
/*!40000 ALTER TABLE `district_metric` DISABLE KEYS */;
INSERT INTO `district_metric` VALUES (31,1,7,1,'136','2007',NULL),(32,2,7,1,'136','2007',NULL),(33,2,7,1,'136','2010',NULL),(34,1,7,1,'136','2010',NULL),(35,1,7,1,'136','2007',NULL),(36,1,7,1,'139','2008',NULL),(37,1,7,1,'129','2009',NULL),(38,1,7,1,'150','2010',NULL),(39,1,7,1,'125','2008',NULL),(40,1,7,1,'125','2008',NULL),(330,1,7,1,'200','2010',NULL),(331,1,7,1,'300','2011',NULL),(332,1,7,1,'200','2012',NULL),(333,1,7,1,'250','2013',NULL);
/*!40000 ALTER TABLE `district_metric` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district_name`
--

DROP TABLE IF EXISTS `district_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district_name` (
  `sequence` int(11) NOT NULL,
  `lang_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `local_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `district_sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`),
  KEY `FKetpsxrr40xa8nbq0lwplj9s6r` (`district_sequence`),
  CONSTRAINT `FKetpsxrr40xa8nbq0lwplj9s6r` FOREIGN KEY (`district_sequence`) REFERENCES `district` (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district_name`
--

LOCK TABLES `district_name` WRITE;
/*!40000 ALTER TABLE `district_name` DISABLE KEYS */;
INSERT INTO `district_name` VALUES (8,'en','Shakhrisabz',7),(9,'ru','Шахрисабз',7);
/*!40000 ALTER TABLE `district_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `field`
--

DROP TABLE IF EXISTS `field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `field` (
  `sequence` int(11) NOT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  `api_key` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `area` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `center` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `crop_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `polygon` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `village_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `village_sequence` int(11) DEFAULT NULL,
  `agromon_area` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_area` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `crop_name` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `field`
--

LOCK TABLES `field` WRITE;
/*!40000 ALTER TABLE `field` DISABLE KEYS */;
INSERT INTO `field` VALUES (2,1,'61b367c8d80213086a0d7d2a',NULL,'[66.99035419999998, 39.040473199999994]','Mani fermerlik yerim',1,'Bugdoyzor','66.98686122894286+39.04405277665515:66.98673248291016+39.038152994391346:66.99244022369385+39.03811966088858:66.99282646179199+39.0390196599435:66.99291229248047+39.04301951704373:66.98686122894286+39.04405277665515','998988','Chilonzor',10,'31.4181','10',NULL),(3,1,'61b3686ad8021308960d7d2b',NULL,'[66.92788475, 39.043328]','Besh Yulduz',2,'Paxtazor','66.92630767822266+39.044686057334225:66.9261360168457+39.042252895308216:66.92914009094238+39.04201957399835:66.92995548248291+39.044352752421325:66.92630767822266+39.044686057334225','998988','Bodomzor',10,'7.7615','5',NULL),(23,1,'618cb839a81b7627cd68b2f3','190.9484','[-121.1867, 37.67385]','This is my paxtazor',1,'Paxtazor','-121.1958+37.6683:-121.1779+37.6687:-121.1773+37.6792:-121.1958+37.6792:-121.1958+37.6683','998977','Narimon',10,NULL,NULL,NULL),(24,1,'618cb85aa81b76689a68b2f4','190.9484','[-121.1867, 37.67385]','This is my Gallazor',1,'Gallazo','-121.1958+37.6683:-121.1779+37.6687:-121.1773+37.6792:-121.1958+37.6792:-121.1958+37.6683','998977','Narimon',10,NULL,NULL,NULL);
/*!40000 ALTER TABLE `field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `field_metric`
--

DROP TABLE IF EXISTS `field_metric`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `field_metric` (
  `sequence` int(11) NOT NULL AUTO_INCREMENT,
  `crop_id` int(11) DEFAULT NULL,
  `field_id` int(11) DEFAULT NULL,
  `metric_id` int(11) DEFAULT NULL,
  `value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `year` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `field_metric`
--

LOCK TABLES `field_metric` WRITE;
/*!40000 ALTER TABLE `field_metric` DISABLE KEYS */;
/*!40000 ALTER TABLE `field_metric` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (338);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` VALUES ('default',24);
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance`
--

DROP TABLE IF EXISTS `insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insurance` (
  `sequence` int(11) NOT NULL AUTO_INCREMENT,
  `agency_sequence` int(11) DEFAULT NULL,
  `farm_sequence` int(11) DEFAULT NULL,
  `insurance_number` int(11) DEFAULT NULL,
  `insurance_period` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  `user_sequence` int(11) DEFAULT NULL,
  `field_sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance`
--

LOCK TABLES `insurance` WRITE;
/*!40000 ALTER TABLE `insurance` DISABLE KEYS */;
/*!40000 ALTER TABLE `insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance_agency`
--

DROP TABLE IF EXISTS `insurance_agency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insurance_agency` (
  `sequence` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `other_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance_agency`
--

LOCK TABLES `insurance_agency` WRITE;
/*!40000 ALTER TABLE `insurance_agency` DISABLE KEYS */;
/*!40000 ALTER TABLE `insurance_agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `sequence` int(11) NOT NULL,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `native_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sequence`),
  UNIQUE KEY `UK_5h2eb4yggd9jjo1x9kd594t02` (`code`),
  UNIQUE KEY `UK_g8hr207ijpxlwu10pewyo65gv` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metric`
--

DROP TABLE IF EXISTS `metric`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metric` (
  `sequence` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `extra_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metric`
--

LOCK TABLES `metric` WRITE;
/*!40000 ALTER TABLE `metric` DISABLE KEYS */;
INSERT INTO `metric` VALUES (1,'ndvi','Normalized difference vegetation index','NDVI'),(2,'evi','Enhanced Vegetation Index','EVI'),(3,'chlorophyll','Chlorophyll','Chlorophyll');
/*!40000 ALTER TABLE `metric` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `sequence` int(11) NOT NULL AUTO_INCREMENT,
  `crop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `farmer_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `field_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `field_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hectares` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `sequence` int(11) NOT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (4,1,'Kashkadaryo'),(265,NULL,''),(275,1,'Samarkand'),(323,1,'Djizzak');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region_name`
--

DROP TABLE IF EXISTS `region_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region_name` (
  `sequence` int(11) NOT NULL,
  `lang_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `local_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `region_sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`),
  KEY `FKr3n6k085u30e1kjqlubwwckp9` (`region_sequence`),
  CONSTRAINT `FKr3n6k085u30e1kjqlubwwckp9` FOREIGN KEY (`region_sequence`) REFERENCES `region` (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region_name`
--

LOCK TABLES `region_name` WRITE;
/*!40000 ALTER TABLE `region_name` DISABLE KEYS */;
INSERT INTO `region_name` VALUES (5,'en','Kashkadaryo',4),(6,'ru','Кашкадарья',4);
/*!40000 ALTER TABLE `region_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `sequence` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'USER'),(2,'ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant`
--

DROP TABLE IF EXISTS `tenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenant` (
  `id` int(11) NOT NULL,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `capital` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `coordinates` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_40na76d811fvgelpf3re932jx` (`code`),
  UNIQUE KEY `UK_al3h2up1hmcs7o7kavmkqtx37` (`country`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` VALUES (1,'UZB','Uzbekistan',NULL,'41.311081:69.240562'),(274,'2','Kazakhstan','Astana','51.169392:71.449074'),(296,'TRK','Turkmanistan','Ashgabad','37.862499:58.238056'),(306,'','','',''),(325,'KGZ','Kyrgyzstan','Bishkek','42.871431:74.589280');
/*!40000 ALTER TABLE `tenant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant_info`
--

DROP TABLE IF EXISTS `tenant_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenant_info` (
  `sequence` int(11) NOT NULL,
  `field_count` int(11) DEFAULT NULL,
  `land` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  `user_count` int(11) DEFAULT NULL,
  `village_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant_info`
--

LOCK TABLES `tenant_info` WRITE;
/*!40000 ALTER TABLE `tenant_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `tenant_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant_name`
--

DROP TABLE IF EXISTS `tenant_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenant_name` (
  `sequence` int(11) NOT NULL,
  `lang_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tenant_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`),
  KEY `FK1ij53m29dyblyy2igvgxtiyoi` (`tenant_id`),
  CONSTRAINT `FK1ij53m29dyblyy2igvgxtiyoi` FOREIGN KEY (`tenant_id`) REFERENCES `tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant_name`
--

LOCK TABLES `tenant_name` WRITE;
/*!40000 ALTER TABLE `tenant_name` DISABLE KEYS */;
INSERT INTO `tenant_name` VALUES (2,'en','Uzbekistan','UZB',1),(3,'uz','Ўзбекистон','UZB',1);
/*!40000 ALTER TABLE `tenant_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `sequence` int(11) NOT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  `district_sequence` int(11) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `insurance_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `region_sequence` int(11) DEFAULT NULL,
  `surname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `village_sequence` int(11) DEFAULT NULL,
  `date_of_birth` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `extra_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sequence`),
  UNIQUE KEY `UK_6ae2xmxf8vv06mycblurwey9t` (`insurance_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,7,'fontik@mail.com','998988','Jeff','$2a$10$SBTd9wYnsolNrbgVZaMjFOVmF00FOc1kr4y3psW1oSxMG0X/QEdSu',4,'Dean',10,'1990.01.01',NULL,'+998977995665'),(13,1,7,'mail@mail.ru','998977','Alex','$2a$10$F.YrFGpGploXgV1Doee0L.a1XHypVdX.3VrFNBnPYen.YWBIqrche',4,'Giordano',10,'1990.02.10',NULL,'+998977990990'),(321,1,7,'mirza@mail.com','321230','Mirza','$2a$10$.2Eu9W2xGwCFofq.DDZKxOy8/5z6B4KREUhb9UinNL04IWloqlXHu',4,'Karimov',10,'01.01.1980','','998909853221'),(324,1,7,'',NULL,'','$2a$10$LTDM.xxYiBbeCYGrl7Ivv.vpVt1fnLq1/kL1CNpUPQoZPrnCL3JhG',4,'',10,'','','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_sequence` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_sequence`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FKe5yakti74pdcsh2es8ixafq2e` FOREIGN KEY (`user_sequence`) REFERENCES `user` (`sequence`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(13,1),(321,1),(324,1);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `village`
--

DROP TABLE IF EXISTS `village`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `village` (
  `sequence` int(11) NOT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  `district_sequence` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `coordinates` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `village`
--

LOCK TABLES `village` WRITE;
/*!40000 ALTER TABLE `village` DISABLE KEYS */;
INSERT INTO `village` VALUES (10,1,7,'Narimon',NULL);
/*!40000 ALTER TABLE `village` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `village_metric`
--

DROP TABLE IF EXISTS `village_metric`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `village_metric` (
  `sequence` int(11) NOT NULL AUTO_INCREMENT,
  `crop_id` int(11) DEFAULT NULL,
  `metric_id` int(11) DEFAULT NULL,
  `value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `village_id` int(11) DEFAULT NULL,
  `year` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sequence`)
) ENGINE=InnoDB AUTO_INCREMENT=274 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `village_metric`
--

LOCK TABLES `village_metric` WRITE;
/*!40000 ALTER TABLE `village_metric` DISABLE KEYS */;
INSERT INTO `village_metric` VALUES (24,1,1,'140',10,'2000',NULL),(25,1,1,'141',10,'2001',NULL),(26,1,1,'130',10,'2002',NULL),(27,1,1,'130',10,'2003',NULL),(28,1,1,'138',10,'2004',NULL),(29,1,1,'125',10,'2005',NULL),(30,1,1,'129',10,'2006',NULL),(41,1,1,'125',10,'2007',NULL),(42,1,1,'125',10,'2008',NULL),(43,1,1,'135',10,'2009',NULL),(44,1,1,'150',10,'2010',NULL),(45,1,1,'145',10,'2011',NULL),(46,1,1,'143',10,'2012',NULL),(47,1,1,'140',10,'2014',NULL),(48,1,1,'141',10,'2013',NULL),(49,1,1,'135',10,'2015',NULL),(50,1,1,'135',10,'2016',NULL),(51,1,1,'135',10,'2017',NULL),(52,1,1,'142',10,'2018',NULL),(53,1,1,'142',10,'2019',NULL),(54,1,1,'140',10,'2020',NULL),(55,2,1,'140',10,'2010',NULL),(56,2,1,'142',10,'2011',NULL),(57,2,1,'135',10,'2012',NULL),(58,2,1,'150',10,'2013',NULL),(59,2,1,'151',10,'2013',NULL),(60,2,1,'150',10,'2014',NULL),(61,2,1,'140',10,'2015',NULL),(62,2,1,'135',10,'2016',NULL),(63,2,1,'130',10,'2017',NULL),(64,2,1,'135',10,'2018',NULL),(65,2,1,'130',10,'2019',NULL),(66,2,1,'136',10,'2020',NULL),(67,1,2,'136',10,'2010',NULL),(68,1,2,'131',10,'2011',NULL),(69,1,2,'111',10,'2012',NULL),(70,1,2,'121',10,'2013',NULL),(71,1,2,'151',10,'2014',NULL),(72,1,2,'111',10,'2015',NULL),(73,1,2,'141',10,'2016',NULL),(74,1,2,'121',10,'2017',NULL),(75,1,2,'110',10,'2018',NULL),(76,1,2,'125',10,'2019',NULL),(77,1,2,'150',10,'2020',NULL),(87,2,2,'135',10,'2010',NULL),(88,2,2,'150',10,'2011',NULL),(89,2,2,'115',10,'2012',NULL),(90,2,2,'150',10,'2013',NULL),(91,2,2,'150',10,'2014',NULL),(92,2,2,'135',10,'2015',NULL),(93,2,2,'150',10,'2016',NULL),(94,2,2,'130',10,'2017',NULL),(95,2,2,'130',10,'2018',NULL),(96,2,2,'110',10,'2019',NULL),(97,2,2,'130',10,'2020',NULL),(266,NULL,NULL,NULL,NULL,NULL,NULL),(267,NULL,NULL,NULL,NULL,NULL,NULL),(268,NULL,NULL,NULL,NULL,NULL,NULL),(269,NULL,NULL,NULL,NULL,NULL,NULL),(270,NULL,NULL,NULL,NULL,NULL,NULL),(271,NULL,NULL,NULL,NULL,NULL,NULL),(272,NULL,NULL,NULL,NULL,NULL,NULL),(273,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `village_metric` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `village_name`
--

DROP TABLE IF EXISTS `village_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `village_name` (
  `id` int(11) NOT NULL,
  `lang_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `local_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `village_sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpm4592aqslf4n8bga6x3n7on3` (`village_sequence`),
  CONSTRAINT `FKpm4592aqslf4n8bga6x3n7on3` FOREIGN KEY (`village_sequence`) REFERENCES `village` (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `village_name`
--

LOCK TABLES `village_name` WRITE;
/*!40000 ALTER TABLE `village_name` DISABLE KEYS */;
INSERT INTO `village_name` VALUES (11,'en','Narimon',10),(12,'uz','Наримон',10);
/*!40000 ALTER TABLE `village_name` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-20  4:53:13

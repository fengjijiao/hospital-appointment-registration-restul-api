-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: 111.2.178.227    Database: laokai
-- ------------------------------------------------------
-- Server version	5.5.5-10.3.32-MariaDB-0ubuntu0.20.04.1

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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `department_id` int(10) unsigned NOT NULL COMMENT '科室ID',
  `time` int(16) unsigned NOT NULL COMMENT '预约时间',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户ID',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `add_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '入库时间',
  `doctor_id` int(10) unsigned NOT NULL COMMENT '医生ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `appointment_department_id_IDX` (`department_id`,`time`,`doctor_id`,`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (3,2,1643100600,3,0,'2022-01-24 09:14:37',3);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'DID',
  `hospital_id` int(10) unsigned NOT NULL COMMENT 'HID',
  `department_name` varchar(30) NOT NULL COMMENT '科室名',
  `parent_id` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '父DID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,2,'内科',0),(2,2,'内分泌科',1),(3,2,'内消化科',1),(4,2,'中医科',1),(5,2,'感染科',1),(6,2,'外科',0),(7,2,'骨一',6),(8,2,'疼痛科',6),(9,2,'普通外科',6),(10,2,'骨二科',6),(11,2,'普外科',6);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `doctor_name` varchar(18) NOT NULL COMMENT '医生姓名',
  `doctor_sex` varchar(3) NOT NULL DEFAULT '女',
  `department_id` int(10) unsigned NOT NULL COMMENT 'DID',
  `doctor_job_title` tinyint(4) NOT NULL DEFAULT 0 COMMENT '医生职称',
  `doctor_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '医生状态，0:正常;1:~',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'蒋洋','男',2,0,0),(2,'祁言','男',2,1,0),(3,'胥若','女',2,0,0),(4,'于之','男',4,2,0),(5,'丁娴','女',7,0,0),(6,'古秀','女',5,0,0),(7,'宋巧柔','女',3,2,0),(8,'石建红','女',3,0,0),(9,'欧阳进','男',4,0,0),(10,'孟聪婉','女',7,0,0);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'HID',
  `hospital_name` varchar(100) NOT NULL,
  `hospital_contact` varchar(19) NOT NULL COMMENT '联系电话',
  `hospital_level` varchar(9) NOT NULL DEFAULT '一级甲等',
  `hospital_branch_type` tinyint(4) NOT NULL DEFAULT 1 COMMENT '分支类型，1:总院;2:分院',
  `hospital_introduction` varchar(120) NOT NULL DEFAULT '这里是医院介绍',
  `hospital_parent_id` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '总院ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (1,'医科大附一','19000','三级甲等',1,'福建医科大学附属第一医院',0),(2,'附一茶亭园区','19002','三级甲等',2,'福建医科大学附属第一医院分院',1),(3,'附一冰海园区','19004','三级甲等',2,'福建医科大学附属第一医院分院',1),(4,'附一奥体园区','19006','三级甲等',2,'福建医科大学附属第一医院分院',1),(5,'LK医院','19992','二级甲等',1,'这里是医院介绍',0);
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'UID',
  `user_name` varchar(18) NOT NULL,
  `user_age` tinyint(4) NOT NULL DEFAULT 0,
  `mobile` varchar(16) DEFAULT NULL,
  `sex` varchar(3) NOT NULL DEFAULT '女',
  `id_card_no` varchar(19) DEFAULT NULL,
  `open_id` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'张三',1,'10086','男','#0001',''),(2,'李四',2,'11000','男','#0002',''),(3,'王五',3,'12333','女','#0003',''),(4,'锴老弟',4,'10000','男','#0004','');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheduling`
--

DROP TABLE IF EXISTS `scheduling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scheduling` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `department_id` int(10) unsigned NOT NULL COMMENT '科室ID',
  `date` date NOT NULL COMMENT '排班日期',
  `start_time` time NOT NULL COMMENT '开始时间',
  `end_time` time NOT NULL COMMENT '结束时间',
  `add_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '入库时间',
  `scheduling_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '排班状态，0:未完成;1:已完成',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk COMMENT='排班';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheduling`
--

LOCK TABLES `scheduling` WRITE;
/*!40000 ALTER TABLE `scheduling` DISABLE KEYS */;
INSERT INTO `scheduling` VALUES (1,2,'2022-01-27','13:00:00','17:00:00','2022-01-21 16:02:50',0),(2,7,'2022-01-27','14:00:00','17:00:00','2022-01-21 16:02:50',0),(3,2,'2022-01-28','09:00:00','11:30:00','2022-01-21 16:03:28',0),(4,2,'2022-01-28','13:00:00','17:00:00','2022-01-21 16:03:28',0);
/*!40000 ALTER TABLE `scheduling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheduling_stuff`
--

DROP TABLE IF EXISTS `scheduling_stuff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scheduling_stuff` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `doctor_id` int(10) unsigned NOT NULL COMMENT '医生ID',
  `scheduling_id` int(10) unsigned NOT NULL COMMENT '排班ID',
  `start_time` time NOT NULL COMMENT '开始时间',
  `end_time` time NOT NULL COMMENT '结束时间',
  `add_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '入库时间',
  `department_id` int(10) unsigned NOT NULL COMMENT '科室ID',
  `date` date NOT NULL COMMENT '排班日期',
  `scheduling_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '排班状态，0:未完成;1:已完成',
  PRIMARY KEY (`id`),
  UNIQUE KEY `scheduling_stuff_department_id_IDX` (`department_id`,`doctor_id`,`scheduling_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=320 DEFAULT CHARSET=gbk COMMENT='排班员工';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheduling_stuff`
--

LOCK TABLES `scheduling_stuff` WRITE;
/*!40000 ALTER TABLE `scheduling_stuff` DISABLE KEYS */;
INSERT INTO `scheduling_stuff` VALUES (309,1,1,'13:00:00','17:00:00','2022-01-26 17:36:08',2,'2022-01-23',0),(310,2,1,'13:00:00','17:00:00','2022-01-26 17:36:08',2,'2022-01-23',0),(311,3,1,'13:00:00','17:00:00','2022-01-26 17:36:08',2,'2022-01-23',0),(312,5,2,'14:00:00','17:00:00','2022-01-26 17:36:08',7,'2022-01-24',0),(313,10,2,'14:00:00','17:00:00','2022-01-26 17:36:08',7,'2022-01-24',0),(314,1,3,'09:00:00','11:30:00','2022-01-26 17:36:08',2,'2022-01-25',0),(315,2,3,'09:00:00','11:30:00','2022-01-26 17:36:08',2,'2022-01-25',0),(316,3,3,'09:00:00','11:30:00','2022-01-26 17:36:08',2,'2022-01-25',0),(317,1,4,'13:00:00','17:00:00','2022-01-26 17:36:08',2,'2022-01-25',0),(318,2,4,'13:00:00','17:00:00','2022-01-26 17:36:08',2,'2022-01-25',0),(319,3,4,'13:00:00','17:00:00','2022-01-26 17:36:08',2,'2022-01-25',0);
/*!40000 ALTER TABLE `scheduling_stuff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'laokai'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-26 17:44:34

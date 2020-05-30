-- MySQL dump 10.13  Distrib 5.7.29, for osx10.13 (x86_64)
--
-- Host: localhost    Database: csslDB
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `arrange`
--

DROP TABLE IF EXISTS `arrange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arrange` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '时间安排编号',
  `lab_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实验室编号',
  `pro_id` int(11) DEFAULT NULL COMMENT '项目编号',
  `tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '教师编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程编号',
  `lab_class` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实验室类型',
  `lab_remark` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '实验室备注',
  `exp_proname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '实验名称',
  `campus` char(8) DEFAULT NULL COMMENT '校区',
  `status` varchar(12) DEFAULT NULL COMMENT '审核状态',
  PRIMARY KEY (`aid`),
  KEY `fk_relationship_12` (`lab_id`) USING BTREE,
  KEY `fk_relationship_13` (`pro_id`) USING BTREE,
  KEY `fk_relationship_14` (`tid`,`course_id`) USING BTREE,
  KEY `tid` (`tid`),
  KEY `aid` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='实验时间安排';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arrange`
--

LOCK TABLES `arrange` WRITE;
/*!40000 ALTER TABLE `arrange` DISABLE KEYS */;
INSERT INTO `arrange` VALUES (1,'B01406',1,'256740953460',17015054,'17级3、4班','无','实验','双福校区','PASS'),(3,'60201',3,'123',14211829,'计算机1班-计算机2班','无','python语言','南岸校区','AUDITING'),(4,'B01406',13,'123',14210187,'计算机3班-计算机4班','无','上机','双福校区','PASS'),(5,'60201',18,'123',14210669,'曙光班','无','汇编上机','南岸校区','PASS'),(7,'60201',3,'123',14211829,'计算机1班','无','python语言','双福校区','AUDITING'),(8,'60201',22,'123',14211374,'计算机1班','123','移动app开发','双福校区','AUDITING'),(9,'60201',23,'123',17015054,'计算机1班','123','上机实验','双福校区','AUDITING'),(10,'60201',24,'123',17015184,'计算机1班','123','大数据概论实验','双福校区','AUDITING'),(11,'B01406',25,'344847034079',14210669,'计算机2班','无','实验课程名','双福校区','AUDITING'),(12,'B01406',26,'344847034079',14211346,'计算机2班','无','实验课程名','双福校区','AUDITING'),(13,'B01406',27,'344847034079',14211374,'计算机2班','无','实验课程名','双福校区','AUDITING'),(14,'B01406',28,'344847034079',14211829,'计算机2班','无','实验课程名','双福校区','AUDITING'),(15,'B01406',29,'344847034079',14212048,'计算机4班','无','实验课程名','双福校区','AUDITING');
/*!40000 ALTER TABLE `arrange` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arrange_period`
--

DROP TABLE IF EXISTS `arrange_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arrange_period` (
  `aid` int(11) NOT NULL,
  `lab_week` int(11) NOT NULL,
  `lab_day` int(11) NOT NULL,
  `lab_session` int(11) NOT NULL,
  PRIMARY KEY (`aid`,`lab_week`,`lab_day`,`lab_session`),
  CONSTRAINT `aid` FOREIGN KEY (`aid`) REFERENCES `arrange` (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arrange_period`
--

LOCK TABLES `arrange_period` WRITE;
/*!40000 ALTER TABLE `arrange_period` DISABLE KEYS */;
INSERT INTO `arrange_period` VALUES (1,2,1,1),(1,2,1,2),(1,3,1,1),(1,4,1,1),(1,4,1,3),(1,6,1,1),(3,1,3,3),(3,2,3,3),(3,3,3,3),(3,4,3,3),(3,5,3,3),(3,6,3,3),(3,7,3,3),(3,8,3,3),(3,9,3,3),(3,10,3,3),(3,11,3,3),(3,12,3,3),(3,13,3,3),(3,14,3,3),(3,15,3,3),(3,16,3,3),(3,17,3,3),(3,18,3,3),(3,19,3,3),(3,20,3,3),(4,1,1,3),(4,1,5,3),(4,2,1,3),(4,2,5,3),(4,3,1,3),(4,3,5,3),(4,4,1,3),(4,4,5,3),(4,5,1,3),(4,5,5,3),(4,6,1,3),(4,6,5,3),(4,7,1,3),(4,7,5,3),(4,8,1,3),(4,8,5,3),(4,9,1,3),(4,9,5,3),(4,10,1,3),(4,10,5,3),(4,11,1,3),(4,11,5,3),(4,12,1,3),(4,12,5,3),(4,13,1,3),(4,13,5,3),(4,14,1,3),(4,14,5,3),(4,15,1,3),(4,15,5,3),(4,16,1,3),(4,16,5,3),(4,17,1,3),(4,17,5,3),(4,18,1,3),(4,18,5,3),(4,19,1,3),(4,19,5,3),(4,20,1,3),(4,20,5,3),(5,1,4,1),(5,2,4,1),(5,3,4,1),(5,4,4,1),(5,5,4,1),(5,6,4,1),(5,7,4,1),(5,8,4,1),(5,9,4,1),(5,10,4,1),(5,11,4,1),(5,12,4,1),(5,13,4,1),(5,14,4,1),(5,15,4,1),(5,16,4,1),(5,17,4,1),(5,18,4,1),(5,19,4,1),(5,20,4,1),(8,1,1,1),(9,1,1,1),(10,1,1,1),(11,2,4,1),(12,2,4,4),(13,3,4,4),(14,3,4,5),(15,3,6,3);
/*!40000 ALTER TABLE `arrange_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `class_name` varchar(16) NOT NULL,
  `major_id` int(11) NOT NULL,
  `class_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_name`,`major_id`) USING BTREE,
  KEY `fk_relationship_8` (`major_id`) USING BTREE,
  CONSTRAINT `fk_relationship_8` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES ('17级1班',456,35),('17级1班',789,35),('17级2班',456,29),('17级3班',123,29),('17级4班',123,30);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(32) NOT NULL,
  `course_college` varchar(32) NOT NULL,
  `course_type` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (14210118,'RFID原理与应用','信息科学与工程','必修'),(14210187,'操作系统原理A','信息科学与工程','必修'),(14210240,'传感器原理及应用','信息科学与工程','必修'),(14210669,'汇编与计算机组成原理','信息科学与工程','必修'),(14210749,'计算机网络原理','信息科学与工程','必修'),(14211006,'嵌入式系统基础B','信息科学与工程','必修'),(14211165,'数字信号处理B','信息科学与工程','必修'),(14211209,'通信原理A','信息科学与工程','必修'),(14211245,'网络软件与设计','信息科学与工程','必修'),(14211346,'信息论与编码B','信息科学与工程','必修'),(14211374,'移动互联APP','信息科学与工程','必修'),(14211829,'程序设计方法学','信息科学与工程','必修'),(14212048,'电子技术课外实践','信息科学与工程','必修'),(14212067,'多媒体技术','信息科学与工程','必修'),(14212213,'工程实训（通信工程）','信息科学与工程','必修'),(14212214,'工程实训（物联网工程）','信息科学与工程','必修'),(14212831,'嵌入式系统基础A','信息科学与工程','必修'),(14212966,'数据库原理','信息科学与工程','必修'),(14213065,'通信技术实践','信息科学与工程','必修'),(14213068,'通信网规划与设计','信息科学与工程','必修'),(14213072,'通信原理B','信息科学与工程','必修'),(17015054,'高级语言程序设计','信息科学与工程','必修'),(17015062,'轨道信号系统与设备基础','信息科学与工程','必修'),(17015184,'大数据概论','信息科学与工程','必修'),(17015187,'数据导入与预处理技术','信息科学与工程','必修'),(18210145,'高级语言程序设计A','信息科学与工程','必修'),(18210161,'计算思维综合实践I','信息科学与工程','必修'),(18210177,'高级语言程序设计B','信息科学与工程','必修'),(19210322,'数据结构A','信息科学与工程','必修'),(19210916,'信号与系统','信息科学与工程','必修'),(19211634,'大数据开发语言','信息科学与工程','必修'),(19211825,'计算思维综合实践I','信息科学与工程','必修'),(19212095,'数字电路','信息科学与工程','必修'),(19212099,'数据库技术','信息科学与工程','必修'),(19212413,'Java编程能力强化提升','信息科学与工程','必修'),(19212769,'基于FPGA的SOC设计','信息科学与工程','必修');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exp_project`
--

DROP TABLE IF EXISTS `exp_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exp_project` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `lab_cen_name` varchar(64) NOT NULL DEFAULT '信息技术实践教学中心',
  `exp_cname` varchar(32) NOT NULL,
  `exp_eqname` varchar(16) DEFAULT NULL,
  `eqnum` int(11) DEFAULT NULL,
  `exp_major` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '计算机科学与技术',
  `ssort` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '本科生',
  `exp_time` int(11) NOT NULL,
  `book` varchar(128) DEFAULT NULL,
  `software` varchar(32) DEFAULT NULL,
  `exp_tid` char(12) NOT NULL,
  `status` varchar(12) DEFAULT NULL,
  `lab_status` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cname` varchar(32) NOT NULL,
  `con_name` varchar(16) DEFAULT NULL,
  `con_num` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`pro_id`) USING BTREE,
  KEY `cid` (`course_id`),
  CONSTRAINT `cid` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exp_project`
--

LOCK TABLES `exp_project` WRITE;
/*!40000 ALTER TABLE `exp_project` DISABLE KEYS */;
INSERT INTO `exp_project` VALUES (1,'信息技术实践教学中心','java程序设计EB','计算机',40,'计算机科学与技术','本科生',32,'《Java语言程序设计》，辛运帏，饶一梅，人民邮电出版社，2009  ','eclipse，SQL Server, jdk','256740953460','PASS','UNCHECK','java程序设计','无',2,18210177),(3,'信息技术实践教学中心','python语言','计算机',40,'计算机科学与技术','本科生',45,'《数据预处理》','python','123','PASS','UNCHECK','python','无',2,14211829),(13,'信息技术实践教学中心','上机','设备',1,'计算机科学与技术','本科生',40,'教材','软件','123','PASS','AUDITING','操作系统原理A','材料',1,14210187),(18,'信息技术实践教学中心','汇编上机','计算机',50,'计算机科学与技术','本科生',30,'教材','软件','123','PASS','UNCHECK','汇编与计算机组成原理','材料',10,14210669),(22,'信息技术实践教学中心','移动app开发','计算机',40,'计算机科学与技术','本科生',30,'教材无','android studio','123','PASS','AUDITING','移动互联APP','无',0,14211374),(23,'信息技术实践教学中心','上机实验','计算机',40,'计算机科学与技术','本科生',24,'教材1','vs','123','PASS','AUDITING','高级语言程序设计','无',0,17015054),(24,'信息技术实践教学中心','大数据概论实验','计算机',40,'计算机科学与技术','本科生',40,'实验教材','实验所用软件','123','PASS','AUDITING','大数据概论','无',0,17015184),(25,'信息技术实践教学中心','实验课程名','计算机',0,'计算机科学与技术','本科生',40,'实验教材','实验所用软件','344847034079','PASS','AUDITING','汇编与计算机组成原理','无',0,14210669),(26,'信息技术实践教学中心','实验课程名','计算机',0,'计算机科学与技术','本科生',40,'实验教材','实验所用软件','344847034079','PASS','AUDITING','信息论与编码B','无',0,14211346),(27,'信息技术实践教学中心','实验课程名','计算机',0,'计算机科学与技术','本科生',40,'实验教材','实验所用软件','344847034079','PASS','AUDITING','移动互联APP','无',0,14211374),(28,'信息技术实践教学中心','实验课程名','计算机',0,'计算机科学与技术','本科生',40,'实验教材','实验所用软件','344847034079','PASS','AUDITING','程序设计方法学','无',0,14211829),(29,'信息技术实践教学中心','实验课程名','计算机',0,'计算机科学与技术','本科生',40,'实验教材','实验所用软件','344847034079','PASS','AUDITING','电子技术课外实践','无',0,14212048);
/*!40000 ALTER TABLE `exp_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_arrange_backup`
--

DROP TABLE IF EXISTS `lab_arrange_backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lab_arrange_backup` (
  `lab_week` int(11) NOT NULL,
  `lab_day` int(11) NOT NULL,
  `lab_session` varchar(16) NOT NULL,
  `lab_id` varchar(16) NOT NULL,
  `pro_id` int(11) DEFAULT NULL,
  `tid` char(12) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `lab_class` varchar(128) NOT NULL,
  `lab_remark` varchar(8) NOT NULL,
  `exp_proname` varchar(32) NOT NULL,
  PRIMARY KEY (`lab_week`,`lab_day`,`lab_session`,`lab_id`) USING BTREE,
  KEY `fk_relationship_12` (`lab_id`) USING BTREE,
  KEY `fk_relationship_13` (`pro_id`) USING BTREE,
  KEY `fk_relationship_14` (`tid`,`course_id`) USING BTREE,
  CONSTRAINT `Relationship_12` FOREIGN KEY (`lab_id`) REFERENCES `lab_info` (`lab_id`),
  CONSTRAINT `fk_relationship_14` FOREIGN KEY (`tid`, `course_id`) REFERENCES `teach` (`tid`, `course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_arrange_backup`
--

LOCK TABLES `lab_arrange_backup` WRITE;
/*!40000 ALTER TABLE `lab_arrange_backup` DISABLE KEYS */;
INSERT INTO `lab_arrange_backup` VALUES (2,1,'1-2节','60202',1,'256740953460',17015054,'17级3、4班','','实验1'),(2,1,'3-4节','60202',1,'256740953460',17015054,'17级3、4班','实验','实验1'),(3,1,'1-2节','60202',1,'256740953460',17015054,'17级3、4班','','实验2'),(4,1,'1-2节','60202',1,'256740953460',17015054,'17级3、4班','','实验3'),(4,1,'5-6节','60202',1,'256740953460',17015054,'17级3、4班','','实验4'),(6,1,'1-2节','60202',1,'256740953460',17015054,'17级3、4班','','实验4');
/*!40000 ALTER TABLE `lab_arrange_backup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_info`
--

DROP TABLE IF EXISTS `lab_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lab_info` (
  `lab_id` varchar(16) NOT NULL,
  `tid` char(12) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `lab_name` varchar(64) NOT NULL,
  `lab_campus` char(4) NOT NULL,
  `lab_cap` int(11) NOT NULL,
  `lab_area` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`lab_id`) USING BTREE,
  KEY `fk_relationship_4` (`type_id`) USING BTREE,
  KEY `fk_lab_mange` (`tid`) USING BTREE,
  CONSTRAINT `fk_lab_mange` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`),
  CONSTRAINT `fk_relationship_4` FOREIGN KEY (`type_id`) REFERENCES `lab_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_info`
--

LOCK TABLES `lab_info` WRITE;
/*!40000 ALTER TABLE `lab_info` DISABLE KEYS */;
INSERT INTO `lab_info` VALUES ('60101','344847034079',123,'软件开放实验室','南岸',70,100.00),('60102',NULL,NULL,'嵌入式系统实验室','南岸',70,50.00),('60103',NULL,NULL,'硬件开放实验室','南岸',70,140.00),('60104',NULL,NULL,'通信技术实验室','南岸',70,140.00),('60105',NULL,NULL,'网络技术实验室','南岸',70,140.00),('60201',NULL,NULL,'轨道交通实验室','南岸',70,100.00),('60202','256740953460',456,'计算机联锁实验室','南岸',70,100.00),('60203',NULL,NULL,'实验教师办公室','南岸',70,20.00),('60204',NULL,NULL,'实验教师办公室','南岸',70,20.00),('60205',NULL,NULL,'物联网工程实验室','南岸',70,100.00),('60206',NULL,NULL,'物联网技术实验室','南岸',70,40.00),('60207',NULL,NULL,'交通综合信息与指挥控制创新平台','南岸',70,120.00),('60801',NULL,NULL,'计算机软件实验室','南岸',70,210.00),('B01401',NULL,NULL,'实验教师办公室','双福',70,20.00),('B01402',NULL,NULL,'软件设计实践开放实验室','双福',70,40.00),('B01406',NULL,NULL,'信号与系统/EDA实验室','双福',70,45.00),('B01407',NULL,NULL,'计算机软件实验室','双福',70,100.00),('B01408',NULL,NULL,'硬件设计实践开放实验室','双福',70,45.00),('B01409',NULL,NULL,'计算机软件实验室','双福',70,100.00),('B01410',NULL,NULL,'软件类设计实践开放实验室','双福',70,45.00);
/*!40000 ALTER TABLE `lab_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_type`
--

DROP TABLE IF EXISTS `lab_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lab_type` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(16) NOT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_type`
--

LOCK TABLES `lab_type` WRITE;
/*!40000 ALTER TABLE `lab_type` DISABLE KEYS */;
INSERT INTO `lab_type` VALUES (123,'电子实验室'),(456,'计算机实验室');
/*!40000 ALTER TABLE `lab_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `major` (
  `major_id` int(11) NOT NULL,
  `major_name` varchar(32) NOT NULL,
  PRIMARY KEY (`major_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (123,'计算机科学与技术'),(456,'物联网工程'),(666,'计算机大类'),(789,'电信类');
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_item`
--

DROP TABLE IF EXISTS `project_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_item` (
  `ino` int(11) NOT NULL AUTO_INCREMENT,
  `iid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pro_id` int(11) NOT NULL,
  `iname` varchar(32) NOT NULL,
  `itype` varchar(8) NOT NULL,
  `itime` int(11) NOT NULL,
  `ctype` char(4) NOT NULL,
  `num` int(11) NOT NULL,
  `intend` varchar(256) NOT NULL,
  PRIMARY KEY (`ino`) USING BTREE,
  KEY `fk_relationship_5` (`pro_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_item`
--

LOCK TABLES `project_item` WRITE;
/*!40000 ALTER TABLE `project_item` DISABLE KEYS */;
INSERT INTO `project_item` VALUES (1,'XX11058-001',1,'实验1','验证',2,'必修',1,'熟悉JDK的安装和配置；熟悉Java IDE开发环境的安装；学习利用JDK和IDE开发工具编写简单的Java程序，熟悉Java程序的编写、编译和运行过程。'),(2,'XX11058-002',1,'实验2','验证',2,'必修',1,'理解面向过程和面向对象；学会查阅JDK API文档；在类的方法中熟练使用三种基本控制结构'),(3,'XX11058-003',1,'实验3','验证',2,'必修',1,'熟悉Java数组的定义、初始化和使用；掌握类的定义、创建对象；掌握方法的定义、重载；理解成员变量和局部变量。'),(4,'XX11058-004',1,'实验4','验证',4,'必修',1,'熟练掌握构造器的定义和重载；熟练掌握类的继承；熟练使用访问控制符实现所需的封装要求；熟练掌握多态。'),(5,'XX11058-005',1,'实验5','综合',4,'必修',1,'理解抽象的内涵，掌握抽象方法和抽象类的定义和使用；理解接口的内涵，掌握接口的定义和使用；掌握Java类库中基本类的使用。'),(6,'XX11058-006',3,'实验4','验证',4,'必修',1,'熟练掌握构造器的定义和重载；熟练掌握类的继承；熟练使用访问控制符实现所需的封装要求；熟练掌握多态。'),(7,'XX11058-007',3,'实验5','综合',4,'必修',1,'理解抽象的内涵，掌握抽象方法和抽象类的定义和使用；理解接口的内涵，掌握接口的定义和使用；掌握Java类库中基本类的使用。'),(8,'xx123-1',13,'item1','验证',11,'必修',1,'目的1'),(9,'xx123-2',13,'item2','综合',21,'选修',2,'目的2'),(15,'xxx11-001',18,'item1','综合',2,'选修',5,'目的1'),(16,'xxx11-002',18,'item2','验证',2,'选修',5,'目的2'),(17,'xxx11-003',18,'item3','验证',2,'选修',5,'目的2'),(21,'xxx-101',22,'控件','验证',4,'必修',1,'控件使用'),(22,'xxx-102',22,'布局','验证',4,'必修',1,'布局使用'),(23,'xxx-104',22,'网络','验证',4,'必修',1,'网络使用'),(24,'xxx-1-1',23,'实验项目1','验证',4,'必修',1,'目的1'),(25,'xxx-1-2',23,'实验项目2','综合',4,'必修',1,'目的1'),(26,'xxx-1-3',23,'实验项目3','验证',4,'必修',1,'目的1'),(27,'xxx-1-4',23,'实验项目4','综合',4,'必修',1,'目的1'),(28,'xxx-1-5',23,'实验项目5','验证',4,'必修',1,'目的1'),(29,'xxx-1-6',23,'实验项目6','综合',4,'必修',1,'目的1'),(30,'xxx-1-7',23,'实验项目7','验证',4,'必修',1,'目的1'),(31,'xx1',24,'实验项目名称','验证',4,'必修',5,'实验目的'),(32,'xx2',24,'实验项目名称','验证',4,'必修',5,'实验目的'),(33,'xxxxx1',25,'实验项目名称','验证',5,'必修',4,'实验目的'),(34,'xxxxx2',25,'实验项目名称','验证',5,'必修',4,'实验目的'),(35,'xxxxx1',26,'实验项目名称','验证',5,'必修',4,'实验目的'),(36,'xxxxx2',26,'实验项目名称','验证',5,'必修',4,'实验目的'),(37,'xxxxx1',27,'实验项目名称','验证',5,'必修',4,'实验目的'),(38,'xxxxx2',27,'实验项目名称','验证',5,'必修',4,'实验目的'),(39,'xxxxx1',28,'实验项目名称','验证',5,'必修',4,'实验目的'),(40,'xxxxx2',28,'实验项目名称','验证',5,'必修',4,'实验目的'),(41,'xxxxx1',29,'实验项目名称','验证',5,'必修',4,'实验目的'),(42,'xxxxx2',29,'实验项目名称','验证',5,'必修',4,'实验目的');
/*!40000 ALTER TABLE `project_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach`
--

DROP TABLE IF EXISTS `teach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach` (
  `tid` char(12) NOT NULL,
  `course_id` int(11) NOT NULL,
  `apply_limit` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`tid`,`course_id`) USING BTREE,
  KEY `fk_relationship_7` (`course_id`) USING BTREE,
  CONSTRAINT `fk_relationship_6` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`),
  CONSTRAINT `fk_relationship_7` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach`
--

LOCK TABLES `teach` WRITE;
/*!40000 ALTER TABLE `teach` DISABLE KEYS */;
INSERT INTO `teach` VALUES ('123',14210187,0),('123',14210669,0),('123',14211374,0),('123',17015054,0),('123',17015184,0),('256740953460',17015054,0),('256740953460',18210177,0),('344847034079',14210669,0),('344847034079',14211346,0),('344847034079',14211374,0),('344847034079',14211829,0),('344847034079',14212048,0),('529144083628',14210187,0),('529144083628',14212067,0),('529144083628',14212213,0),('529144083628',14212214,0),('529144083628',14212831,0),('529144083628',14212966,0),('768326701984',14213068,0),('768326701984',14213072,0),('768326701984',17015054,0),('768326701984',17015062,0),('768326701984',17015184,0),('768326701984',19210322,0),('768326701984',19210916,0),('773194542654',14211374,0),('773194542654',17015054,0),('773194542654',19211634,0),('773194542654',19211825,0),('773194542654',19212095,0),('773194542654',19212099,0),('773194542654',19212413,0),('773194542654',19212769,0);
/*!40000 ALTER TABLE `teach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachclass`
--

DROP TABLE IF EXISTS `teachclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachclass` (
  `tid` char(12) NOT NULL,
  `course_id` int(11) NOT NULL,
  `class_name` varchar(16) NOT NULL,
  `major_id` int(11) NOT NULL,
  PRIMARY KEY (`tid`,`course_id`,`class_name`,`major_id`) USING BTREE,
  KEY `fk_relationship_10` (`class_name`,`major_id`) USING BTREE,
  CONSTRAINT `fk_relationship_10` FOREIGN KEY (`class_name`, `major_id`) REFERENCES `class` (`class_name`, `major_id`),
  CONSTRAINT `fk_relationship_11` FOREIGN KEY (`tid`, `course_id`) REFERENCES `teach` (`tid`, `course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachclass`
--

LOCK TABLES `teachclass` WRITE;
/*!40000 ALTER TABLE `teachclass` DISABLE KEYS */;
INSERT INTO `teachclass` VALUES ('773194542654',14211374,'17级1班',789),('256740953460',17015054,'17级2班',456),('529144083628',14210187,'17级2班',456),('344847034079',14210669,'17级3班',123),('768326701984',17015184,'17级4班',123),('773194542654',14211374,'17级4班',123);
/*!40000 ALTER TABLE `teachclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `tid` char(12) NOT NULL,
  `tname` varchar(16) NOT NULL,
  `tphone` varchar(16) DEFAULT NULL,
  `tqq` varchar(16) DEFAULT NULL,
  `temail` varchar(32) DEFAULT NULL,
  `tpassword` varchar(16) NOT NULL,
  `authority` varchar(12) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('123','李益才','15123456789','123456789','123456789@qq.com','123','ROLE_USER'),('256740953460','李益才','15123456789','123456789','123456789@qq.com','123456','ROLE_USER'),('344847034079','徐毅','15123456789','123456789','123456789@qq.com','123456','ROLE_USER'),('456','李益才','15123456789','123456789','123456789@qq.com','456','ROLE_ADMIN'),('529144083628','米波','15123456789','123456789','123456789@qq.com','123456','ROLE_USER'),('768326701984','刘君','15123456789','123456789','123456789@qq.com','w4dw8d4a8','ROLE_USER'),('773194542654','陈禾','15123456789','123456789','123456789@qq.com','wad5aw72516','ROLE_USER');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_msg`
--

DROP TABLE IF EXISTS `teacher_msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_msg` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `tid` char(12) NOT NULL,
  `mtitle` varchar(36) NOT NULL,
  `mresult` tinyint(4) NOT NULL,
  `mtext` varchar(255) NOT NULL,
  `mdate` datetime NOT NULL,
  `mstatus` tinyint(4) NOT NULL,
  PRIMARY KEY (`mid`),
  KEY `tid` (`tid`),
  CONSTRAINT `tid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_msg`
--

LOCK TABLES `teacher_msg` WRITE;
/*!40000 ALTER TABLE `teacher_msg` DISABLE KEYS */;
INSERT INTO `teacher_msg` VALUES (23,'123','实验室安排通知',1,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',1),(24,'123','实验室安排通知',0,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',1),(25,'123','实验室安排通知',1,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',0),(26,'123','实验室安排通知',0,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',1),(27,'123','实验室安排通知',1,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',0),(28,'123','实验室安排通知',0,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',1),(29,'123','实验室安排通知',1,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',1),(30,'123','实验室安排通知',0,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',1);
/*!40000 ALTER TABLE `teacher_msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_msg_copy1`
--

DROP TABLE IF EXISTS `teacher_msg_copy1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_msg_copy1` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `tid` char(12) NOT NULL,
  `mtitle` varchar(36) NOT NULL,
  `mresult` tinyint(4) NOT NULL,
  `mtext` varchar(255) NOT NULL,
  `mdate` datetime NOT NULL,
  `mstatus` tinyint(4) NOT NULL,
  PRIMARY KEY (`mid`),
  KEY `tid` (`tid`),
  CONSTRAINT `teacher_msg_copy1_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_msg_copy1`
--

LOCK TABLES `teacher_msg_copy1` WRITE;
/*!40000 ALTER TABLE `teacher_msg_copy1` DISABLE KEYS */;
INSERT INTO `teacher_msg_copy1` VALUES (23,'123','实验室安排通知',1,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',0),(24,'123','实验室安排通知',0,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',1),(25,'123','实验室安排通知',1,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',0),(26,'123','实验室安排通知',0,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',1),(27,'123','实验室安排通知',1,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',0),(28,'123','实验室安排通知',0,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',1),(29,'123','实验室安排通知',1,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',1),(30,'123','实验室安排通知',0,'管理员未通过你关于通信原理实验课的课程安排，请联系管理员','2020-03-24 19:27:25',1);
/*!40000 ALTER TABLE `teacher_msg_copy1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-30 22:17:54

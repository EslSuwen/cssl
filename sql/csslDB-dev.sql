/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : csslDB

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 31/08/2020 12:04:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for arrange
-- ----------------------------
DROP TABLE IF EXISTS `arrange`;
CREATE TABLE `arrange` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '时间安排编号',
  `lab_id` varchar(16) NOT NULL COMMENT '实验室编号',
  `pro_id` int(11) DEFAULT NULL COMMENT '项目编号',
  `tid` char(12) DEFAULT NULL COMMENT '教师编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程编号',
  `lab_class` varchar(128) NOT NULL COMMENT '实验室类型',
  `lab_remark` varchar(8) NOT NULL DEFAULT '' COMMENT '实验室备注',
  `exp_proname` varchar(32) DEFAULT NULL COMMENT '实验名称',
  `campus` char(8) DEFAULT NULL COMMENT '校区',
  PRIMARY KEY (`aid`),
  KEY `fk_relationship_12` (`lab_id`) USING BTREE,
  KEY `fk_relationship_13` (`pro_id`) USING BTREE,
  KEY `fk_relationship_14` (`tid`,`course_id`) USING BTREE,
  KEY `tid` (`tid`),
  KEY `aid` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='实验时间安排';

-- ----------------------------
-- Table structure for arrange_period
-- ----------------------------
DROP TABLE IF EXISTS `arrange_period`;
CREATE TABLE `arrange_period` (
  `aid` int(11) NOT NULL,
  `lab_week` int(11) NOT NULL,
  `lab_day` int(11) NOT NULL,
  `lab_session` int(11) NOT NULL,
  PRIMARY KEY (`aid`,`lab_week`,`lab_day`,`lab_session`),
  CONSTRAINT `aid` FOREIGN KEY (`aid`) REFERENCES `arrange` (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(16) NOT NULL,
  `major_id` int(11) NOT NULL,
  `stu_num` int(4) DEFAULT NULL,
  PRIMARY KEY (`class_id`) USING BTREE,
  KEY `class_major` (`major_id`),
  CONSTRAINT `class_major` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(32) NOT NULL,
  `course_college` varchar(32) NOT NULL,
  `course_type` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for exp_file
-- ----------------------------
DROP TABLE IF EXISTS `exp_file`;
CREATE TABLE `exp_file` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `attend` int(8) DEFAULT NULL,
  `task` int(8) DEFAULT NULL,
  `grade` int(8) DEFAULT NULL,
  `scheme` int(8) DEFAULT NULL,
  `report` int(8) DEFAULT NULL,
  PRIMARY KEY (`pro_id`) USING BTREE,
  CONSTRAINT `pro_id` FOREIGN KEY (`pro_id`) REFERENCES `exp_project` (`pro_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for exp_file_store
-- ----------------------------
DROP TABLE IF EXISTS `exp_file_store`;
CREATE TABLE `exp_file_store` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) NOT NULL,
  `type_name` varchar(12) NOT NULL,
  `name` varchar(64) NOT NULL,
  `file_path` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`no`),
  KEY `file_pro_id` (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for exp_project
-- ----------------------------
DROP TABLE IF EXISTS `exp_project`;
CREATE TABLE `exp_project` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `lab_cen_name` varchar(64) NOT NULL DEFAULT '信息技术实践教学中心',
  `exp_cname` varchar(32) NOT NULL,
  `exp_eqname` varchar(16) DEFAULT NULL,
  `eqnum` int(11) DEFAULT NULL,
  `exp_major` varchar(32) NOT NULL DEFAULT '计算机科学与技术',
  `ssort` varchar(16) NOT NULL DEFAULT '本科生',
  `exp_time` int(11) NOT NULL,
  `book` varchar(128) DEFAULT NULL,
  `software` varchar(32) DEFAULT NULL,
  `exp_tid` char(12) NOT NULL,
  `lab_status` varchar(12) DEFAULT NULL,
  `cname` varchar(32) NOT NULL,
  `con_name` varchar(16) DEFAULT NULL,
  `con_num` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `term` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`pro_id`) USING BTREE,
  KEY `cid` (`course_id`),
  CONSTRAINT `cid` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for lab_info
-- ----------------------------
DROP TABLE IF EXISTS `lab_info`;
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

-- ----------------------------
-- Table structure for lab_type
-- ----------------------------
DROP TABLE IF EXISTS `lab_type`;
CREATE TABLE `lab_type` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(16) NOT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `major_id` int(11) NOT NULL,
  `major_name` varchar(32) NOT NULL,
  `college` varchar(32) NOT NULL,
  PRIMARY KEY (`major_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `nid` int(11) NOT NULL AUTO_INCREMENT COMMENT '通知编号',
  `tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '通知发布人编号',
  `notice_date` datetime DEFAULT NULL COMMENT '通知发布时间',
  `notice_head` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '通知标题',
  `notice_content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '通知正文',
  PRIMARY KEY (`nid`) USING BTREE,
  KEY `tid_key` (`tid`),
  CONSTRAINT `tid_key` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='通知信息表，通知由管理员发布。';

-- ----------------------------
-- Table structure for notice_file
-- ----------------------------
DROP TABLE IF EXISTS `notice_file`;
CREATE TABLE `notice_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通知文件编号',
  `file_name` varchar(64) DEFAULT NULL COMMENT '通知文件名',
  `tid` int(11) DEFAULT NULL COMMENT '通知发布人编号',
  `file_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '通知文件发布时间',
  `file_path` varchar(256) DEFAULT NULL COMMENT '通知文件路径',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='通知文件';

-- ----------------------------
-- Table structure for project_item
-- ----------------------------
DROP TABLE IF EXISTS `project_item`;
CREATE TABLE `project_item` (
  `ino` int(11) NOT NULL AUTO_INCREMENT,
  `iid` varchar(32) NOT NULL,
  `pro_id` int(11) NOT NULL,
  `iname` varchar(32) NOT NULL,
  `itype` varchar(8) NOT NULL,
  `itime` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `intend` varchar(256) NOT NULL,
  PRIMARY KEY (`ino`) USING BTREE,
  KEY `fk_relationship_5` (`pro_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for teach
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach` (
  `tid` char(12) NOT NULL,
  `course_id` int(11) NOT NULL,
  `apply_limit` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`tid`,`course_id`) USING BTREE,
  KEY `fk_relationship_7` (`course_id`) USING BTREE,
  CONSTRAINT `fk_relationship_6` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`),
  CONSTRAINT `fk_relationship_7` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for teachclass
-- ----------------------------
DROP TABLE IF EXISTS `teachclass`;
CREATE TABLE `teachclass` (
  `tid` char(12) NOT NULL,
  `course_id` int(11) NOT NULL,
  `class_name` varchar(16) NOT NULL,
  `major_id` int(11) NOT NULL,
  PRIMARY KEY (`tid`,`course_id`,`class_name`,`major_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
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

-- ----------------------------
-- Table structure for teacher_msg
-- ----------------------------
DROP TABLE IF EXISTS `teacher_msg`;
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for teacher_msg_copy1
-- ----------------------------
DROP TABLE IF EXISTS `teacher_msg_copy1`;
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;

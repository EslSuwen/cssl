/*
 Navicat Premium Data Transfer

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : cssldb-dev

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 25/09/2020 19:06:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for arrange
-- ----------------------------
DROP TABLE IF EXISTS `arrange`;
CREATE TABLE `arrange`  (
  `aid` int NOT NULL AUTO_INCREMENT COMMENT '时间安排编号',
  `lab_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '实验室编号',
  `pro_id` int NULL DEFAULT NULL COMMENT '项目编号',
  `tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师编号',
  `course_id` int NULL DEFAULT NULL COMMENT '课程编号',
  `lab_class` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '实验室类型',
  `lab_remark` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '实验室备注',
  `exp_proname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实验名称',
  `campus` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '校区',
  PRIMARY KEY (`aid`) USING BTREE,
  INDEX `fk_relationship_12`(`lab_id`) USING BTREE,
  INDEX `fk_relationship_13`(`pro_id`) USING BTREE,
  INDEX `fk_relationship_14`(`tid`, `course_id`) USING BTREE,
  INDEX `tid`(`tid`) USING BTREE,
  INDEX `aid`(`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实验时间安排' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for arrange_period
-- ----------------------------
DROP TABLE IF EXISTS `arrange_period`;
CREATE TABLE `arrange_period`  (
  `aid` int NOT NULL,
  `lab_week` int NOT NULL,
  `lab_day` int NOT NULL,
  `lab_session` int NOT NULL,
  PRIMARY KEY (`aid`, `lab_week`, `lab_day`, `lab_session`) USING BTREE,
  CONSTRAINT `aid` FOREIGN KEY (`aid`) REFERENCES `arrange` (`aid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `class_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `major_id` int NOT NULL,
  `student_num` int NULL DEFAULT NULL,
  PRIMARY KEY (`class_id`) USING BTREE,
  INDEX `class_major`(`major_id`) USING BTREE,
  CONSTRAINT `class_major` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int NOT NULL,
  `course_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `course_college` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `course_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for exp_file
-- ----------------------------
DROP TABLE IF EXISTS `exp_file`;
CREATE TABLE `exp_file`  (
  `pro_id` int NOT NULL AUTO_INCREMENT,
  `attend` int NULL DEFAULT NULL,
  `task` int NULL DEFAULT NULL,
  `grade` int NULL DEFAULT NULL,
  `scheme` int NULL DEFAULT NULL,
  `report` int NULL DEFAULT NULL,
  PRIMARY KEY (`pro_id`) USING BTREE,
  CONSTRAINT `pro_id` FOREIGN KEY (`pro_id`) REFERENCES `exp_project` (`pro_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for exp_file_store
-- ----------------------------
DROP TABLE IF EXISTS `exp_file_store`;
CREATE TABLE `exp_file_store`  (
  `no` int NOT NULL AUTO_INCREMENT,
  `pro_id` int NOT NULL,
  `type_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `file_path` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`no`) USING BTREE,
  INDEX `file_pro_id`(`pro_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for exp_project
-- ----------------------------
DROP TABLE IF EXISTS `exp_project`;
CREATE TABLE `exp_project`  (
  `pro_id` int NOT NULL AUTO_INCREMENT,
  `lab_cen_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '信息技术实践教学中心',
  `exp_cname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `exp_eqname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `eqnum` int NULL DEFAULT NULL,
  `exp_major` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '计算机科学与技术',
  `ssort` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '本科生',
  `exp_time` int NOT NULL,
  `book` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `software` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `exp_tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `lab_status` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `con_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `con_num` int NOT NULL,
  `course_id` int NOT NULL,
  `term` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pro_id`) USING BTREE,
  INDEX `cid`(`course_id`) USING BTREE,
  CONSTRAINT `cid` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for lab_arrange_backup
-- ----------------------------
DROP TABLE IF EXISTS `lab_arrange_backup`;
CREATE TABLE `lab_arrange_backup`  (
  `lab_week` int NOT NULL,
  `lab_day` int NOT NULL,
  `lab_session` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `lab_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pro_id` int NULL DEFAULT NULL,
  `tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `course_id` int NULL DEFAULT NULL,
  `lab_class` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `lab_remark` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `exp_proname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`lab_week`, `lab_day`, `lab_session`, `lab_id`) USING BTREE,
  INDEX `fk_relationship_12`(`lab_id`) USING BTREE,
  INDEX `fk_relationship_13`(`pro_id`) USING BTREE,
  INDEX `fk_relationship_14`(`tid`, `course_id`) USING BTREE,
  CONSTRAINT `fk_relationship_14` FOREIGN KEY (`tid`, `course_id`) REFERENCES `teach` (`tid`, `course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Relationship_12` FOREIGN KEY (`lab_id`) REFERENCES `lab_info` (`lab_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for lab_info
-- ----------------------------
DROP TABLE IF EXISTS `lab_info`;
CREATE TABLE `lab_info`  (
  `lab_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type_id` int NULL DEFAULT NULL,
  `lab_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `lab_campus` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `lab_cap` int NOT NULL,
  `lab_area` decimal(5, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`lab_id`) USING BTREE,
  INDEX `fk_relationship_4`(`type_id`) USING BTREE,
  INDEX `fk_lab_mange`(`tid`) USING BTREE,
  CONSTRAINT `fk_lab_mange` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_relationship_4` FOREIGN KEY (`type_id`) REFERENCES `lab_type` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for lab_type
-- ----------------------------
DROP TABLE IF EXISTS `lab_type`;
CREATE TABLE `lab_type`  (
  `type_id` int NOT NULL,
  `type_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `major_id` int NOT NULL,
  `major_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `college` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`major_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `nid` int NOT NULL AUTO_INCREMENT COMMENT '通知编号',
  `tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '通知发布人编号',
  `notice_date` datetime(0) NULL DEFAULT NULL COMMENT '通知发布时间',
  `notice_head` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知标题',
  `notice_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '通知正文',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `tid_key`(`tid`) USING BTREE,
  CONSTRAINT `tid_key` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知信息表，通知由管理员发布。' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for notice_file
-- ----------------------------
DROP TABLE IF EXISTS `notice_file`;
CREATE TABLE `notice_file`  (
  `file_id` int NOT NULL AUTO_INCREMENT COMMENT '通知文件编号',
  `file_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知文件名',
  `tid` int NULL DEFAULT NULL COMMENT '通知发布人编号',
  `file_date` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '通知文件发布时间',
  `file_path` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知文件路径',
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知文件' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for project_item
-- ----------------------------
DROP TABLE IF EXISTS `project_item`;
CREATE TABLE `project_item`  (
  `ino` int NOT NULL AUTO_INCREMENT,
  `iid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pro_id` int NOT NULL,
  `iname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `itype` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `itime` int NOT NULL,
  `num` int NOT NULL,
  `intend` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`ino`) USING BTREE,
  INDEX `fk_relationship_5`(`pro_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for teach
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach`  (
  `tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `course_id` int NOT NULL,
  `apply_limit` tinyint NULL DEFAULT NULL,
  PRIMARY KEY (`tid`, `course_id`) USING BTREE,
  INDEX `fk_relationship_7`(`course_id`) USING BTREE,
  CONSTRAINT `fk_relationship_6` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_relationship_7` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for teach_class
-- ----------------------------
DROP TABLE IF EXISTS `teach_class`;
CREATE TABLE `teach_class`  (
  `tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `course_id` int NOT NULL,
  `class_id` int NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tphone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tqq` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `temail` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tpassword` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `authority` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for teacher_msg
-- ----------------------------
DROP TABLE IF EXISTS `teacher_msg`;
CREATE TABLE `teacher_msg`  (
  `mid` int NOT NULL AUTO_INCREMENT,
  `tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `mtitle` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `mresult` tinyint NOT NULL,
  `mtext` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `mdate` datetime(0) NULL DEFAULT NULL,
  `mstatus` tinyint NOT NULL,
  PRIMARY KEY (`mid`) USING BTREE,
  INDEX `tid`(`tid`) USING BTREE,
  CONSTRAINT `tid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for teacher_msg_copy1
-- ----------------------------
DROP TABLE IF EXISTS `teacher_msg_copy1`;
CREATE TABLE `teacher_msg_copy1`  (
  `mid` int NOT NULL AUTO_INCREMENT,
  `tid` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `mtitle` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `mresult` tinyint NOT NULL,
  `mtext` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `mdate` datetime(0) NULL DEFAULT NULL,
  `mstatus` tinyint NOT NULL,
  PRIMARY KEY (`mid`) USING BTREE,
  INDEX `tid`(`tid`) USING BTREE,
  CONSTRAINT `teacher_msg_copy1_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;

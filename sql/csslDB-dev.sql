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

 Date: 08/10/2020 10:57:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for arrange
-- ----------------------------
DROP TABLE IF EXISTS `arrange`;
CREATE TABLE `arrange`
(
    `aid`         int(0)                                                       NOT NULL AUTO_INCREMENT COMMENT '时间安排编号',
    `lab_id`      varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '实验室编号',
    `pro_id`      int(0)                                                       NULL     DEFAULT NULL COMMENT '项目编号',
    `tid`         char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NULL     DEFAULT NULL COMMENT '教师编号',
    `course_id`   int(0)                                                       NULL     DEFAULT NULL COMMENT '课程编号',
    `lab_remark`  varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '实验室备注',
    `exp_proname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '实验名称',
    `campus`      char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NULL     DEFAULT NULL COMMENT '校区',
    PRIMARY KEY (`aid`) USING BTREE,
    INDEX `fk_relationship_12` (`lab_id`) USING BTREE,
    INDEX `fk_relationship_13` (`pro_id`) USING BTREE,
    INDEX `fk_relationship_14` (`tid`, `course_id`) USING BTREE,
    INDEX `tid` (`tid`) USING BTREE,
    INDEX `aid` (`aid`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 19
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '实验时间安排'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for arrange_class
-- ----------------------------
DROP TABLE IF EXISTS `arrange_class`;
CREATE TABLE `arrange_class`
(
    `aid`      int(0) NOT NULL COMMENT '排课编号',
    `class_id` int(0) NOT NULL COMMENT '班级编号'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '排课班级'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for arrange_period
-- ----------------------------
DROP TABLE IF EXISTS `arrange_period`;
CREATE TABLE `arrange_period`
(
    `aid`         int(0) NOT NULL,
    `lab_week`    int(0) NOT NULL,
    `lab_day`     int(0) NOT NULL,
    `lab_session` int(0) NOT NULL,
    PRIMARY KEY (`aid`, `lab_week`, `lab_day`, `lab_session`) USING BTREE,
    CONSTRAINT `aid` FOREIGN KEY (`aid`) REFERENCES `arrange` (`aid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`
(
    `class_id`    int(0)                                                       NOT NULL AUTO_INCREMENT,
    `grade`       int(0)                                                       NOT NULL,
    `class_name`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `major_id`    int(0)                                                       NOT NULL,
    `student_num` int(0)                                                       NULL DEFAULT NULL,
    PRIMARY KEY (`class_id`) USING BTREE,
    INDEX `class_major` (`major_id`) USING BTREE,
    CONSTRAINT `class_major` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 87487489
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
    `course_id`      int(0)                                                       NOT NULL,
    `course_name`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `course_college` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `course_type`    varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL,
    PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exp_class
-- ----------------------------
DROP TABLE IF EXISTS `exp_class`;
CREATE TABLE `exp_class`
(
    `pro_id`   int(0) NOT NULL COMMENT '项目编号',
    `class_id` int(0) NOT NULL COMMENT '班级编号'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '排课班级'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exp_file
-- ----------------------------
DROP TABLE IF EXISTS `exp_file`;
CREATE TABLE `exp_file`
(
    `pro_id`   int(0) NOT NULL AUTO_INCREMENT,
    `class_id` int(0) NOT NULL,
    `attend`   int(0) NULL DEFAULT NULL,
    `task`     int(0) NULL DEFAULT NULL,
    `grade`    int(0) NULL DEFAULT NULL,
    `scheme`   int(0) NULL DEFAULT NULL,
    `report`   int(0) NULL DEFAULT NULL,
    PRIMARY KEY (`pro_id`, `class_id`) USING BTREE,
    CONSTRAINT `pro_id` FOREIGN KEY (`pro_id`) REFERENCES `exp_project` (`pro_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 31
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exp_file_store
-- ----------------------------
DROP TABLE IF EXISTS `exp_file_store`;
CREATE TABLE `exp_file_store`
(
    `no`        int(0)                                                  NOT NULL AUTO_INCREMENT,
    `type_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `name`      varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `file_path` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`no`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 94
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exp_project
-- ----------------------------
DROP TABLE IF EXISTS `exp_project`;
CREATE TABLE `exp_project`
(
    `pro_id`     int(0)                                                        NOT NULL AUTO_INCREMENT COMMENT '项目编号',
    `exp_cname`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '实验课程名',
    `exp_eqname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '实验设备名',
    `eqnum`      int(0)                                                        NULL DEFAULT NULL COMMENT '设备数量',
    `exp_time`   int(0)                                                        NOT NULL COMMENT '实验总学时',
    `book`       varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实验教材',
    `software`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '实验所用软件',
    `exp_tid`    char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL COMMENT '授课教师编号',
    `lab_status` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '申请实验室状态',
    `con_name`   varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '消耗材料名称',
    `con_num`    int(0)                                                        NOT NULL COMMENT '消耗材料数量',
    `course_id`  int(0)                                                        NOT NULL COMMENT '课程编号',
    `term`       varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '学期',
    PRIMARY KEY (`pro_id`) USING BTREE,
    INDEX `cid` (`course_id`) USING BTREE,
    CONSTRAINT `cid` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 31
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '项目(实验卡片)'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lab_info
-- ----------------------------
DROP TABLE IF EXISTS `lab_info`;
CREATE TABLE `lab_info`
(
    `lab_id`     varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `tid`        char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NULL DEFAULT NULL,
    `type_id`    int(0)                                                       NULL DEFAULT NULL,
    `lab_name`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `lab_campus` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL,
    `lab_cap`    int(0)                                                       NOT NULL,
    `lab_area`   decimal(5, 2)                                                NULL DEFAULT NULL,
    PRIMARY KEY (`lab_id`) USING BTREE,
    INDEX `fk_relationship_4` (`type_id`) USING BTREE,
    INDEX `fk_lab_mange` (`tid`) USING BTREE,
    CONSTRAINT `fk_lab_mange` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_relationship_4` FOREIGN KEY (`type_id`) REFERENCES `lab_type` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lab_type
-- ----------------------------
DROP TABLE IF EXISTS `lab_type`;
CREATE TABLE `lab_type`
(
    `type_id`   int(0)                                                       NOT NULL,
    `type_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`
(
    `major_id`   int(0)                                                       NOT NULL,
    `major_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `college`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    PRIMARY KEY (`major_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`
(
    `nid`            int(0)                                                    NOT NULL AUTO_INCREMENT COMMENT '通知编号',
    `tid`            char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '通知发布人编号',
    `notice_date`    datetime(0)                                               NULL DEFAULT NULL COMMENT '通知发布时间',
    `notice_head`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci    NULL DEFAULT NULL COMMENT '通知标题',
    `notice_content` text CHARACTER SET utf8 COLLATE utf8_general_ci           NULL COMMENT '通知正文',
    PRIMARY KEY (`nid`) USING BTREE,
    INDEX `tid_key` (`tid`) USING BTREE,
    CONSTRAINT `tid_key` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 47
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '通知信息表，通知由管理员发布。'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notice_file
-- ----------------------------
DROP TABLE IF EXISTS `notice_file`;
CREATE TABLE `notice_file`
(
    `file_id`   int(0)                                                  NOT NULL AUTO_INCREMENT COMMENT '通知文件编号',
    `file_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '通知文件名',
    `tid`       int(0)                                                  NULL DEFAULT NULL COMMENT '通知发布人编号',
    `file_date` datetime(0)                                             NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '通知文件发布时间',
    `file_path` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知文件路径',
    PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 20
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '通知文件'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_item
-- ----------------------------
DROP TABLE IF EXISTS `project_item`;
CREATE TABLE `project_item`
(
    `ino`    int(0)                                                        NOT NULL AUTO_INCREMENT,
    `iid`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `pro_id` int(0)                                                        NOT NULL,
    `iname`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `itype`  varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   NOT NULL,
    `itime`  int(0)                                                        NOT NULL,
    `num`    int(0)                                                        NOT NULL,
    `intend` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    PRIMARY KEY (`ino`) USING BTREE,
    INDEX `fk_relationship_5` (`pro_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 45
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teach
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach`
(
    `tid`       char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `course_id` int(0)                                                    NOT NULL,
    PRIMARY KEY (`tid`, `course_id`) USING BTREE,
    INDEX `fk_relationship_7` (`course_id`) USING BTREE,
    CONSTRAINT `fk_relationship_6` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_relationship_7` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teach_class
-- ----------------------------
DROP TABLE IF EXISTS `teach_class`;
CREATE TABLE `teach_class`
(
    `tid`       char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `course_id` int(0)                                                    NOT NULL,
    `class_id`  int(0)                                                    NOT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`
(
    `tid`       char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NOT NULL,
    `tname`     varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `tphone`    varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `tqq`       varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `temail`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `tpassword` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `authority` tinyint(0)                                                   NOT NULL,
    PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher_msg
-- ----------------------------
DROP TABLE IF EXISTS `teacher_msg`;
CREATE TABLE `teacher_msg`
(
    `mid`     int(0)                                                        NOT NULL AUTO_INCREMENT,
    `tid`     char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL,
    `mtitle`  varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `mresult` tinyint(0)                                                    NOT NULL,
    `mtext`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `mdate`   datetime(0)                                                   NULL DEFAULT NULL,
    `mstatus` tinyint(0)                                                    NOT NULL,
    PRIMARY KEY (`mid`) USING BTREE,
    INDEX `tid` (`tid`) USING BTREE,
    CONSTRAINT `tid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 34
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

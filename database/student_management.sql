/*
Navicat MySQL Data Transfer

Source Server         : 192.168.99.233
Source Server Version : 50525
Source Host           : 192.168.99.233:3306
Source Database       : student_management

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2015-11-25 00:12:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gts_comment`
-- ----------------------------
DROP TABLE IF EXISTS `gts_comment`;
CREATE TABLE `gts_comment` (
  `COMMENT_ID` varchar(32) NOT NULL,
  `STUDENT_ID` varchar(32) NOT NULL,
  `COMMENT` varchar(120) NOT NULL,
  `COMMENT_PERSON` varchar(32) NOT NULL,
  `GRADE_STAGE` varchar(32) NOT NULL,
  `GMT_CREATE` date NOT NULL,
  `GMT_MODIFY` date NOT NULL,
  PRIMARY KEY (`COMMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_customer`
-- ----------------------------
DROP TABLE IF EXISTS `gts_customer`;
CREATE TABLE `gts_customer` (
  `CUSTOMER_ID` varchar(32) NOT NULL,
  `NAME` varchar(32) NOT NULL,
  `CERT_TYPE` varchar(12) NOT NULL,
  `CERT_NO` varchar(32) NOT NULL,
  `GMT_CREATE` date NOT NULL,
  `GMT_MODIFY` date NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_customer
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_genearch`
-- ----------------------------
DROP TABLE IF EXISTS `gts_genearch`;
CREATE TABLE `gts_genearch` (
  `GENERACH_ID` varchar(32) NOT NULL,
  `USER_ID` varchar(32) DEFAULT NULL,
  `GMT_CREATE` date DEFAULT NULL,
  `GMT_MODIFY` date DEFAULT NULL,
  PRIMARY KEY (`GENERACH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_genearch
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_genearch_student`
-- ----------------------------
DROP TABLE IF EXISTS `gts_genearch_student`;
CREATE TABLE `gts_genearch_student` (
  `ID` varchar(32) NOT NULL,
  `GENEARCH_ID` varchar(32) NOT NULL,
  `STUDENT_ID` varchar(32) NOT NULL,
  `VALID` char(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_genearch_student
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `gts_login_log`;
CREATE TABLE `gts_login_log` (
  `LOG_ID` varchar(32) NOT NULL,
  `USER_ID` varchar(32) NOT NULL,
  `LOGIN_TIME` date NOT NULL,
  `LOGIN_PLACE` varchar(64) DEFAULT NULL,
  `LOGIN_IP` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_role`
-- ----------------------------
DROP TABLE IF EXISTS `gts_role`;
CREATE TABLE `gts_role` (
  `ROLE_ID` varchar(32) NOT NULL,
  `ROLE_NAME` varchar(32) NOT NULL,
  `PRIVILEGE` varchar(128) DEFAULT NULL,
  `GMT_CREATE` date NOT NULL,
  `GMT_MODIFY` date NOT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_role
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_score`
-- ----------------------------
DROP TABLE IF EXISTS `gts_score`;
CREATE TABLE `gts_score` (
  `SCORE_ID` varchar(32) NOT NULL,
  `STUDENT_ID` varchar(32) NOT NULL,
  `TEACHER_ID` varchar(32) DEFAULT NULL,
  `SUBJECT` varchar(32) NOT NULL,
  `SCORE` varchar(12) NOT NULL,
  `GRADE_STAGE` varchar(20) NOT NULL,
  `GMT_CREATE` date NOT NULL,
  `GMT_MODIFY` date NOT NULL,
  PRIMARY KEY (`SCORE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_score
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_student`
-- ----------------------------
DROP TABLE IF EXISTS `gts_student`;
CREATE TABLE `gts_student` (
  `STUDENT_ID` varchar(32) NOT NULL,
  `USER_ID` varchar(32) NOT NULL,
  `SCHOOL` varchar(64) DEFAULT NULL,
  `MAJOR` varchar(64) DEFAULT NULL,
  `GRADE` varchar(16) DEFAULT NULL,
  `GRADE_STAGE` varchar(16) DEFAULT NULL,
  `CLASSES` varchar(16) DEFAULT NULL,
  `LEVEL` varchar(16) DEFAULT NULL,
  `GMT_CREATE` date NOT NULL,
  `GMT_MODIFY` date NOT NULL,
  PRIMARY KEY (`STUDENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_student
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `gts_teacher`;
CREATE TABLE `gts_teacher` (
  `TEACHER_ID` varchar(32) NOT NULL,
  `USER_ID` varchar(32) NOT NULL,
  `SCHOOL` varchar(64) DEFAULT NULL,
  `MAJOR` varchar(64) DEFAULT NULL,
  `GRADE` varchar(16) DEFAULT NULL,
  `GRADE_STAGE` varchar(16) DEFAULT NULL,
  `CLASSES` varchar(16) DEFAULT NULL,
  `LEVEL` varchar(16) DEFAULT NULL,
  `GMT_CREATE` date NOT NULL,
  `GMT_MODIFY` date NOT NULL,
  PRIMARY KEY (`TEACHER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_teacher_student`
-- ----------------------------
DROP TABLE IF EXISTS `gts_teacher_student`;
CREATE TABLE `gts_teacher_student` (
  `ID` varchar(32) NOT NULL,
  `TEACHER_ID` varchar(32) NOT NULL,
  `STUDENT_ID` varchar(32) NOT NULL,
  `VALID` char(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_teacher_student
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_user`
-- ----------------------------
DROP TABLE IF EXISTS `gts_user`;
CREATE TABLE `gts_user` (
  `USER_ID` varchar(32) NOT NULL,
  `USER_TYPE` varchar(12) NOT NULL,
  `CUSTOMER_ID` varchar(32) DEFAULT NULL,
  `CERT_TYPE` varchar(12) NOT NULL,
  `CERT_NO` varchar(32) NOT NULL,
  `NICK_NAME` varchar(32) DEFAULT NULL,
  `NAME` varchar(32) NOT NULL,
  `AGE` varchar(3) DEFAULT NULL,
  `GENDER` varchar(1) NOT NULL,
  `EMAIL` varchar(64) NOT NULL,
  `PHONE` varchar(20) DEFAULT NULL,
  `MOBILE` varchar(16) NOT NULL,
  `JOB` varchar(22) NOT NULL,
  `ROLE_ID` varchar(32) DEFAULT NULL,
  `PROVINCE` varchar(20) DEFAULT NULL,
  `CITY` varchar(20) DEFAULT NULL,
  `AREA` varchar(30) DEFAULT NULL,
  `ADRESS` varchar(64) DEFAULT NULL,
  `SERCURITY_CODE` varchar(20) DEFAULT NULL,
  `GMT_CREATE` date NOT NULL,
  `GMT_MODIFY` date NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_user
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_user_login_info`
-- ----------------------------
DROP TABLE IF EXISTS `gts_user_login_info`;
CREATE TABLE `gts_user_login_info` (
  `ID` varchar(32) NOT NULL,
  `LOGIN_ID` varchar(64) NOT NULL,
  `USER_ID` varchar(32) NOT NULL,
  `LOGIN_TYPE` varchar(12) NOT NULL,
  `LOGIN_PASSWORD` varchar(64) NOT NULL,
  `USER_TYPE` varchar(12) NOT NULL,
  `LAST_LOGIN_TIME` date DEFAULT NULL,
  `GMT_CREATE` date NOT NULL,
  `GMT_MODIFY` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_user_login_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gts_comment`
-- ----------------------------
DROP TABLE IF EXISTS `gts_comment`;
CREATE TABLE `gts_comment` (
  `COMMENT_ID` int(32) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(32) NOT NULL,
  `COMMENT` varchar(120) NOT NULL,
  `COMMENT_PERSON` varchar(32) NOT NULL,
  `GRADE_STAGE` varchar(32) NOT NULL,
  `GMT_CREATE` datetime NOT NULL,
  `GMT_MODIFY` datetime NOT NULL,
  PRIMARY KEY (`COMMENT_ID`),
  KEY `FK_STU_COMMENT` (`STUDENT_ID`),
  CONSTRAINT `FK_STU_COMMENT` FOREIGN KEY (`STUDENT_ID`) REFERENCES `gts_student` (`STUDENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_genearch`
-- ----------------------------
DROP TABLE IF EXISTS `gts_genearch`;
CREATE TABLE `gts_genearch` (
  `GENERACH_ID` int(32) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(32) NOT NULL,
  `GMT_CREATE` datetime DEFAULT NULL,
  `GMT_MODIFY` datetime DEFAULT NULL,
  PRIMARY KEY (`GENERACH_ID`),
  UNIQUE KEY `INDEX_GENEARCH` (`GENERACH_ID`) USING BTREE,
  KEY `FK_GENEARCH_USER_ID` (`USER_ID`),
  CONSTRAINT `FK_GENEARCH_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `gts_user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_genearch
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_genearch_student`
-- ----------------------------
DROP TABLE IF EXISTS `gts_genearch_student`;
CREATE TABLE `gts_genearch_student` (
  `ID` int(32) NOT NULL AUTO_INCREMENT,
  `GENEARCH_ID` int(32) NOT NULL,
  `STUDENT_ID` int(32) NOT NULL,
  `VALID` char(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_STUGEN_STU` (`STUDENT_ID`),
  KEY `FK_STUGEN_GEN` (`GENEARCH_ID`),
  CONSTRAINT `FK_STUGEN_GEN` FOREIGN KEY (`GENEARCH_ID`) REFERENCES `gts_genearch` (`GENERACH_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_STUGEN_STU` FOREIGN KEY (`STUDENT_ID`) REFERENCES `gts_student` (`STUDENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_genearch_student
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `gts_login_log`;
CREATE TABLE `gts_login_log` (
  `LOG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN_ID` varchar(64) NOT NULL,
  `USER_ID` int(32) NOT NULL,
  `LOGIN_TIME` datetime NOT NULL,
  `LOGIN_PLACE` varchar(64) DEFAULT NULL,
  `LOGIN_IP` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`),
  KEY `INDEX_LOGIN_LOG` (`LOGIN_ID`) USING HASH,
  CONSTRAINT `FK_LOGIN_LOG` FOREIGN KEY (`LOGIN_ID`) REFERENCES `gts_user_login_info` (`LOGIN_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_manager`
-- ----------------------------
DROP TABLE IF EXISTS `gts_manager`;
CREATE TABLE `gts_manager` (
  `MANAGER_ID` int(32) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(32) NOT NULL,
  PRIMARY KEY (`MANAGER_ID`),
  KEY `FK_MANAGER` (`USER_ID`),
  CONSTRAINT `FK_MANAGER` FOREIGN KEY (`USER_ID`) REFERENCES `gts_user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_manager
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_note`
-- ----------------------------
DROP TABLE IF EXISTS `gts_note`;
CREATE TABLE `gts_note` (
  `NOTE_ID` int(32) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(32) NOT NULL,
  `NOTE_NAME` varchar(32) NOT NULL,
  `NOTE_CONTENT` varchar(120) NOT NULL,
  `GMT_CREATE` date NOT NULL,
  `GMT_MODIFY` date NOT NULL,
  PRIMARY KEY (`NOTE_ID`),
  KEY `FK_NOTE` (`USER_ID`),
  CONSTRAINT `FK_NOTE` FOREIGN KEY (`USER_ID`) REFERENCES `gts_user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_note
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_notice`
-- ----------------------------
DROP TABLE IF EXISTS `gts_notice`;
CREATE TABLE `gts_notice` (
  `NOTICE_ID` int(32) NOT NULL AUTO_INCREMENT,
  `NOTICE_TYPE` varchar(12) NOT NULL,
  `NOTICE_TITLE` varchar(32) NOT NULL,
  `NOTICE_CONTENT` varchar(120) NOT NULL,
  `GMT_CREATE` date NOT NULL,
  `GMT_MODIFY` date NOT NULL,
  PRIMARY KEY (`NOTICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_notice
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_pending_item`
-- ----------------------------
DROP TABLE IF EXISTS `gts_pending_item`;
CREATE TABLE `gts_pending_item` (
  `ITEM_ID` int(32) NOT NULL AUTO_INCREMENT,
  `ITEM_NAME` varchar(32) NOT NULL,
  `ITEM_CONTENT` varchar(120) DEFAULT NULL,
  `ITEM_TYPE` varchar(12) NOT NULL,
  `HANDLER_STATUS` varchar(12) NOT NULL,
  `APPLICANT_USER_ID` int(32) NOT NULL,
  `APPLICANT_NAME` varchar(32) NOT NULL,
  `HANDLER_USER_ID` int(32) NOT NULL,
  `HANDLER_NAME` varchar(32) NOT NULL,
  `GMT_CREATE` date NOT NULL,
  `GMT_MODIFY` date NOT NULL,
  PRIMARY KEY (`ITEM_ID`),
  KEY `FK_APP_USERID` (`APPLICANT_USER_ID`),
  KEY `FK_HANDLER_USER_ID` (`HANDLER_USER_ID`),
  CONSTRAINT `FK_APP_USERID` FOREIGN KEY (`APPLICANT_USER_ID`) REFERENCES `gts_user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_HANDLER_USER_ID` FOREIGN KEY (`HANDLER_USER_ID`) REFERENCES `gts_user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_pending_item
-- ----------------------------
INSERT INTO `gts_pending_item` VALUES ('1', '请假', '被强势插入了', 'qingjia', 'S', '1', '躺好', '1', '祥爷', '2015-11-29', '2015-11-29');
INSERT INTO `gts_pending_item` VALUES ('2', '交钱', '欠债还钱', '交钱', 'I', '1', '傻弟弟', '1', '祥爷', '2015-11-29', '2015-11-29');

-- ----------------------------
-- Table structure for `gts_role`
-- ----------------------------
DROP TABLE IF EXISTS `gts_role`;
CREATE TABLE `gts_role` (
  `ROLE_ID` int(32) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(32) NOT NULL,
  `PRIVILEGE` varchar(128) DEFAULT NULL,
  `GMT_CREATE` datetime NOT NULL,
  `GMT_MODIFY` datetime NOT NULL,
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
  `SCORE_ID` int(32) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(32) NOT NULL,
  `TEACHER_ID` int(32) NOT NULL,
  `SUBJECT` varchar(32) NOT NULL,
  `SCORE` varchar(12) NOT NULL,
  `GRADE_STAGE` varchar(20) NOT NULL,
  `GMT_CREATE` datetime NOT NULL,
  `GMT_MODIFY` datetime NOT NULL,
  PRIMARY KEY (`SCORE_ID`),
  KEY `FK_STU_SCORE` (`STUDENT_ID`),
  CONSTRAINT `FK_STU_SCORE` FOREIGN KEY (`STUDENT_ID`) REFERENCES `gts_student` (`STUDENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_score
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_student`
-- ----------------------------
DROP TABLE IF EXISTS `gts_student`;
CREATE TABLE `gts_student` (
  `STUDENT_ID` int(32) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(32) NOT NULL,
  `STUDENT_NO` varchar(32) NOT NULL,
  `SCHOOL` varchar(64) DEFAULT NULL,
  `MAJOR` varchar(64) DEFAULT NULL,
  `GRADE` varchar(16) DEFAULT NULL,
  `GRADE_STAGE` varchar(16) DEFAULT NULL,
  `CLASSES` varchar(16) DEFAULT NULL,
  `LEVEL` varchar(16) DEFAULT NULL,
  `GMT_CREATE` datetime NOT NULL,
  `GMT_MODIFY` datetime NOT NULL,
  PRIMARY KEY (`STUDENT_ID`),
  UNIQUE KEY `INDEX_STUDENT` (`STUDENT_ID`) USING BTREE,
  KEY `FK_STU_USERID` (`USER_ID`),
  CONSTRAINT `FK_STU_USERID` FOREIGN KEY (`USER_ID`) REFERENCES `gts_user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_student
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `gts_teacher`;
CREATE TABLE `gts_teacher` (
  `TEACHER_ID` int(32) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(32) NOT NULL,
  `SCHOOL` varchar(64) DEFAULT NULL,
  `MAJOR` varchar(64) DEFAULT NULL,
  `GRADE` varchar(16) DEFAULT NULL,
  `GRADE_STAGE` varchar(16) DEFAULT NULL,
  `CLASSES` varchar(16) DEFAULT NULL,
  `LEVEL` varchar(16) DEFAULT NULL,
  `GMT_CREATE` datetime NOT NULL,
  `GMT_MODIFY` datetime NOT NULL,
  PRIMARY KEY (`TEACHER_ID`),
  UNIQUE KEY `INDEX_TEACHER` (`TEACHER_ID`) USING BTREE,
  KEY `FK_TEACHER_USERID` (`USER_ID`),
  CONSTRAINT `FK_TEACHER_USERID` FOREIGN KEY (`USER_ID`) REFERENCES `gts_user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_teacher_student`
-- ----------------------------
DROP TABLE IF EXISTS `gts_teacher_student`;
CREATE TABLE `gts_teacher_student` (
  `ID` int(32) NOT NULL AUTO_INCREMENT,
  `TEACHER_ID` int(32) NOT NULL,
  `STUDENT_ID` int(32) NOT NULL,
  `VALID` char(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_STUTEA_STU` (`STUDENT_ID`),
  KEY `FK_STUTEA_TEA` (`TEACHER_ID`),
  CONSTRAINT `FK_STUTEA_STU` FOREIGN KEY (`STUDENT_ID`) REFERENCES `gts_student` (`STUDENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_STUTEA_TEA` FOREIGN KEY (`TEACHER_ID`) REFERENCES `gts_teacher` (`TEACHER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_teacher_student
-- ----------------------------

-- ----------------------------
-- Table structure for `gts_user`
-- ----------------------------
DROP TABLE IF EXISTS `gts_user`;
CREATE TABLE `gts_user` (
  `USER_ID` int(32) NOT NULL AUTO_INCREMENT,
  `USER_TYPE` varchar(12) DEFAULT NULL,
  `CUSTOMER_ID` int(32) DEFAULT NULL,
  `CERT_TYPE` varchar(12) DEFAULT NULL,
  `CERT_NO` varchar(32) DEFAULT NULL,
  `NICK_NAME` varchar(32) DEFAULT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `AGE` varchar(3) DEFAULT NULL,
  `GENDER` varchar(1) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `PHONE` varchar(20) DEFAULT NULL,
  `MOBILE` varchar(16) DEFAULT NULL,
  `JOB` varchar(22) DEFAULT NULL,
  `ROLE_ID` int(32) DEFAULT NULL,
  `PROVINCE` varchar(20) DEFAULT NULL,
  `CITY` varchar(20) DEFAULT NULL,
  `AREA` varchar(30) DEFAULT NULL,
  `ADRESS` varchar(64) DEFAULT NULL,
  `SERCURITY_CODE` varchar(20) DEFAULT NULL,
  `GMT_CREATE` datetime NOT NULL,
  `GMT_MODIFY` datetime NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `INDEX_USER_ID` (`USER_ID`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_user
-- ----------------------------
INSERT INTO `gts_user` VALUES ('1', 'student', null, 'IDC', '130406198905200915', 'geeaks', '高祥', '18', '男', 'vsflyhigh@qq.com', null, '18811511061', '小组长', null, '河北', '邯郸', '峰峰矿区', '新坡镇', 'geeaks', '2015-11-25 23:53:26', '2015-11-25 23:53:26');

-- ----------------------------
-- Table structure for `gts_user_login_info`
-- ----------------------------
DROP TABLE IF EXISTS `gts_user_login_info`;
CREATE TABLE `gts_user_login_info` (
  `ID` int(32) NOT NULL AUTO_INCREMENT,
  `LOGIN_ID` varchar(64) NOT NULL,
  `USER_ID` int(32) NOT NULL,
  `LOGIN_TYPE` varchar(12) NOT NULL,
  `LOGIN_PASSWORD` varchar(64) NOT NULL,
  `USER_TYPE` varchar(12) NOT NULL,
  `LAST_LOGIN_TIME` datetime DEFAULT NULL,
  `GMT_CREATE` datetime NOT NULL,
  `GMT_MODIFY` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `INDEX_LOGIN_ID` (`LOGIN_ID`) USING HASH,
  KEY `FK_USER_LOGIN` (`USER_ID`),
  CONSTRAINT `FK_USER_LOGIN` FOREIGN KEY (`USER_ID`) REFERENCES `gts_user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gts_user_login_info
-- ----------------------------
INSERT INTO `gts_user_login_info` VALUES ('1', '18811511061', '1', 'cell', '123qwe', 'student', '2015-11-28 14:47:48', '2015-11-28 14:47:51', '2015-11-28 14:47:53');

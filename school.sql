/*
MySQL Data Transfer
Source Host: localhost
Source Database: school
Target Host: localhost
Target Database: school
Date: 2020/8/23 23:43:04
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` varchar(11) NOT NULL,
  `adminName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classId` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) NOT NULL,
  `teacherId` varchar(255) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`classId`),
  UNIQUE KEY `className` (`className`),
  KEY `teacherId` (`teacherId`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for results
-- ----------------------------
DROP TABLE IF EXISTS `results`;
CREATE TABLE `results` (
  `studentId` varchar(255) NOT NULL,
  `classId` int(255) NOT NULL,
  `teacherId` varchar(255) NOT NULL,
  `results` int(11) NOT NULL DEFAULT '101',
  KEY `studentId` (`studentId`),
  KEY `classId` (`classId`),
  KEY `teacherId` (`teacherId`),
  CONSTRAINT `results_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`),
  CONSTRAINT `results_ibfk_2` FOREIGN KEY (`classId`) REFERENCES `class` (`classId`),
  CONSTRAINT `results_ibfk_3` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `studentName` varchar(255) NOT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherId` varchar(255) NOT NULL,
  `teacherName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('A01', '王大', '123');
INSERT INTO `class` VALUES ('1', '数学', 'T02', '1');
INSERT INTO `class` VALUES ('2', '语文', 'T01', '1');
INSERT INTO `class` VALUES ('3', '英语', 'T01', '1');
INSERT INTO `class` VALUES ('11', '思想品德', 'T02', '1');
INSERT INTO `results` VALUES ('S0001', '1', 'T02', '72');
INSERT INTO `results` VALUES ('S0001', '3', 'T01', '66');
INSERT INTO `results` VALUES ('S0001', '2', 'T01', '98');
INSERT INTO `results` VALUES ('S0002', '1', 'T02', '44');
INSERT INTO `results` VALUES ('S0002', '2', 'T01', '75');
INSERT INTO `results` VALUES ('S0002', '3', 'T01', '88');
INSERT INTO `results` VALUES ('S0003', '1', 'T02', '59');
INSERT INTO `results` VALUES ('S0003', '2', 'T01', '74');
INSERT INTO `results` VALUES ('S0003', '3', 'T01', '88');
INSERT INTO `results` VALUES ('S0001', '11', 'T02', '101');
INSERT INTO `results` VALUES ('S0002', '11', 'T02', '101');
INSERT INTO `results` VALUES ('S0003', '11', 'T02', '101');
INSERT INTO `student` VALUES ('S0001', '1234', '小刚');
INSERT INTO `student` VALUES ('S0002', '123', '小明');
INSERT INTO `student` VALUES ('S0003', '123', '小红');
INSERT INTO `teacher` VALUES ('T01', '大王', '123');
INSERT INTO `teacher` VALUES ('T02', '大李', '123');

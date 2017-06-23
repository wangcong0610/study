/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : shiro_study

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-09-27 10:03:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(16) unsigned NOT NULL AUTO_INCREMENT,
  `PERMISSION_NAME` varchar(32) NOT NULL,
  `ROLE_ID` bigint(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', 'delete', '1');
INSERT INTO `t_permission` VALUES ('2', 'add', '2');
INSERT INTO `t_permission` VALUES ('3', 'update', '2');
INSERT INTO `t_permission` VALUES ('4', 'query', '3');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `ID` bigint(16) unsigned NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin');
INSERT INTO `t_role` VALUES ('2', 'manager');
INSERT INTO `t_role` VALUES ('3', 'normal');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` bigint(16) unsigned NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(64) DEFAULT NULL,
  `PWD` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '000000');
INSERT INTO `t_user` VALUES ('2', 'manager', '000000');
INSERT INTO `t_user` VALUES ('3', 'normal', '000000');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `USER_ID` bigint(16) NOT NULL,
  `ROLE_ID` bigint(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('1', '2');
INSERT INTO `t_user_role` VALUES ('1', '3');
INSERT INTO `t_user_role` VALUES ('2', '2');
INSERT INTO `t_user_role` VALUES ('2', '3');
INSERT INTO `t_user_role` VALUES ('3', '3');

CREATE TABLE `t_test` (
  `ID` bigint(16) unsigned NOT NULL AUTO_INCREMENT,
  `PARAMETER_1` varchar(32) DEFAULT NULL,
  `PARAMETER_2` varchar(32) DEFAULT NULL,
  `PARAMETER_3` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

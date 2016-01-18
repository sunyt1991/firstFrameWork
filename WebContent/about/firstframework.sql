/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : firstframework

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2016-01-18 21:18:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mag_worker`
-- ----------------------------
DROP TABLE IF EXISTS `mag_worker`;
CREATE TABLE `mag_worker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mag_worker
-- ----------------------------
INSERT INTO `mag_worker` VALUES ('1', '张三1', '20', '1');
INSERT INTO `mag_worker` VALUES ('3', '王武', null, null);
INSERT INTO `mag_worker` VALUES ('5', '123', null, '1');

-- ----------------------------
-- Table structure for `sys_admin`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `isforbidden` int(11) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES ('1', 'admin', '202CB962AC59075B964B07152D234B70', '管理员', '0', '0', '0');

-- ----------------------------
-- Table structure for `sys_admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_role`;
CREATE TABLE `sys_admin_role` (
  `adminid` int(11) NOT NULL DEFAULT '0',
  `roleid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`adminid`,`roleid`),
  KEY `FKA7735425F61A73DF` (`roleid`),
  KEY `FKA773542536403BA1` (`adminid`),
  KEY `FK2902EF662CAF43AA` (`roleid`),
  KEY `FK2902EF66D2456536` (`adminid`),
  CONSTRAINT `sys_admin_role_ibfk_1` FOREIGN KEY (`adminid`) REFERENCES `sys_admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_admin_role_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin_role
-- ----------------------------
INSERT INTO `sys_admin_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `sys_online`
-- ----------------------------
DROP TABLE IF EXISTS `sys_online`;
CREATE TABLE `sys_online` (
  `id` int(18) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) DEFAULT NULL,
  `logintime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上线时间',
  `loginip` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_online
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `restype` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `resstring` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `descn` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `pid` int(10) DEFAULT NULL,
  `ordernum` int(10) NOT NULL,
  `leaf` int(10) DEFAULT NULL,
  `openType` varchar(10) DEFAULT NULL,
  `options` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1A51B40E38C5B4F1` (`pid`) USING BTREE,
  KEY `FKEBABC40E7587A73C` (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '系统维护', 'url', null, null, null, '4', '0', 'tab', null);
INSERT INTO `sys_resource` VALUES ('2', '账号信息', 'url', 'system/admin.do', null, '1', '3', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('3', '角色管理', 'url', 'system/role.do', null, '1', '4', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('6', '菜单管理', 'url', 'system/resource.do', null, '1', '6', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('16', '数据字典', 'url', 'system/dictionary.do', null, '1', '3', '1', 'tab', null);

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `descn` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '负责整个系统的管理');
INSERT INTO `sys_role` VALUES ('2', '普通用户', '负责系统业务管理');

-- ----------------------------
-- Table structure for `sys_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `roleid` int(10) NOT NULL,
  `resourceid` int(10) NOT NULL,
  PRIMARY KEY (`roleid`,`resourceid`),
  KEY `FK_ROLERESOURCE_RESOURCE1` (`resourceid`) USING BTREE,
  KEY `FKB5684F61A73DF` (`roleid`) USING BTREE,
  KEY `FKAEE599B72CAF43AA` (`roleid`) USING BTREE,
  KEY `FKAEE599B72550FB5A` (`resourceid`) USING BTREE,
  CONSTRAINT `sys_role_resource_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_resource_ibfk_2` FOREIGN KEY (`resourceid`) REFERENCES `sys_resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('1', '1');
INSERT INTO `sys_role_resource` VALUES ('1', '2');
INSERT INTO `sys_role_resource` VALUES ('1', '3');
INSERT INTO `sys_role_resource` VALUES ('1', '6');
INSERT INTO `sys_role_resource` VALUES ('1', '16');

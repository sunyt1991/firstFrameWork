/*
MySQL Data Transfer
Source Host: localhost
Source Database: firstframework
Target Host: localhost
Target Database: firstframework
Date: 2016/1/22 8:17:15
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for mag_worker
-- ----------------------------
CREATE TABLE `mag_worker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
CREATE TABLE `sys_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_admin_role
-- ----------------------------
CREATE TABLE `sys_admin_role` (
  `adminid` int(11) NOT NULL DEFAULT '0',
  `roleid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`adminid`,`roleid`),
  KEY `FK2902EF662CAF43AA` (`roleid`),
  KEY `FK2902EF66D2456536` (`adminid`),
  CONSTRAINT `sys_admin_role_ibfk_1` FOREIGN KEY (`adminid`) REFERENCES `sys_admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_admin_role_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
CREATE TABLE `sys_notice` (
  `id` int(18) NOT NULL,
  `descn` varchar(1000) DEFAULT NULL COMMENT '统系通知',
  `creattime` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_online
-- ----------------------------
CREATE TABLE `sys_online` (
  `id` int(18) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) DEFAULT NULL,
  `logintime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上线时间',
  `loginip` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
CREATE TABLE `sys_resource` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `restype` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `resstring` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `descn` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `pid` int(10) DEFAULT NULL,
  `ordernum` int(10) NOT NULL,
  `leaf` int(10) DEFAULT NULL,
  `opentype` varchar(10) DEFAULT NULL,
  `options` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1A51B40E38C5B4F1` (`pid`) USING BTREE,
  KEY `FKEBABC40E7587A73C` (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `descn` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `opentype` varchar(20) DEFAULT NULL,
  `options` varchar(20) DEFAULT NULL,
  `ordernum` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `resstring` varchar(20) DEFAULT NULL,
  `restype` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
CREATE TABLE `sys_role_resource` (
  `roleid` int(10) NOT NULL,
  `resourceid` int(10) NOT NULL,
  PRIMARY KEY (`roleid`,`resourceid`),
  KEY `FKAEE599B72550FB5A` (`resourceid`) USING BTREE,
  KEY `FK_h1ghg0osinr88biigls514ppe` (`roleid`),
  CONSTRAINT `sys_role_resource_ibfk_2` FOREIGN KEY (`resourceid`) REFERENCES `sys_resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_resource_ibfk_3` FOREIGN KEY (`roleid`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `mag_worker` VALUES ('1', '张三1', '20', '1');
INSERT INTO `mag_worker` VALUES ('3', '王武', null, null);
INSERT INTO `mag_worker` VALUES ('5', '123', null, '1');
INSERT INTO `sys_admin` VALUES ('1', 'admin', '202CB962AC59075B964B07152D234B70', '管理员', '0', '0');
INSERT INTO `sys_admin_role` VALUES ('1', '1');
INSERT INTO `sys_resource` VALUES ('1', '系统维护', 'url', null, null, null, '4', '0', 'tab', null);
INSERT INTO `sys_resource` VALUES ('2', '账号信息', 'url', 'system/admin.do', null, '1', '3', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('3', '角色管理', 'url', 'system/role.do', null, '1', '4', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('6', '菜单管理', 'url', 'system/resource.do', null, '1', '6', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('16', '数据字典', 'url', 'system/dictionary.do', null, '1', '3', '1', 'tab', null);
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '负责整个系统的管理', null, null, null, null, null, null);
INSERT INTO `sys_role` VALUES ('2', '普通用户', '负责系统业务管理', null, null, null, null, null, null);
INSERT INTO `sys_role_resource` VALUES ('1', '1');
INSERT INTO `sys_role_resource` VALUES ('1', '2');
INSERT INTO `sys_role_resource` VALUES ('1', '3');
INSERT INTO `sys_role_resource` VALUES ('1', '6');
INSERT INTO `sys_role_resource` VALUES ('1', '16');

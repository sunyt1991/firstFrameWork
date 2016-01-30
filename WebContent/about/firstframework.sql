/*
MySQL Data Transfer
Source Host: localhost
Source Database: firstframework
Target Host: localhost
Target Database: firstframework
Date: 2016/1/30 13:37:33
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for dev_operation_log
-- ----------------------------
CREATE TABLE `dev_operation_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operate` varchar(20) DEFAULT NULL COMMENT '操作',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mag_level
-- ----------------------------
CREATE TABLE `mag_level` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `num1` int(2) DEFAULT NULL,
  `num2` int(2) DEFAULT NULL,
  `num3` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mag_online
-- ----------------------------
CREATE TABLE `mag_online` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '在线用户',
  `createdate` datetime DEFAULT NULL COMMENT '上线时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mag_website
-- ----------------------------
CREATE TABLE `mag_website` (
  `id` int(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL COMMENT '网址',
  `iskeypoint` int(2) DEFAULT NULL COMMENT '是否重点关注',
  `level` int(2) DEFAULT NULL COMMENT '警预级别 123',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
CREATE TABLE `sys_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(50) NOT NULL COMMENT '用户名',
  `pwd` varchar(50) NOT NULL COMMENT '密码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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
INSERT INTO `sys_admin` VALUES ('1', 'admin', '202CB962AC59075B964B07152D234B70', '管理员', null, '0', '0');
INSERT INTO `sys_admin_role` VALUES ('1', '1');
INSERT INTO `sys_resource` VALUES ('1', '数据维护', 'url', null, null, null, '4', '0', 'tab', null);
INSERT INTO `sys_resource` VALUES ('2', '账号信息', 'url', 'admin/index.action', null, '1', '3', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('3', '角色管理', 'url', 'role/index.action', null, '1', '4', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('6', '菜单管理', 'url', 'resource/index.action', null, '1', '6', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('16', '数据字典', 'url', 'dictionary/index.action', null, '1', '3', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('17', '系统安全', 'url', null, null, null, '5', '0', 'tab', null);
INSERT INTO `sys_resource` VALUES ('18', '登录日志', 'url', null, null, '17', '1', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('19', '数据备份', 'url', null, null, '17', '2', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('20', '系统通知', 'url', null, null, '1', '7', '1', 'tab', null);
INSERT INTO `sys_resource` VALUES ('21', '系统性能', 'url', null, null, null, '5', '0', 'tab', null);
INSERT INTO `sys_resource` VALUES ('22', '性能分析', 'url', 'druid/index.html', null, '21', '1', '1', 'tab', null);
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '负责系统业务管理', null, null, null, null, null, null);
INSERT INTO `sys_role` VALUES ('2', '开发人员', '最高权限', null, null, null, null, null, null);
INSERT INTO `sys_role` VALUES ('3', '普通用户', null, null, null, null, null, null, null);
INSERT INTO `sys_role_resource` VALUES ('1', '1');
INSERT INTO `sys_role_resource` VALUES ('1', '2');
INSERT INTO `sys_role_resource` VALUES ('1', '3');
INSERT INTO `sys_role_resource` VALUES ('1', '6');
INSERT INTO `sys_role_resource` VALUES ('1', '16');
INSERT INTO `sys_role_resource` VALUES ('1', '17');
INSERT INTO `sys_role_resource` VALUES ('1', '18');
INSERT INTO `sys_role_resource` VALUES ('1', '19');
INSERT INTO `sys_role_resource` VALUES ('1', '20');
INSERT INTO `sys_role_resource` VALUES ('1', '21');
INSERT INTO `sys_role_resource` VALUES ('1', '22');

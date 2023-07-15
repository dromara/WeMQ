/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : WeMQ_Old

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 15/07/2023 23:06:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mq_customer
-- ----------------------------
DROP TABLE IF EXISTS `mq_customer`;
CREATE TABLE `mq_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mq_customer
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for mq_customer_page
-- ----------------------------
DROP TABLE IF EXISTS `mq_customer_page`;
CREATE TABLE `mq_customer_page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `page_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mq_customer_page
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for mq_nmqs_token
-- ----------------------------
DROP TABLE IF EXISTS `mq_nmqs_token`;
CREATE TABLE `mq_nmqs_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'TokenID',
  `name` varchar(255) NOT NULL COMMENT 'Token名称',
  `token` varchar(255) NOT NULL COMMENT 'Token',
  `protocol` int(11) NOT NULL COMMENT '协议 0:ws 1:tcp',
  `mqtt_server` varchar(255) DEFAULT NULL COMMENT 'MQTT服务器',
  `mqtt_port` int(11) DEFAULT NULL COMMENT 'MQTT端口',
  `mqtt_username` varchar(255) DEFAULT NULL COMMENT 'MQTT用户名',
  `mqtt_password` varchar(255) DEFAULT NULL COMMENT 'MQTT密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mq_nmqs_token
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for mq_page
-- ----------------------------
DROP TABLE IF EXISTS `mq_page`;
CREATE TABLE `mq_page` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '页面ID',
  `page_name` varchar(255) NOT NULL COMMENT '页面名称',
  `page_url` varchar(255) NOT NULL COMMENT '访问URL',
  `page_filename` varchar(255) DEFAULT NULL,
  `nmqs_id` int(11) NOT NULL COMMENT 'NmqsTokenID',
  `status` int(11) NOT NULL COMMENT '页面启用状态',
  `mqtt_sendtopic` varchar(255) NOT NULL COMMENT 'MQTT发布订阅',
  `mqtt_receivetopic` varchar(255) NOT NULL COMMENT 'MQTT接收订阅',
  `mqtt_qos` int(11) NOT NULL DEFAULT '0' COMMENT 'QoS',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mq_page
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for mq_page_param
-- ----------------------------
DROP TABLE IF EXISTS `mq_page_param`;
CREATE TABLE `mq_page_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_id` int(11) DEFAULT NULL,
  `param_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mq_page_param
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for mq_param
-- ----------------------------
DROP TABLE IF EXISTS `mq_param`;
CREATE TABLE `mq_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) NOT NULL,
  `button` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mq_param
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `username` varchar(255) NOT NULL COMMENT '管理员用户名',
  `nickname` varchar(255) NOT NULL COMMENT '管理员昵称',
  `password` varchar(255) NOT NULL COMMENT '登录密码',
  `status` int(11) NOT NULL COMMENT '启用状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
BEGIN;
INSERT INTO `sys_admin` (`id`, `username`, `nickname`, `password`, `status`) VALUES (1, 'admin', '系统管理员', '$2a$10$YC4Pe1xIqBdsfKmVOql1burSsOYbKQr3XKocquaM5HmFO7Byw53Mi', 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `admin_id` int(11) NOT NULL COMMENT '管理员ID',
  `admin_ip` varchar(255) DEFAULT NULL COMMENT '登录IP',
  `admin_os` varchar(255) DEFAULT NULL COMMENT '登录操作系统',
  `login_time` datetime NOT NULL COMMENT '登录时间',
  `login_status` int(11) NOT NULL COMMENT '登录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

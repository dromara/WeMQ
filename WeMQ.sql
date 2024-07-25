SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mq_customer
-- ----------------------------
DROP TABLE IF EXISTS `mq_customer`;
CREATE TABLE `mq_customer`  (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mq_customer
-- ----------------------------

-- ----------------------------
-- Table structure for mq_customer_page
-- ----------------------------
DROP TABLE IF EXISTS `mq_customer_page`;
CREATE TABLE `mq_customer_page`  (
                                     `id` int NOT NULL AUTO_INCREMENT,
                                     `customer_id` int NOT NULL,
                                     `page_id` int NOT NULL,
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mq_customer_page
-- ----------------------------

-- ----------------------------
-- Table structure for mq_nmqs_token
-- ----------------------------
DROP TABLE IF EXISTS `mq_nmqs_token`;
CREATE TABLE `mq_nmqs_token`  (
                                  `id` int NOT NULL AUTO_INCREMENT COMMENT 'TokenID',
                                  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'Token名称',
                                  `token` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'Token',
                                  `protocol` int NOT NULL COMMENT '协议 0:ws 1:tcp',
                                  `mqtt_server` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'MQTT服务器',
                                  `mqtt_port` int NULL DEFAULT NULL COMMENT 'MQTT端口',
                                  `mqtt_username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'MQTT用户名',
                                  `mqtt_password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'MQTT密码',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mq_nmqs_token
-- ----------------------------

-- ----------------------------
-- Table structure for mq_page
-- ----------------------------
DROP TABLE IF EXISTS `mq_page`;
CREATE TABLE `mq_page`  (
                            `id` int NOT NULL AUTO_INCREMENT COMMENT '页面ID',
                            `page_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '页面名称',
                            `page_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '访问URL',
                            `page_filename` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
                            `nmqs_id` int NOT NULL COMMENT 'NmqsTokenID',
                            `status` int NOT NULL COMMENT '页面启用状态',
                            `mqtt_sendtopic` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'MQTT发布订阅',
                            `mqtt_receivetopic` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'MQTT接收订阅',
                            `mqtt_qos` int NOT NULL DEFAULT 0 COMMENT 'QoS',
                            `batch_send` int NOT NULL DEFAULT 0,
                            `batch_command` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
                            `batch_delay` int NOT NULL DEFAULT 0,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mq_page
-- ----------------------------

-- ----------------------------
-- Table structure for mq_page_param
-- ----------------------------
DROP TABLE IF EXISTS `mq_page_param`;
CREATE TABLE `mq_page_param`  (
                                  `id` int NOT NULL AUTO_INCREMENT,
                                  `page_id` int NULL DEFAULT NULL,
                                  `param_id` int NULL DEFAULT NULL,
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mq_page_param
-- ----------------------------

-- ----------------------------
-- Table structure for mq_param
-- ----------------------------
DROP TABLE IF EXISTS `mq_param`;
CREATE TABLE `mq_param`  (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `message` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                             `button` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                             `sort` int NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mq_param
-- ----------------------------

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin`  (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
                              `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '管理员用户名',
                              `nickname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '管理员昵称',
                              `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '登录密码',
                              `status` int NOT NULL COMMENT '启用状态',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES (1, 'admin', '系统管理员', '$2a$10$YC4Pe1xIqBdsfKmVOql1burSsOYbKQr3XKocquaM5HmFO7Byw53Mi', 0);

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log`  (
                                  `id` int NOT NULL AUTO_INCREMENT COMMENT '日志ID',
                                  `admin_id` int NOT NULL COMMENT '管理员ID',
                                  `admin_ip` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '登录IP',
                                  `admin_os` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '登录操作系统',
                                  `login_time` datetime NOT NULL COMMENT '登录时间',
                                  `login_status` int NOT NULL COMMENT '登录状态',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

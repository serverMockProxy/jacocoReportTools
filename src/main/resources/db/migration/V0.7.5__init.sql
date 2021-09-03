

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for jacoco
-- ----------------------------
DROP TABLE IF EXISTS `jacoco`;
CREATE TABLE `jacoco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `gitlab_id` int(11) NOT NULL,
  `gitclone_path` varchar(255) DEFAULT NULL,
  `jacoco_project_name` varchar(255) DEFAULT NULL,
  `childrens` json DEFAULT NULL,
  `compare_type` int(11) NOT NULL COMMENT '1=分支比较 2=提交比较 3=全量比较',
  `current_branch` varchar(255) DEFAULT NULL COMMENT '当前分支',
  `compare_branch` varchar(255) DEFAULT NULL COMMENT '对比分支',
  `current_commit` varchar(255) DEFAULT NULL COMMENT '当前commit号',
  `compare_commit` varchar(255) DEFAULT NULL COMMENT '对比commit号',
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `report_path` varchar(255) DEFAULT NULL COMMENT '报告路径',
  `task_status` int(11) DEFAULT NULL COMMENT '0=未执行 1=执行中 2=已完成',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for jacoco_config
-- ----------------------------
DROP TABLE IF EXISTS `jacoco_config`;
CREATE TABLE `jacoco_config` (
  `project_id` int(11) NOT NULL,
  `git_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `children` json DEFAULT NULL,
  PRIMARY KEY (`project_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '项目名',
  `default_forward_host` varchar(255) DEFAULT NULL COMMENT '路径标记',
  `platform` tinyint(4) DEFAULT NULL COMMENT '1.andorid 2.iOS 3.pc web',
  `capabilities` text,
  `description` varchar(255) DEFAULT NULL COMMENT '项目描述',
  `creator_uid` int(11) NOT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_name_platform` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COMMENT='项目表';

-- ----------------------------
-- Table structure for proxy_config
-- ----------------------------
DROP TABLE IF EXISTS `proxy_config`;
CREATE TABLE `proxy_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `intercept_path` varchar(255) NOT NULL COMMENT '拦截路径',
  `forward_host` varchar(255) DEFAULT NULL COMMENT '转发host',
  `mock_requir` longtext,
  `mock_response` longtext,
  `is_callback` tinyint(1) DEFAULT NULL,
  `callback_host` varchar(255) DEFAULT NULL,
  `callback_path` varchar(255) DEFAULT NULL,
  `callback_method` varchar(255) DEFAULT NULL,
  `sign_type` int(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `callback_body_type` varchar(255) DEFAULT NULL,
  `callback_headers` json DEFAULT NULL,
  `callback_request_json` json DEFAULT NULL,
  `callback_request_query` json DEFAULT NULL,
  `callback_request_form` json DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `creator_uid` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `intercept_path` (`intercept_path`) USING BTREE,
  KEY `projectid` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for proxy_details
-- ----------------------------
DROP TABLE IF EXISTS `proxy_details`;
CREATE TABLE `proxy_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `intercept_path` varchar(255) NOT NULL,
  `forward_host` varchar(255) DEFAULT NULL,
  `mock_requir` varchar(255) DEFAULT NULL,
  `request_json` longtext,
  `response_json` longtext,
  `callback_url` varchar(255) DEFAULT NULL,
  `callback_method` varchar(255) DEFAULT NULL,
  `callback_request_json` longtext,
  `callback_response_json` longtext,
  `description` varchar(255) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1743 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '角色名',
  `alias` varchar(100) NOT NULL COMMENT '别名',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `nick_name` varchar(255) NOT NULL COMMENT '用户昵称',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态，0:禁用 1:正常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Table structure for user_project
-- ----------------------------
DROP TABLE IF EXISTS `user_project`;
CREATE TABLE `user_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_userId_projectId` (`user_id`,`project_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=508 DEFAULT CHARSET=utf8mb4 COMMENT='用户项目表';

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_userId_roleId` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1640 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';

SET FOREIGN_KEY_CHECKS = 1;

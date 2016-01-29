
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for epm_role
-- ----------------------------
DROP TABLE IF EXISTS `epm_role`;
CREATE TABLE `epm_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `role_no` varchar(16) NOT NULL DEFAULT '' COMMENT '角色编号',
  `permissions` varchar(255) NOT NULL DEFAULT '' COMMENT '角色拥有的权限',
  `desc` varchar(255) NOT NULL DEFAULT '' COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of epm_role
-- ----------------------------

-- ----------------------------
-- Table structure for epm_user
-- ----------------------------
DROP TABLE IF EXISTS `epm_user`;
CREATE TABLE `epm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_type` tinyint(4) DEFAULT '0' COMMENT '用户类型，0：系统管理员；1：会议控制员；2：会议记录员；3：高级用户；4：音视频记录人员；5：会议管理员；',
  `user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `passwd_md5` varchar(32) NOT NULL DEFAULT '' COMMENT 'md5(密码)',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `birthday` date DEFAULT '1970-01-01' COMMENT '生日',
  `avatar` varchar(128) NOT NULL DEFAULT '' COMMENT '头像',
  `role_ids` varchar(64) NOT NULL DEFAULT '' COMMENT '用户的角色id列表，多个id之间用'',''分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of epm_user
-- ----------------------------

-- ----------------------------
-- Table structure for expert_field
-- ----------------------------
DROP TABLE IF EXISTS `expert_field`;
CREATE TABLE `expert_field` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id，自增长',
  `expert_id` int(11) NOT NULL DEFAULT '0' COMMENT '专家id',
  `field_id` int(11) NOT NULL DEFAULT '0' COMMENT '领域id',
  `operate_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '记录插入时间或者最后修改时间',
  `operator_name` varchar(50) DEFAULT '' COMMENT '记录插入者姓名或者最后修改者姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
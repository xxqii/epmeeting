
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for epm_role
-- ----------------------------
DROP TABLE IF EXISTS `epm_role`;
CREATE TABLE `epm_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `role_no` varchar(255) NOT NULL DEFAULT '' COMMENT '角色编号',
  `permissions` varchar(255) NOT NULL DEFAULT '' COMMENT '角色拥有的权限',
  `note` varchar(255) NOT NULL DEFAULT '' COMMENT '角色描述',
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
  `expert_id` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '专家id',
  `field_id` int(11) NOT NULL DEFAULT '0' COMMENT '领域id',
  `operate_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '记录插入时间或者最后修改时间',
  `operator_name` varchar(50) DEFAULT '' COMMENT '记录插入者姓名或者最后修改者姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of epm_field
-- ----------------------------

-- ----------------------------
-- Table structure for epm_expert
-- ----------------------------
DROP TABLE IF EXISTS `epm_expert`;
CREATE TABLE `epm_expert` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `expert_number` varchar(20) NOT NULL DEFAULT '' COMMENT '专家编号',
  `expert_name` varchar(32) NOT NULL DEFAULT '' COMMENT '专家名',
  `sex` tinyint(4) DEFAULT '0' COMMENT '性别 0：男性；1表示女性',
  `expert_position` varchar(32) DEFAULT NULL COMMENT '职位',
  `birthday` date DEFAULT '1970-01-01' COMMENT '生日',
  `expert_title` VARCHAR (32) DEFAULT '' COMMENT '职称',
  `expert_education` VARCHAR (32) DEFAULT'' COMMENT '学历',
  `expert_degree` VARCHAR (32) DEFAULT '' COMMENT '学位',
  `expert_workunit` VARCHAR (32) DEFAULT '' COMMENT '工作单位',
  `field` int(10) DEFAULT '0' COMMENT '领域编号，是领域表的外键',
  `expert_achievement` TEXT  COMMENT '个人领域',
  `expert_mobile` int(20) DEFAULT '0' COMMENT '手机',
  `expert_tel` int(20) DEFAULT '0' COMMENT '电话',
  `expert_QQ` int(15) DEFAULT '0' COMMENT 'qq',
  `expert_Email` VARCHAR (32) DEFAULT '' COMMENT '邮箱',
  `expert_introduction` TEXT COMMENT'个人简介',
  `expert_avatar` varchar(128) NOT NULL DEFAULT '' COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of epm_expert
-- ----------------------------

-- ----------------------------
-- Table structure for expert_meeting
-- ----------------------------
DROP TABLE IF EXISTS `expert_meeting`;
CREATE TABLE `expert_meeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `expert_id` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '专家ID',
  `meeting_id` int(10) NOT NULL DEFAULT '0' COMMENT '会议ID',
  `operate_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '记录插入时间或者最后修改时间',
  `operator_name` varchar(50) DEFAULT '' COMMENT '记录插入者姓名或者最后修改者姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expert_meeting
-- ----------------------------
-- ----------------------------
-- Table structure for epm_video
-- ----------------------------
DROP TABLE IF EXISTS `epm_video`;
CREATE TABLE `epm_video` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `video_number` int(20) NOT NULL DEFAULT '0' COMMENT '录像编号',
  `user_id` int(20) NOT NULL DEFAULT '0' COMMENT'用户编号',
  `expert_id` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '专家ID',
  `meeting_id` int(10) NOT NULL DEFAULT '0' COMMENT '会议ID',
  `video` VARCHAR (255) DEFAULT '' COMMENT'会议内容',
  `video_begin` datetime  DEFAULT '1970-01-01 00:00:00' COMMENT'录像开始时间',
  `video_end` datetime  DEFAULT '1970-01-01 00:00:00' COMMENT'录像结束时间',
  `video_size` VARCHAR (255) DEFAULT '' COMMENT'录像大小',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of epm_video
-- ----------------------------

-- ----------------------------
-- Table structure for epm_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `epm_userinfo`;
CREATE TABLE `epm_userinfo` (
  `userinfo_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户自增主键',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `user_mobile` varchar(255) NOT NULL DEFAULT '' COMMENT '用户电话',
 `user_tel` varchar(255) NOT NULL DEFAULT '' COMMENT '角色手机',
`user_email` varchar(255) NOT NULL DEFAULT '' COMMENT '用户邮箱',
`user_photo` varchar(255) NOT NULL DEFAULT '' COMMENT '用户头像',
`user_qq` varchar(255) NOT NULL DEFAULT '' COMMENT '用户QQ',
`user_workunit` varchar(255) NOT NULL DEFAULT '' COMMENT '用户职业',
`user_postaddress` varchar(255) NOT NULL DEFAULT '' COMMENT '用户地址',
  PRIMARY KEY (`userinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of epm_userinfo
-- ----------------------------
-- ----------------------------
-- Records of epm_text
-- ----------------------------

DROP TABLE IF EXISTS `epm_text`;
CREATE TABLE `epm_text` (
  `text_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文本自增主键',
  `text_number` varchar(16) NOT NULL DEFAULT '' COMMENT '文本编号',
  `text_meetingid` int(11) NOT NULL DEFAULT '0' COMMENT '所记录的会议ID',
  `text_expertid` int(11) NOT NULL DEFAULT '0' COMMENT '所记录的专家ID',
 `text_userid` int(11) NOT NULL DEFAULT '0' COMMENT '所记录的用户ID',
`text_content` varchar(255) NOT NULL DEFAULT '' COMMENT '文本内容',
`text_uploadtime` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '文本上传时间',
  PRIMARY KEY (`text_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of epm_text
-- ----------------------------

-- ----------------------------
-- Table structure for meeting_field
-- ----------------------------
DROP TABLE IF EXISTS `meeting_field`;
CREATE TABLE `meeting_field` (
  `MeetingId` int(10)  NOT NULL DEFAULT'0' COMMENT'会议ID',
  `FieldId` int(10)  NOT NULL DEFAULT'0' COMMENT'领域ID',
  `MeetingFieldId` int(10) NOT NULL AUTO_INCREMENT COMMENT'自增主键',
  PRIMARY KEY (`MeetingFieldId`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of meeting_field
-- ----------------------------

-- ----------------------------
-- Table structure for meeting_issue
-- ----------------------------
DROP TABLE IF EXISTS `meeting_issue`;
CREATE TABLE `meeting_issue` (
  `MeetingId` int(10)  NOT NULL COMMENT '会议Id',
  `IssueId` int(10)  NOT NULL COMMENT '议题id',
  `MeetingIssueId` int(10) NOT NULL AUTO_INCREMENT COMMENT'自增主键',
  PRIMARY KEY (`MeetingIssueId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of meeting_issue
-- ----------------------------

-- ----------------------------
-- Table structure for meeting_material
-- ----------------------------
DROP TABLE IF EXISTS `meeting_material`;
CREATE TABLE `meeting_material` (
  `MeetingId` int(10)  NOT NULL DEFAULT'0' COMMENT'会议ID',
  `MaterialId` int(10) NOT NULL DEFAULT'0' COMMENT'资料ID',
  `MeetingMaterialId` int(10) NOT NULL AUTO_INCREMENT COMMENT'主键自增',
  PRIMARY KEY (`MeetingMaterialId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of meeting_material
-- ----------------------------


-- ----------------------------
-- Table structure for epm_log
-- ----------------------------
DROP TABLE IF EXISTS `epm_log`;
CREATE TABLE `epm_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id，自增长',
  `create_ipaddr` VARCHAR(255)  DEFAULT'' COMMENT '创建本条日志记录的IP',
  `create_username` VARCHAR(32) DEFAULT'' COMMENT '创建本条日志的用户名',
  `create_datetime` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `log_type` varchar(32) NOT NULL DEFAULT'' COMMENT '日志类型',
  `content` TEXT  NOT NULL  COMMENT '本条日志的详细内容',
  `operation_type`VARCHAR(32)  DEFAULT '' COMMENT'操作类型',
  `operated_table` VARCHAR(255) ' COMMENT'操作所针对的表' ,
  `memo` TEXT DEFAULT'' COMMENT'文本' ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of epm_log
-- ----------------------------


-- ----------------------------
-- Table structure for epm_material
-- ----------------------------
DROP TABLE IF EXISTS  `epm_material`;
CREATE TABLE `epm_material`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id，自增长，会议资料对应ID',
`meeting_id` int(11) NOT NULL DEFAULT'0' COMMENT'会议ID',
`material_id` int(11) NOT NULL DEFAULT'0' COMMENT'资料ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of epm_material
-- ----------------------------

-- ----------------------------
-- Table structure for epm_meeting
-- ----------------------------
DROP TABLE IF EXISTS `epm_meeting`;
CREATE TABLE `epm_meeting` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
`meeting_no` VARCHAR(255) NOT NULL DEFAULT'' COMMENT'会议编号',
`meeting_name` VARCHAR(255) NOT NULL DEFAULT'' COMMENT'会议名称',
`place` VARCHAR (255) NOT NULL DEFAULT'' COMMENT'会议地点',
`emcee_id` VARCHAR (255)NOT NULL DEFAULT'' COMMENT'主持人ID',
`time_begin` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '开始时间',
`time_end` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '结束时间',
`state` int(11) NOT NULL DEFAULT'0' COMMENT'会议状态',
`summary` text DEFAULT NULL COMMENT'会议简介',
`video_path` VARCHAR (255) DEFAULT NULL COMMENT'会议视频',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of epm_meeting
-- ----------------------------


-- ----------------------------
-- Table structure for epm_field
-- ----------------------------
DROP TABLE IF EXISTS `epm_field`;
CREATE TABLE `epm_field` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `field_number` int(11) NOT NULL COMMENT '领域编号',
  `field_name` varchar(50) NOT NULL DEFAULT '' COMMENT '领域名称',
  `field_note` varchar(255)  DEFAULT NULL  COMMENT '领域描述',
	`father_field_id` int(11) NOT NULL COMMENT '父领域id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of epm_field
-- ----------------------------

-- ----------------------------
-- Table structure for epm_issue
-- ----------------------------
DROP TABLE IF EXISTS `epm_issue`;
CREATE TABLE `epm_issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `issue_number` int(11) NOT NULL COMMENT '议题编号',
  `issue_name` varchar(50) NOT NULL DEFAULT '' COMMENT '议题名称',
  `issue_note` varchar(255)  DEFAULT NULL  COMMENT '议题描述',
	`meeting_id` int(11) NOT NULL COMMENT '所属会议id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of epm_issue
-- ----------------------------

-- ----------------------------
-- Table structure for IssueField
-- ----------------------------
DROP TABLE IF EXISTS `issue_field`;
CREATE TABLE `issue_field` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
	`issue_id` int(11) NOT NULL COMMENT '会议议题id',
	`field_id` int(11) NOT NULL COMMENT '所属领域id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of IssueField
-- ----------------------------


-- laokai.appointment definition

CREATE TABLE `appointment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `department_id` int(10) unsigned NOT NULL COMMENT '科室ID',
  `time` int(16) unsigned NOT NULL COMMENT '预约时间',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户ID',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `add_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '入库时间',
  `doctor_id` int(10) unsigned NOT NULL COMMENT '医生ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `appointment_department_id_IDX` (`department_id`,`time`,`doctor_id`,`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;


-- laokai.department definition

CREATE TABLE `department` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'DID',
  `hospital_id` int(10) unsigned NOT NULL COMMENT 'HID',
  `department_name` varchar(30) NOT NULL COMMENT '科室名',
  `parent_id` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '父DID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;


-- laokai.doctor definition

CREATE TABLE `doctor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `doctor_name` varchar(18) NOT NULL COMMENT '医生姓名',
  `doctor_sex` varchar(3) NOT NULL DEFAULT '女',
  `department_id` int(10) unsigned NOT NULL COMMENT 'DID',
  `doctor_job_title` tinyint(4) NOT NULL DEFAULT 0 COMMENT '医生职称',
  `doctor_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '医生状态，0:正常;1:~',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;


-- laokai.hospital definition

CREATE TABLE `hospital` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'HID',
  `hospital_name` varchar(100) NOT NULL,
  `hospital_contact` varchar(19) NOT NULL COMMENT '联系电话',
  `hospital_level` varchar(9) NOT NULL DEFAULT '一级甲等',
  `hospital_branch_type` tinyint(4) NOT NULL DEFAULT 1 COMMENT '分支类型，1:总院;2:分院',
  `hospital_introduction` varchar(120) NOT NULL DEFAULT '这里是医院介绍',
  `hospital_parent_id` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '总院ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;


-- laokai.person definition

CREATE TABLE `person` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'UID',
  `username` varchar(18) NOT NULL,
  `user_age` tinyint(4) NOT NULL DEFAULT 0,
  `mobile` varchar(16) DEFAULT NULL,
  `sex` varchar(3) NOT NULL DEFAULT '女',
  `id_card_no` varchar(19) DEFAULT NULL,
  `open_id` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;


-- laokai.scheduling definition

CREATE TABLE `scheduling` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `department_id` int(10) unsigned NOT NULL COMMENT '科室ID',
  `date` date NOT NULL COMMENT '排班日期',
  `start_time` time NOT NULL COMMENT '开始时间',
  `end_time` time NOT NULL COMMENT '结束时间',
  `add_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '入库时间',
  `scheduling_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '排班状态，0:未完成;1:已完成',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk COMMENT='排班';


-- laokai.scheduling_stuff definition

CREATE TABLE `scheduling_stuff` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `doctor_id` int(10) unsigned NOT NULL COMMENT '医生ID',
  `scheduling_id` int(10) unsigned NOT NULL COMMENT '排班ID',
  `start_time` time NOT NULL COMMENT '开始时间',
  `end_time` time NOT NULL COMMENT '结束时间',
  `add_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '入库时间',
  `department_id` int(10) unsigned NOT NULL COMMENT '科室ID',
  `date` date NOT NULL COMMENT '排班日期',
  `scheduling_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '排班状态，0:未完成;1:已完成',
  PRIMARY KEY (`id`),
  UNIQUE KEY `scheduling_stuff_department_id_IDX` (`department_id`,`doctor_id`,`scheduling_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=gbk COMMENT='排班员工';
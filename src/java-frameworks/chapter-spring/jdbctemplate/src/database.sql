USE springdb ;

DROP TABLE IF EXISTS `user` ;

CREATE TABLE `user` (
  `pk_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `uk_uname` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY (`uk_uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

INSERT INTO `user`(`pk_id`,`uk_uname`,`password`,`email`)
VALUES
(1,'lina','ok','lina@sina.com.cn'),
(2,'kate','ok','hello_kate@126.com'),
(3,'jiuer','ok','jiuer@126.com');

CREATE TABLE `dept` (
  `pk_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `uk_dept_name` varchar(20) NOT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY (`uk_dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

INSERT INTO `dept`(`pk_id`,`uk_dept_name`)
VALUES
(1,'编辑部'),
(2,'销售部'),
(3,'研发部'),
(4,'保障部');
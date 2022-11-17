USE test ;

CREATE TABLE `t_user` (
  `pk_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `uk_uname` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY (`uk_uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

INSERT INTO `t_user`(`pk_id`,`uk_uname`,`password`,`email`)
VALUES
(1,'lina','ok','lina@sina.com.cn'),
(2,'kate','ok','hello_kate@126.com'),
(3,'鸠摩智','ok','jiujiu@126.com');


USE mybatisdb ;

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

ALTER TABLE user ADD COLUMN dept_id bigint UNSIGNED;

ALTER TABLE user ADD CONSTRAINT fk_dept_id 
FOREIGN KEY (dept_id) REFERENCES dept (pk_id);

SELECT tu.pk_id user_id, tu.uk_uname user_name, tu.password user_password, tu.email user_email, 
td.pk_id dept_id, td.uk_dept_name dept_name
FROM `user` tu , dept td WHERE tu.dept_id = td.pk_id AND tu.pk_id = 3;

SELECT `pk_id`, `uk_uname`, `password`, `email`, `dept_id` FROM t_user WHERE `pk_id` =3;

SELECT `pk_id` id, `uk_dept_name` deptName FROM t_dept WHERE  pk_id =1;

SELECT td.pk_id dept_id, td.uk_dept_name dept_name, 
tu.pk_id user_id, tu.uk_uname user_name, tu.password user_password, tu.email user_email
FROM t_dept td LEFT JOIN t_user tu 
ON td.pk_id = tu.dept_id
WHERE td.pk_id = 1;

SELECT * FROM t_dept td WHERE pk_id = 1;
SELECT * FROM t_user tu WHERE dept_id = 1;

SELECT `pk_id` id, `uk_uname` uname, `password`, `email` 
FROM t_user 
WHERE `pk_id` = 8 AND `uk_uname` LIKE ;
USE mybatisdb ;

DROP TABLE IF EXISTS `user` ;

CREATE TABLE `user` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Data for the table `user` */

INSERT INTO `user`(`id`,`uname`,`password`,`email`)
VALUES
(1,'lina','ok','lina@sina.com.cn'),
(2,'kate','ok','hello_kate@126.com'),
(3,'jiu','ok','jiujiu@126.com');

SELECT * FROM user;
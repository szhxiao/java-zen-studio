USE mybatisdb ;

DROP TABLE IF EXISTS `blog` ;

CREATE TABLE `blog` (
  `pk_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL COMMENT 'Title',
  `author` VARCHAR(30) NOT NULL COMMENT 'Author',
  `create_time` DATETIME NOT NULL COMMENT 'Create time',
  `views` INT(30) NOT NULL COMMENT 'Views',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Data for the table `blog` */

INSERT INTO `blog`(`pk_id`, `title`, `author`, `create_time`,`views`)
VALUES
(1,'Java Fundamentals','yaoguang','2022-09-03', 1500),
(2,'Java Advanced Features','kunlun','2022-10-01', 100),
(3,'Java Database','kaiyang','2022-11-10', 1890);

SELECT * FROM blog;

SELECT * FROM `blog` WHERE 1=1;
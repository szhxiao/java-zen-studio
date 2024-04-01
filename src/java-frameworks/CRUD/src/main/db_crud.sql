DROP DATABASE IF EXISTS crud;
CREATE DATABASE crud CHAR SET utf8;
USE crud ;

/* Table structure for table `t_department` */

CREATE TABLE `t_department` (
  `pk_dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `uk_dept_name` varchar(20) NOT NULL,
  PRIMARY KEY (`pk_dept_id`),
  UNIQUE KEY (`uk_dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Data for the table `t_department` */

INSERT INTO `t_department` (`pk_dept_id`,`uk_dept_name`)
VALUES 
(1,'开发部'),(2,'人事部'),(3,'测试部');


/* Table structure for table `t_employee` */

CREATE TABLE `t_employee` (
  `pk_emp_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(20) NOT NULL,
  `gender` enum ('MALE','FEMALE') NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_emp_id`),
  KEY `fk_dept_id` (`dept_id`),
  CONSTRAINT `fk_dept_id` FOREIGN KEY (`dept_id`) REFERENCES `t_department` (`pk_dept_id`)
--  UNIQUE KEY (`uk_uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*Data for the table `t_employee` */

INSERT INTO `t_employee`(`pk_emp_id`,`emp_name`,`gender`,`email`,`dept_id`)
VALUES
(1,'szhxiao','MALE','szhxiao@yeah.net',1),
(2,'kate','FEMALE','kate@126.com',2),
(3,'lina','FEMALE','lina@163.com',3);


-- Features test
INSERT INTO `t_department` (`uk_dept_name`)VALUES ('项目部');

SELECT `pk_emp_id` empId, `emp_name` empName, `gender`, `email`, `dept_id` 
FROM `t_employee` te WHERE `pk_emp_id` =1;

UPDATE `t_employee` SET `gender` = 'MALE',`email` = 'kate@qq.com' WHERE `pk_emp_id` = 2;

SELECT `te.pk_emp_id` empId, `te.emp_name` empName, `te.gender`, `te.email`, 
`te.dept_id`,`td.uk_dept_name` deptName 
FROM `t_employee` te LEFT JOIN `t_department` td 
ON `te.dept_id` = `td.pk_dept_id` 
WHERE te.pk_emp_id =1;


SELECT te.pk_emp_id, te.emp_name, te.gender, te.email,
        te.dept_id,td.uk_dept_name
        FROM t_employee te LEFT JOIN t_department td
        ON te.dept_id = td.pk_dept_id
        WHERE `pk_emp_id` = 1;



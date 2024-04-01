-- 约束

-- 查看表中约束
SELECT * FROM information_schema.TABLE_CONSTRAINTS tc 
WHERE TABLE_NAME = 'employees';

USE testdb;

-- 1. 非空约束
-- 1.1 创建表添加非空约束
CREATE TABLE t_not_null(
id INT NOT NULL,
name VARCHAR(15) NOT NULL,
email VARCHAR(25),
salary DECIMAL(10,2)
);

DESC t_not_null;

INSERT INTO t_not_null(id, name, email, salary)
VALUES (1, 'Tom', 'tom@126.com', 3400);

SELECT * FROM t_not_null;

-- 1.2 修改添加非空约束
ALTER TABLE t_not_null 
MODIFY email VARCHAR(25) NOT NULL;

-- 1.3 修改删除非空约束
ALTER TABLE t_not_null 
MODIFY email VARCHAR(25) NULL;

-- 2. 唯一性约束 
-- 限制某个字段或列的值不能重复

-- 2.1 创建表时添加约束
CREATE TABLE t_unique (
id INT UNIQUE,
name VARCHAR(15),
email VARCHAR(25),
salary DECIMAL(10,2),
-- 表级约束
CONSTRAINT uk_email UNIQUE(email)
);

DESC t_unique;

SELECT * FROM information_schema.TABLE_CONSTRAINTS tc 
WHERE TABLE_NAME = 't_unique';

INSERT INTO t_unique(id, name, email, salary)
VALUES (1, 'Tom', 'tom@126.com', 5200);

SELECT * FROM t_unique;

-- Duplicate entry '1' for key 't_unique.id'
-- INSERT INTO t_unique(id, name, email, salary)
-- VALUES (1, 'Tom', 'tom@126.com', 5200);

-- 可以向声明为UNIQUE的字段添加NULL值，且可以多次添加
INSERT INTO t_unique(id, name, email, salary)
VALUES (2, 'Jerry', NULL, 5300);

INSERT INTO t_unique(id, name, email, salary)
VALUES (3, 'Jerry', NULL, 5300); 

-- 2.2 修改添加唯一性约束
ALTER TABLE t_unique 
ADD CONSTRAINT uk_name UNIQUE(name);

ALTER TABLE t_unique 
MODIFY name VARCHAR(15) UNIQUE;

-- 2.3 复合唯一性约束
CREATE TABLE t_user(
id INT,
`name` VARCHAR(15),
`password` VARCHAR(20),
CONSTRAINT uk_t_user_name_pwd UNIQUE(`name`, `password`)
);

DESC t_user;

INSERT INTO t_user 
VALUES (1, 'Tom', 'abc');

SELECT * FROM t_user;

-- 案例：复合的唯一性约束案例
CREATE TABLE student (
	sid INT,
	sname VARCHAR(20),
	tel CHAR(11) UNIQUE KEY,
	cardid CHAR(18) UNIQUE KEY
);

CREATE TABLE course (
	cid INT,
	cname VARCHAR(20)
);

CREATE TABLE student_course (
	id INT,
	sid INT,
	cid INT,
	score INT,
	UNIQUE KEY (sid, cid)
);

INSERT INTO student
VALUES(1, '张三', '13710011002', '101223199012015623');

INSERT INTO student
VALUES(2, '李四', '13710011003', '101223199012015624');

INSERT INTO course 
VALUES(1001, 'Java'), ('1002', 'MySQL');

SELECT * FROM student;

SELECT * FROM course;

INSERT INTO student_course 
VALUES(1, 1, 1001, 89),
(2, 1, 1002, 90),
(3, 2, 1001, 88),
(4, 2, 1002, 56);

SELECT * FROM student_course;

-- 2.4 删除唯一性约束
-- 添加唯一性约束的列上也会自动创建唯一索引
-- 删除唯一约束只能通过删除唯一索引的方式删除
-- 删除时需要指定唯一索引名，唯一索引名就和唯一约束名一样
-- 如果创建唯一约束时未指定名称，如果是单列，就默认和列名相同；
-- 如果是组合列，默认和()中排在第一个的列名相同，也可以自定义唯一性约束名

SELECT * FROM information_schema.TABLE_CONSTRAINTS tc 
WHERE table_name = 't_unique';

-- 删除唯一性索引
ALTER TABLE t_unique 
DROP INDEX uk_name;

-- 3. PRIMARY KEY 约束
-- 主键约束相当于唯一约束和非空约束的组合
-- 一个表中只能有一个主键约束

-- 3.1 在创建表时添加主键约束
CREATE TABLE t_primary(
-- 列级约束
id INT PRIMARY KEY,
name VARCHAR(15),
email VARCHAR(25),
salary DECIMAL(10, 2)
);

CREATE TABLE t_primary(
id INT,
name VARCHAR(15),
email VARCHAR(25),
salary DECIMAL(10, 2),
-- 表级约束
-- MySQL的主键名总是PRIMARY，就算自己命名也没用
CONSTRAINT pk_id PRIMARY KEY(id)
);

SELECT * FROM information_schema.TABLE_CONSTRAINTS tc 
WHERE table_name = 't_primary';

INSERT INTO t_primary(id, name, email, salary)
VALUES (1, 'Tom', 'tom@126.com', 5200);

SELECT * FROM t_primary;

-- 3.2 修改表时添加主键约束
CREATE TABLE t_test_primary(
id INT,
name VARCHAR(15),
email VARCHAR(25),
salary DECIMAL(10, 2)
);

DESC t_test_primary;

ALTER TABLE t_test_primary 
ADD PRIMARY KEY (id);

-- 3.3 删除主键约束(实际开发中不会去删除主键约束)
LATER TABLE t_test_primary 
DROP PRIMARY KEY;

-- 4. 自增列：AUTO_INCREMENT
-- 4.1 创建表时添加自增列
CREATE TABLE t_auto_increment(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(15)
);

INSERT INTO t_auto_increment (name)
VALUES('Tom');
INSERT INTO t_auto_increment (name)
VALUES('Jerry');

SELECT * FROM t_auto_increment;

-- 4.2 修改表时添加自增列
ALTER TABLE table_name
MODIFY id INT AUTO_INCREMENT;

-- 4.3 删除自增列
ALTER TABLE table_name
MODIFY id INT; 

-- 4.4 MySQL 8.0新特性——自增变量的持久化
-- MySQL 8.0将自增主键的计数器持久化到重做日志中，
-- 每次计数器发生改变，都会将其写入重做日志中
-- 如果数据库重启，InnoDB会根据重做日志中的信息来初始化计数器的内存值

-- 5. 外键约束
-- 限定某个表的某个字段的引用完整性 
-- 主表：被引用的表，被参考的表
-- 从表：引用另人的表，参考别人的表

-- 5.1 创建表时添加外键约束
-- 先创建主表
CREATE TABLE t_dept(
dept_id INT,
dept_name VARCHAR(15)
);
-- 主表必须有主键约束或唯一性约束
ALTER TABLE t_dept 
ADD PRIMARY KEY (dept_id);

-- 再创建从表
CREATE TABLE t_empl(
emp_id INT PRIMARY KEY AUTO_INCREMENT,
emp_name VARCHAR(15),
dept_id INT,
-- 表级约束
CONSTRAINT fk_emp_dept_id FOREIGN KEY (dept_id) REFERENCES t_dept(dept_id)
);

DESC t_empl; 

SELECT * FROM information_schema.TABLE_CONSTRAINTS tc 
WHERE TABLE_NAME = 't_empl';

-- 5.2 外键效果
INSERT INTO t_dept 
VALUES (10, 'IT');

INSERT INTO t_empl 
VALUES(1001, 'Tom', 10);

SELECT * FROM t_empl te;

-- 5.3 修改表时添加外键约束
ALTER TABLE child_table_name
ADD CONSTRAINT fk_table_row_name FOREIGN KEY(row_name) REFERENCES table_name(row_name);

-- 5.4 约束等级
-- Casecade方式：在父表上update/delete记录时，同步update/delete掉子表的匹配记录
-- Set null方式：在父表上update/delete记录时，将子表上匹配记录的列设为null，但是要注意子表的外键列不能为not null
-- No action方式：如果子表中有匹配的记录，则不允许对父表对应候选键进行update/delete操作
-- Restrict方式：同no action，都是立即检查外键约束
-- Set default方式：父表有变更时，子表将外键列设置成一个默认的值，但Innodb不能识别

-- 对于外键约束，最好采用：NO UPDATE CASCADE ON DELETE RESTRICT的方式

-- 5.5 删除外键约束
-- 先删除外键约束
-- ALTER TABLE 从表名 DROP FOREIGN KEY 外键约束名
ALTER TABLE t_empl 
DROP FOREIGN KEY fk_emp_dept_id;

SELECT * FROM information_schema.TABLE_CONSTRAINTS tc 
WHERE TABLE_NAME = 't_empl';

-- 再删除外键约束对应的普通索引
SHOW INDEX FROM t_empl;
-- ALTER TABLE 从表名 DROP INDEX 索引名
ALTER TABLE t_empl 
DROP INDEX fk_emp_dept_id;

-- MySQL中的外键约束需要消耗系统资源，对于大并发的SQL操作，可能会不适合，
-- 建议在应用层面完成检查数据一致性的逻辑

-- CHECK约束
-- 检查某个字段的值是否符合要求，一般指值的范围

CREATE TABLE t_check(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(15),
salary DECIMAL(10, 2) CHECK(salary > 2000)
);

INSERT INTO t_check 
VALUES (1, 'Tom', 2500);

SELECT * FROM t_check;

-- Check constraint 't_check_chk_1' is violated.
INSERT INTO t_check 
VALUES (2, 'Jerry', 3500);

-- DEFAULT约束
-- 给某个字段/某列指定默认值
-- 一旦设置默认值，在插入数据时，如果此字段没有显式赋值，则使用默认值

-- 1. 创建表时指定默认值约束
CREATE TABLE t_default(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(15),
salary DECIMAL(10, 2) DEFAULT 2000.00
);

DESC t_default;

INSERT INTO t_default(id, name)
VALUES (1, 'Tom');

-- 2. 修改表时添加默认值约束
-- ALTER TABLE table_name
-- MODIFY row_name type DEFAULT default_value

CREATE TABLE t_default_alter(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(15),
salary DECIMAL(10, 2)
);

ALTER TABLE t_default_alter 
MODIFY salary DECIMAL(10, 2) DEFAULT 4500.00;

DESC t_default_alter;

-- 3. 删除约束
ALTER TABLE t_default_alter 
MODIFY salary DECIMAL(10, 2);
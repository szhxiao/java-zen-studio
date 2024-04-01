-- 创建和管理表

-- 创建和管理数据库
-- 1. 创建数据库
-- 方式1
CREATE DATABASE test1;

-- 方式2
CREATE DATABASE test2 CHARACTER SET '';

-- 方式3
-- 如果要创建的数据库已存在，则不受影响
-- 如果要创建的数据库不存在，则创建成功
CREATE DATABASE IF NOT EXISTS test3 CHARACTER SET 'utf8'

-- 2. 管理数据库
-- 查看当前连接中的数据库
SHOW DATABASES;

-- 切换数据库
USE databasename;

-- 查看当前使用的数据库
SELECT DATABASE() FROM DUAL;

-- 查看创建数据库的结构
SHOW CREATE DATABASE testdb;

-- 查看当前数据库中保存的数据表
SHOW TABLES;

-- 查看指定数据库中保存的数据表
SHOW TABLES FROM mysql;

-- 3. 修改数据库
-- 更改数据库字符集
ALTER DATABASE test2 CHARCTER SET 'utf8';

-- 4. 删除数据库
-- 方式1
DROP DATABASE test2;
-- 方式2（推荐）
DROP DATABASE IF EXISTS test2;


-- 创建和管理数据表
-- 1. 创建数据表
CREATE TABLE IF NOT EXISTS myempl(
id INT,
emp_name VARCHAR(15),
hire_date DATE
);

-- 查看表结构
DESC myempl;

-- 查看创建表的语句结构
SHOW CREATE TABLE myempl;

-- 查看全部表数据
SELECT * FROM employees e;

-- 基于现有表创建表，同时导入数据
CREATE TABLE myempl
AS 
SELECT * FROM employees e 
WHERE department_id = 100;

-- 练习1: 创建表employees_copy，实现对employees表的复制，包括表数据
CREATE TABLE employees_copy
AS
SELECT * FROM employees;

-- 练习2: 创建表employees_blank，实现对employees表的复制，不包括表数据
CREATE TABLE employees_blank
AS
SELECT * FROM employees
WHERE 1 = 2;

-- 2. 管理表

-- 修改表
-- 添加字段，默认添加至表的最后一个字段
ALTER TABLE myempl 
ADD salary DOUBLE(10, 2);

ALTER TABLE myempl 
ADD phone_number VARCHAR(20) SECOND;

-- 修改字段，数据类型、长度、默认值
ALTER TABLE myempl 
MODIFY first_name VARCHAR(25);

-- 重命名字段

ALTER TABLE myempl 
CHANGE salary monthly_salary DOUBLE(10,2);

-- 删除字段
ALTER TABLE myempl 
DROP COLUMN department_id;

-- 重命名表
RENAME TABLE myempl 
TO employees_finance;


-- 删除表，慎重操作（不仅删除表结构，同时删除表中的数据，释放表空间）
DROP TABLE IF EXISTS employees_blank;

-- 清空表，（清空表中所有数据，保留表结构）
TRUNCATE TABLE employees_copy;
SELECT * FROM employees_copy;

-- DCL中的COMMIT和ROLLBACK
-- COMMIT:提交数据，一旦提交成功，数据被永久保存在数据库中，数据不可回滚
-- ROLLBACK:回滚数据，一旦执行，可以实现数据回滚到最近的一次COMMIT之后

-- 对比TRUNCATE TABLE和DELETE FROM
-- 相同点：都可以实现对表中所有数据的删除，同时保留表结构
-- 不同点：
-- 		TRUNCATE TABLE:一旦执行操作，表数据全部清除，数据不可回滚
-- 		DELETE FROM:一旦执行操作，可以全部清除表数据（不带WHERE），可以实现数据回滚


-- DDL和DML
-- 	DDL操作一旦执行，数据不可回滚，慎重操作！
-- 	DML操作默认情况下一旦执行数据不可回滚，如果在执行前执行了 SET autocommit = FALSE ，则执行DML操作可以实现回滚

-- DELETE FROM
-- 1
COMMIT;
-- 2
SELECT * FROM employees_finance;
-- 3
SET autocommit = FALSE;
-- 4
DELETE FROM employees_finance;
-- 5
SELECT * FROM employees_finance;
-- 6
ROLLBACK;
-- 7
SELECT * FROM employees_finance;

-- TRUNCATE TABLE
-- 1
COMMIT;
-- 2
SELECT * FROM employees_finance;ge
-- 3
SET autocommit = FALSE;
-- 4
TRUNCATE TABLE employees_finance;
-- 5
SELECT * FROM employees_finance;
-- 6
ROLLBACK;
-- 7
SELECT * FROM employees_finance;


-- 测试MySQL8.0 DDL原子化
CREATE TABLE book (
book_id INT,
book_name VARCHAR(255)
);

SHOW TABLES;

DROP TABLE book;

SHOW TABLES;
-- 存储过程与函数

USE testdb;

-- 创建存储过程
-- 类型1:无参数，无返回值

-- 示例1:创建存储过程select_all_data()，查看employees表的所有数据
DELIMITER $

CREATE PROCEDURE select_all_data()
BEGIN
	SELECT * FROM employees;
END $

DELIMITER ;

-- 存储过程的调用

CALL select_all_data();

-- 示例2:创建存储过程avg_employee_salary()，返回所有员工的平均工资
DELIMITER $

CREATE PROCEDURE avg_employee_salary()
BEGIN
	SELECT AVG(salary) FROM employees;
END $

DELIMITER ;

CALL avg_employee_salary();

-- 示例3:创建存储过程max_salary()，查看employees表的最高薪资值
DELIMITER $

CREATE PROCEDURE max_salary()
BEGIN
	SELECT MAX(salary) FROM employees;
END $

DELIMITER ;

CALL max_salary();

-- 类型2:带OUT

-- 示例2:创建存储过程min_salary()，查看employees表的最低薪资值，
-- 并将最低薪资通过OUT参数ms输出

DESC employees;

DELIMITER $

CREATE PROCEDURE min_salary(OUT mins DOUBLE)
BEGIN
	SELECT MIN(salary) INTO mins 
	FROM employees;
END $

DELIMITER ;

-- 调用
CALL min_salary(@mins);

-- 查看变量值
SELECT @mins;

-- 类型3:带IN

-- 示例5:创建存储过程someone_salary()，查看employees表中某个员工的薪资
-- 并用IN参数empname输入员工姓名

DELIMITER $

CREATE PROCEDURE someone_salary(IN empname VARCHAR(20))
BEGIN
	SELECT salary FROM employees
	WHERE first_name = empname; 
END $

DELIMITER ;

-- 调用方式1
CALL someone_salary('Shelli');

-- 调用方式2
SET @empname := 'Shelli';
CALL someone_salary(@empname);

SELECT * FROM employees WHERE first_name = 'Shelli';

-- 类型4:带IN和OUT

-- 示例6:创建存储过程select_salary()，查看某个员工的薪资
-- 使用IN参数empname输入员工姓名，用OUT参数empsalary输出员工薪资

DELIMITER $

CREATE PROCEDURE select_salary(IN empname VARCHAR(20), OUT empsalary DOUBLE(10, 2))
BEGIN
	SELECT salary INTO empsalary
	FROM employees
	WHERE first_name = empname;
END $

DELIMITER ;

SET @empname = 'Valli';
CALL select_salary(@empname, @empsalary);
SELECT @empsalary;

SELECT * FROM employees WHERE first_name = 'Valli';

-- 类型5:带INOUT

-- 示例7:创建存储过程select_mgr_name()，查询某个员工领导姓名
-- 使用INOUT参数empname输入员工姓名，输出领导姓名

DELIMITER $

CREATE PROCEDURE select_mgr_name(INOUT empname VARCHAR(20))
BEGIN
	SELECT first_name INTO empname
	FROM employees
	WHERE employee_id = (
						SELECT manager_id
						FROM employees
						WHERE first_name = empname
	);
	
END $

DELIMITER $

SELECT * FROM employees e;

SET @empname := 'Lex';
CALL select_mgr_name(@empname);
SELECT @empname;

DESC employees;

-- 存储函数

-- 示例1:创建存储函数，名为email_by_name()，参数定义为空
-- 函数查询Abel的email，并返回，数据类型为字符串型
DELIMITER $

CREATE FUNCTION email_by_name()
RETURNS VARCHAR(25)
	DETERMINISTIC
	CONTAINS SQL
	READS SQL DATA
BEGIN
	RETURN (SELECT email FROM employees WHERE first_name = 'Bruce');
END $

DELIMITER ;

SELECT email_by_name();
SELECT email FROM employees WHERE first_name = 'Bruce';

-- 示例2:创建存储函数，名称为email_by_id()，参数传入emp_id, 
-- 该函数查询emp_id的email并返回，数据类型为字符串型
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $

CREATE FUNCTION email_by_id(emp_id INT)
RETURNS VARCHAR(25)

BEGIN
	RETURN (SELECT email FROM employees WHERE employee_id = emp_id);
END $	

DELIMITER ;

SELECT email_by_id(102);

-- 示例3:创建存储函数count_by_id()，参数传入dept_id，
-- 该函数查询dept_id部门的员工人数并返回，数据类型为整形
DELIMITER $

CREATE FUNCTION count_by_id(dept_id INT)
RETURNS INT

BEGIN
	RETURN (SELECT COUNT(*) FROM employees WHERE department_id = dept_id);
END $

DELIMITER ;

SELECT count_by_id(50);

-- 存储过程和函数的查看

-- 1. 使用SHOW CREATE语句查看创建信息
SHOW CREATE PROCEDURE someone_salary;

SHOW CREATE FUNCTION count_by_id;

-- 2. 使用SHOW STATUS语句查看存储过程和函数的状态信息
SHOW PROCEDURE STATUS;

SHOW PROCEDURE STATUS LIKE 'select_salary';

SHOW FUNCTION STATUS;

SHOW FUNCTION STATUS LIKE 'count_by_id';

-- 3. 从information_schema.Routines表中查看存储过程和函数的信息
SELECT * FROM information_schema.ROUTINES
WHERE ROUTINE_NAME = 'email_by_id';

-- 存储过程和函数的修改
-- 修改存储过程或函数，不影响存储过程或函数的功能，只是修改相关特性

-- 存储过程和函数的删除
DROP PROCEDURE IF EXISTS someone_salary;
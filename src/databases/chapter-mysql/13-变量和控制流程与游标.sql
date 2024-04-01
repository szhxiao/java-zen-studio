-- 变量、流程控制与游标

USE testdb;

CREATE TABLE employee_copy
AS
SELECT * FROM employees;

SELECT * FROM employee_copy;

-- 变量
-- 1. 系统变量

-- 1.1 查询系统变量
-- 查询全局系统变量
SHOW GLOBAL VARIABLES;

-- 查询会话系统变量
SHOW SESSION VARIABLES;

-- 默认查询会话系统变量
SHOW VARIABLES;

-- 查询部分系统变量
SHOW GLOBAL VARIABLES LIKE 'admin_%';

-- 查询指定系统变量
SELECT @@global.max_connections;
SELECT @@session.pseudo_thread_id;

-- 1.2 修改系统变量值

-- 全局系统变量
-- 针对当前数据库实例有效，一旦重启mysql服务则失效
SET @@global.max_connections = 161;
SET @@ GLOBAL max_connections = 171;

-- 会话系统变量
-- 针对当前会话有效，一旦重新建立新的会话则失效
SET @@session.character_set_client = 'utf8';

-- 2. 用户变量
-- 2.1 会话用户变量

SET @num1 = 1;
SET @num2 = 2;
SET @sum = @num1 + @num2;

SELECT @sum;

SELECT @count := COUNT(*) FROM employee_copy;
SELECT @count;

-- 局部变量
-- 使用DECLARE声明，
-- 在BEGIN...END中使用(存储过程或函数中)
-- DECLARE方式声明的局部变量必须在BEGIN中的首行位置

DELIMITER $

CREATE PROCEDURE test_var()
BEGIN
-- 	声明局部变量
	DECLARE a INT DEFAULT 0;
	DECLARE b INT;
	DECLARE emp_name VARCHAR(25);
	
-- 	变量赋值
	SET a = 1;
	SET b := 2;

	SELECT first_name INTO emp_name 
	FROM employee_copy
	WHERE employee_id = 101;

-- 	变量使用
	SELECT a, b, emp_name;
END $

DELIMITER ;

CALL test_var(); 

-- 定义条件

-- 示例1:定义Field_Not_Be_NULL错误名与MySQL中违反非空约束的错误类型
-- 方式1:使用MySQL_error_code
DECLARE Field_Not_Be_NULL CONDITION FOR 1048;

-- 方式2:使用sqlstate_value
DECLARE Field_Not_Be_NULL CONDITION FOR SQLSTATE '23000';

-- 示例2:定义ERROR 1148(42000)错误，名称为command_not_allowed
DECLARE command_not_allowed CONDITION FOR 1148;

DECLARE command_not_allowed CONDITION FOR SQLSTATE '42000';

-- 定义处理程序

-- 方式1:捕获sqlstate_value
DECLARE CONTINUE HANDLER FOR SQLSTATE '42S02' SET @info = 'NO_SUCH_TABLE';

-- 方式2:捕获mysql_error_value
DECLARE CONTINUE HANDLER FOR 1146 SET @info = 'NO_SUCH_TABLE';

-- 方式3:先定义条件，再调用
DECLARE no_such_table CONDITION FOR 1146;
DECLARE CONTINUE HANDLER FOR NO_SUCH_TABLE SET @info = ''NO_SUCH_TABLE;

-- 方式4:使用SQLWARNING
DECLARE EXIT HANDLER FOR SQLWARNING SET @info = 'ERROR';

-- 方式5:使用NOT FOUND
DECLARE EXIT HANDLER FOR NOT FOUND SET @info = 'NO_SUCH_TABLE';

-- 方式6:使用SQLEXCEPTION
DECLARE EXIT HANDLER FOR SQLEXCEPTION SET @info = 'ERROR';

-- 定义存储过程
DROP PROCEDURE UpdateDataNoCondition;

DELIMITER $

CREATE PROCEDURE UpdateDataNoCondition()
BEGIN
	DECLARE CONTINUE HANDLER FOR 1048 SET @pre_value = -1;
-- 	DECLARE CONTINUE HANDLER FOR SQLSTATE '23000' SET @pre_value = -1;

	SET @x = 1;
	UPDATE employee_copy SET email = NULL WHERE last_name = 'Abel';
	SET @x = 2;
	UPDATE employees SET email = 'abel' WHERE last_name = 'Abel';
	SET @x = 3;
	
END $

DELIMITER ;

CALL UpdateDataNoCondition();

SELECT @x, @pre_value;

-- 流程控制

-- 1. 分支结构
-- 1.1 if分支结构

DROP PROCEDURE test_if;

DELIMITER $

CREATE PROCEDURE test_if()
BEGIN
-- 	情况1:
-- 	DECLARE std_name VARCHAR(15);
-- 	
-- 	IF std_name IS NULL
-- 		THEN SELECT 'std_name is null';
-- 	END IF;
	
-- 	情况2:二选一
-- 	DECLARE email VARCHAR(25) DEFAULT 'username@163.com';
-- 
-- 	IF email IS NULL
-- 		THEN SELECT 'email is null';
-- 	ELSE
-- 		SELECT 'email is not null';
-- 	END IF;
	
-- 	情况3:多选一
-- 	DECLARE age INT DEFAULT 20;
-- 
-- 	IF age > 40
-- 		THEN SELECT '中老年';
-- 	ELSEIF age > 18
-- 		THEN SELECT '青壮年';
-- 	ELSE 
-- 		SELECT '青少年';
-- 	END IF;
END $

DELIMITER ;

CALL test_if();

-- 示例2：声明存储过程update_salary_by_empid，定义IN参数emp_id, 输入员工编号
-- 判断员工薪资如果低于8000并且入职时间超过5年，就涨薪500元，否则不变
DROP PROCEDURE update_salary_by_empid_if;

DELIMITER $

CREATE PROCEDURE update_salary_by_empid_if(IN emp_id INT)
BEGIN
	DECLARE emp_sal DOUBLE;
	DECLARE emp_hire_year DOUBLE;

	SELECT salary INTO emp_sal
	FROM employee_copy
	WHERE employee_id = emp_id;

	SELECT DATEDIFF(CURDATE(), hire_date)/365 INTO emp_hire_year
	FROM employees
	WHERE employee_id = emp_id;

	IF emp_sal < 8000 AND emp_hire_year >= 5
		THEN UPDATE employee_copy SET salary = salary + 500 WHERE employee_id = emp_id;
	END IF;
	
END $

DELIMITER ;

SELECT employee_id, DATEDIFF(CURDATE(), hire_date)/365, salary
FROM employee_copy
WHERE salary < 8000;

CALL update_salary_by_empid(104);

-- 1.2 CASE分支结构
DROP PROCEDURE test_case;

DELIMITER $

CREATE PROCEDURE test_case()
BEGIN
	DECLARE var INT DEFAULT 2;
	
	CASE var 
		WHEN 1 THEN SELECT 'var = 1';
		WHEN 2 THEN SELECT 'var = 2';
		ELSE SELECT 'other value';
	END CASE;
END $

DELIMITER ;

CALL test_case();

-- 示例1:声明存储过程update_salary_by_empid_case，定义IN参数emp_id，输入员工编号
-- 判断员工薪资如果低于9000，就更新薪资为9000；
-- 薪资大于等于9000且低于10000的，但是奖金比例为NULL的，就更新奖金比例为0.01
-- 其他的涨薪100元

DROP PROCEDURE update_salary_by_empid_case;

DELIMITER $

CREATE PROCEDURE update_salary_by_empid_case(IN emp_id INT)
BEGIN
	DECLARE emp_salary DOUBLE;
	DECLARE emp_bonus DOUBLE;
	
	SELECT salary INTO emp_salary
	FROM employee_copy ec 
	WHERE employee_id = emp_id;

	SELECT commission_pct INTO emp_bonus
	FROM employee_copy ec 
	WHERE employee_id = emp_id;
 
	CASE 
		WHEN emp_salary < 9000 
			THEN UPDATE employee_copy SET salary = 9000 WHERE employee_id = emp_id;
		WHEN emp_salary < 10000 AND emp_bonus IS NULL 
			THEN UPDATE employee_copy SET commission_pct = 0.01 
					WHERE employee_id = emp_id;
		ELSE UPDATE employee_copy SET salary = salary + 100 WHERE employee_id = emp_id;
	END CASE;
END $

DELIMITER ;

SELECT * FROM employee_copy ec
ORDER BY salary DESC;

SELECT * FROM employee_copy ec 
WHERE employee_id IN (103, 104, 105);

CALL update_salary_by_empid_case(103, 104, 105);

-- 2. 循环结构

-- 2.1 LOOP循环结构

DROP PROCEDURE test_loop;

DELIMITER $

CREATE PROCEDURE test_loop()
BEGIN 
	DECLARE num INT DEFAULT 1;
	DECLARE sum INT DEFAULT 0;
	
	loop_label:LOOP
		SET sum = sum + num;
		SET num = num + 1;
		IF num >= 100 THEN LEAVE loop_label;
		END IF;
	END LOOP loop_label;
	SELECT num, sum;
END $

DELIMITER ;

CALL test_loop();

-- 2.2 WHILE循环结构
-- 凡是循环结构，一定具备4个要素：初始化条件、循环条件、循环体、迭代条件

DROP PROCEDURE test_while;

DELIMITER $

CREATE PROCEDURE test_while()
BEGIN
	DECLARE num INT DEFAULT 1;
	DECLARE mul INT DEFAULT 1;

	WHILE num <= 5 DO
		SET mul = mul * num;
		SET num = num +1;
	END WHILE;
	
	SELECT num, mul;
END $

DELIMITER ;

CALL test_while; 

-- 2.3 REPEAT循环结构
DROP PROCEDURE test_repeat;

DELIMITER $

CREATE PROCEDURE test_repeat(IN num INT)

BEGIN 
	DECLARE total_sum INT DEFAULT 0;
	DECLARE i INT DEFAULT 1;

	REPEAT 
		SET total_sum = total_sum + i;
		SET i = i + 1;
	UNTIL i > num
	END REPEAT;
	
	SELECT total_sum;
END $

DELIMITER ;

CALL test_repeat(10); 

-- 3. LEAVE
-- 示例：创建存储过程leave_begin，声明INT类型参数num
-- 给BEGIN...END加标记名，并使用IF语句判断num参数的值
-- 如果num <= 0，则使用LEAVE语句退出
-- 如果num = 1，则查询平均薪资
-- 如果num = 2，则查询最低薪资
-- 如果num > 2，则查询最高薪资

DELIMITER $

CREATE PROCEDURE leave_begin(IN num INT)
begin_label:BEGIN
	IF num <= 0
		THEN LEAVE begin_label;
	ELSEIF num = 1
		THEN SELECT AVG(salary) FROM employee_copy ec;
	ELSEIF num = 2
		THEN SELECT MIN(salary) FROM employee_copy ec;
	ELSE
		SELECT MAX(salary) FROM employee_copy ec;
	END IF;
END $

DELIMITER ;

CALL leave_begin(5);

-- 4. ITERATE

DELIMITER $

CREATE PROCEDURE test_iterate()
BEGIN
	DECLARE num INT DEFAULT 0;

	loop_label:LOOP
		SET num = num + 1;
	
		IF num < 10
			THEN ITERATE loop_label;
		ELSEIF num > 15
			THEN LEAVE loop_label;
		END IF;	
		
		SELECT 'Keep Going';
	END LOOP;
	
	SELECT num;

END $
DELIMITER ;

CALL test_iterate();

-- 游标的使用
-- 步骤：声明游标、打开游标、使用游标、关闭游标

-- 示例：创建存储过程get_count_by_limit_total_salary()，声明IN参数limit_total_salary，DOUBLE类型，
-- 声明OUT参数total_count，INT类型，函数的功能可以实现累加薪资最高的几个员工的薪资值
-- 直到薪资总和达到limit_total_salary参数的值，返回累加的人数给total_count

DROP PROCEDURE get_count_by_limit_total_salary;

DELIMITER $

CREATE PROCEDURE get_count_by_limit_total_salary(IN limit_total_salary DOUBLE, OUT total_count INT)
BEGIN
-- 	记录累加总和
	DECLARE sum_salary DOUBLE DEFAULT 0.0;
-- 	记录每个员工工资
	DECLARE emp_salary DOUBLE;
-- 	记录累加人数
	DECLARE emp_count INT DEFAULT 0;

-- 	声明游标
	DECLARE emp_cursor CURSOR FOR SELECT salary FROM employee_copy ORDER BY salary DESC;
-- 	打开游标
	OPEN emp_cursor;

	REPEAT
		-- 	使用游标
		FETCH emp_cursor INTO emp_salary;
		
		SET sum_salary = sum_salary + emp_salary;
		SET emp_count = emp_count + 1;
		
		UNTIL sum_salary >= limit_total_salary
	END REPEAT;
	
	SET total_count = emp_count;

-- 	关闭游标
	CLOSE emp_cursor;
END $

DELIMITER ;

CALL get_count_by_limit_total_salary(200000, @total_count);
SELECT @total_count;
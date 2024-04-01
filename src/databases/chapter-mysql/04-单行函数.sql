-- 单行函数

-- 数值函数

-- 1.基本函数
-- abs 求绝对值
SELECT ABS(-123);
SELECT ABS(32);

-- sign 取符号，负数-1，正数1，0取0
SELECT SIGN(-23), SIGN(43), SIGN(0);

-- PI
SELECT PI();

-- round 四舍五入
SELECT ROUND(1.65);
SELECT ROUND(1.567, 2);
SELECT ROUND(123.456, -1);

-- ceil 向上取整，返回>=该参数的最小整数
SELECT CEIL (3.14);
SELECT CEIL (-2.01);

-- floor 向下取整，返回<=该参数的最大整数
SELECT FLOOR(9.99); 
SELECT FLOOR(-2.01); 

-- truncate 截断
SELECT TRUNCATE(2.38546, 2);
SELECT TRUNCATE(123.456, -1);

-- mod 取模
SELECT MOD (13, 5);

-- sqrt 开根号
SELECT SQRT(2);

-- rand 随机数
SELECT RAND(), RAND(), RAND(10), RAND(10), RAND(-1), RAND(-1);

-- least 返回最小值
SELECT LEAST(10, 8, 13, -11, -5);

-- greatest 返回最大值
SELECT GREATEST(10, 8, 13, -11, -5);

-- 2. 三角函数
-- 角度与弧度互换函数
-- RADIANS(x) 角度转化为弧度，x为角度值
-- DEGREE(x) 弧度转化为角度，x为弧度值
SELECT RADIANS(90);
SELECT RADIANS(180);
SELECT DEGREES(PI()/2);
SELECT DEGREES(PI());

-- sin 正弦值
SELECT SIN(RADIANS(30));
SELECT (SQRT(2)/2);
SELECT SIN(RADIANS(45));

-- asin 反正弦值
SELECT DEGREES(ASIN(1));

-- cos 余弦值
SELECT COS(RADIANS(60)) ;
SELECT (SQRT(3)/2);
SELECT COS(RADIANS(30));

-- acos 反余弦值
SELECT DEGREES(ACOS(0.5));

-- tan 正切值
SELECT TAN(RADIANS(45));

-- atan 反正切值
SELECT DEGREES(ATAN(1));
SELECT DEGREES(ATAN(SQRT(3)));

-- 3. 指数和对数函数
SELECT POW(2, 5),POWER(2, 4), EXP(2);
SELECT LN(EXP(2)), LOG2(16);

-- 4. 进制转换
SELECT BIN(10), HEX(10);
SELECT CONV(10, 2, 10);


-- 字符函数

-- char_length 字符长度
SELECT CHAR_LENGTH('bilibili');
SELECT CHAR_LENGTH('学习函数');

-- length 获取参数值字节数
SELECT  LENGTH ('China');
SELECT  LENGTH ('中国');

-- concat拼接字符串
SELECT CONCAT(emp.last_name, ' worked for ', mgr.last_name) 
FROM employees emp JOIN employees mgr 
WHERE emp.manager_id = mgr.employee_id;

SELECT CONCAT_WS(' - ', 'hello', 'world', 'yaoguang');

-- INSERT 替换字符
-- 字符串索引从1开始
SELECT INSERT('hello world', 2, 3, 'aaaa');

-- replace
SELECT REPLACE ('The project keeps track of your progress', 'project', 'program');

-- upper, lower
SELECT UPPER('china');
SELECT LOWER('KEEP GOING');

-- substr,索引从1开始多表查询
SELECT SUBSTR('碧血剑', 1, 2) out_put; 

-- left, right
SELECT LEFT ('hello', 2), RIGHT('world', 3);

-- instr
SELECT INSTR('西北望，射天狼', '天狼');  

-- lpad用指定的字符实现左填充指定长度，实现右对齐
SELECT LPAD('endure', 10, '-'); 

-- rpad用指定的字符实现右填充指定长度，实现左对齐
SELECT RPAD('going', 10, '*');

-- trim
SELECT LENGTH(TRIM('     蓦然回首       '));
SELECT TRIM('hello' FROM 'hello那人却在灯火阑珊处hellohello');

-- repeat
SELECT REPEAT('hello', 4);

-- space
SELECT LENGTH(SPACE(5));

-- locate
SELECT LOCATE('l', 'hello world');

-- field
SELECT FIELD('mm', 'gg', 'jj', 'mm', 'dd', 'nn');

-- elt
SELECT  ELT(2, 'a', 'b', 'c', 'd');



-- 日期时间函数
-- 1. 获取时间、日期
-- curdate()，返回当前系统日期，只包含年月日
SELECT CURDATE(); 
SELECT CURRENT_DATE();

-- curtime()，返回当前时间，只包含时分秒
SELECT CURTIME();
SELECT CURRENT_TIME();

-- now()，返回当前系统日期和时间
SELECT NOW(); 
SELECT SYSDATE();
SELECT CURRENT_TIMESTAMP();
SELECT LOCALTIME();
SELECT LOCALTIMESTAMP();
SELECT UTC_TIMESTAMP();

-- 2. 日期与时间戳的转换
SELECT UNIX_TIMESTAMP();
SELECT FROM_UNIXTIME(1657615561);

-- str_to_date 将字符转换为日期
SELECT STR_TO_DATE ('2021-12-10','%Y-%c-%d') AS 时间

-- date_format 将日期转换为字符串
SELECT DATE_FORMAT(NOW(), '%y年%m月%d日') AS out_put; 

-- 3. 获取月份、星期、天数等
SELECT YEAR(CURDATE()), MONTH(CURDATE()), DAY(CURDATE());

SELECT MONTHNAME('2022-07-12'), DAYNAME(CURDATE());

-- 4. 日期操作函数
SELECT EXTRACT(DAY FROM NOW());
SELECT EXTRACT(HOUR_MINUTE FROM NOW());

-- 5. 时间和秒钟的转换函数
SELECT TIME_TO_SEC(CURTIME());
SELECT SEC_TO_TIME(45377);

-- 6. 计算日期和时间函数
SELECT NOW(), DATE_ADD(NOW(), INTERVAL 1 YEAR);
SELECT NOW(), DATE_SUB(NOW(), INTERVAL 1 DAY);

-- 7. 日期的格式化和解析
SELECT DATE_FORMAT(CURDATE(), '%Y-%M-%D');
SELECT DATE_FORMAT(NOW(), '%y-%m-%d');
SELECT TIME_FORMAT(CURTIME(), '%H:%i:%s');

SELECT STR_TO_DATE('2022-07-12 20:56:45', '%Y-%m-%d %H:%i:%s');

SELECT GET_FORMAT(DATE, 'USA');
SELECT DATE_FORMAT(CURDATE(), GET_FORMAT(DATETIME, 'ISO'));

-- 流程控制函数

-- IF函数
SELECT IF (3>2, '大', '小');

SELECT employee_id, first_name, salary,
IF(salary >= 6000, '高工资', '低工资') details
FROM employees;

-- IFNULL
SELECT employee_id, first_name, commission_pct,
IFNULL(commission_pct, 0) details
FROM employees;

-- CASE WHEN .. WHEN ... THEN 函数
SELECT employee_id, first_name, salary,
CASE WHEN salary >= 15000 THEN '白骨精'
	 WHEN salary >= 10000 THEN '潜力股'
	 WHEN salary >= 8000 THEN '小屌丝'
	 ELSE '草根'
END details
FROM employees;


SELECT employee_id, first_name, salary,
CASE
WHEN salary <= 3000 THEN 'C'
WHEN salary <= 5000 THEN 'B'
-- ELSE 'A' -- ELSE 可省略
END AS 待遇级别
FROM employees;

-- 练习：查询部门为10，20，30的员工信息，
-- 若部门号为10，则打印其工资的1.1倍
-- 若部门号为20，则打印其工资的1.2倍
-- 若部门号为30，则打印其工资的1.3位
-- 若其他部门，打印其原工资
SELECT employee_id, first_name, department_id, salary,
CASE department_id WHEN 10 THEN salary * 1.1
				   WHEN 20 THEN salary * 1.2
				   WHEN 30 THEN salary * 1.3
				   ELSE salary
END detials
FROM employees;

-- 练习：查询部门为10，20，30的员工信息，
-- 若部门号为10，则打印其工资的1.1倍
-- 若部门号为20，则打印其工资的1.2倍
-- 若部门号为30，则打印其工资的1.3位
SELECT employee_id, first_name, department_id, salary,
CASE department_id WHEN 10 THEN salary * 1.1
				   WHEN 20 THEN salary * 1.2
				   WHEN 30 THEN salary * 1.3
END detials
FROM employees
WHERE department_id IN(10, 20, 30);

-- 加密解密函数
SELECT MD5('mysql'), SHA('mysql');

-- 信息函数
SELECT VERSION();
SELECT CONNECTION_ID();
SELECT USER();
SELECT DATABASE();

-- BENCHMARK()用于测试表达式的执行效率
SELECT BENCHMARK(10000000, SHA('mysql'))
FROM DUAL;
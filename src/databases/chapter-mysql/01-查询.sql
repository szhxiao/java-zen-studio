-- 查询

-- 基础查询
-- 1. 查询表中的单个字段
SELECT name FROM student_inf;

-- 2. 查询表中的多个字段
SELECT first_name, last_name, job_id FROM employees;

-- 3. 查询表中所有字段
SELECT * FROM employees;

-- 4. 查询常量值
SELECT  '疯狂Java讲义';

-- 5. 查询表达式
SELECT 25*25;

-- 6. 查询函数
SELECT VERSION();

-- 7. 为字段命名别名
SELECT first_name AS 姓, last_name AS 名  FROM employees;
SELECT VERSION() 版本;
SELECT 15*15 AS "out put";

-- 8. 去重
SELECT DISTINCT department_id FROM employees;

-- 9. 空值参与运算
-- 空值参与运算，结果一定为空，实际解决使用IFNULL
SELECT employee_id, salary AS '月工资', 
salary * (1 + IFNULL(commission_pct, 0)) * 12 AS '年工资', 
commission_pct 
FROM employees;

-- 10. 着重号
SELECT * FROM `order`;

--  11. 字段连接
SELECT CONCAT(student_id, ' -> ',  name) AS "学生信息"  FROM student_inf;

-- 12. 显示表结构
DESCRIBE employees;
DESC countries;

-- 练习. 计算12个月的基本工资和奖金
SELECT employee_id, last_name, 
salary * 12 * (1 + IFNULL(commission_pct, 0)) AS "ANNUAL SALARY"
FROM employees;
-- 练习. 查询employees表中去除重复的job_id后的数据
SELECT DISTINCT job_id FROM employees;


-- 条件查询
-- 1. 按条件表达式筛选
SELECT * FROM employees WHERE last_name = 'King';
SELECT * FROM employees WHERE salary > 10000;

-- 2. 按逻辑表达式筛选
SELECT enrolment_id, semester, `year` FROM enrolment_inf WHERE student_id >= 20050232 AND course_code <= 3;

-- 练习. 查询工资大于12000的员工姓名和工资
SELECT first_name, last_name, salary 
FROM employees
WHERE salary > 12000;
-- 练习. 查询员工号为176的员工姓名和部门号
SELECT first_name, last_name, department_id 
FROM employees
WHERE employee_id = 176;

-- 3. 模糊查询
-- like, 可以进行模式匹配
SELECT * FROM course_inf ci WHERE name LIKE '疯狂%';
SELECT * FROM course_inf ci WHERE name LIKE '%Java%';
-- between and，包含值域
SELECT * FROM student_inf si WHERE student_id BETWEEN 20050232 AND 20050233;
-- in,列表值类型必须一致或兼容
SELECT enrolment_id, student_id FROM enrolment_inf ei WHERE course_code IN ('002');
-- is null, 
-- is not null
-- 安全等于<=>，可读性不高
SELECT student_id FROM enrolment_inf ei WHERE course_code <=> 3;


-- 排序查询
-- 使用ORDER BY对查询到的数据进行排序操作
-- ASC(ascend)代表升序，DESC(descend)代表降序，默认升序
SELECT employee_id, first_name, last_name, salary
FROM employees e 
ORDER BY salary DESC; 

-- 列的别名只能在 ORDER BY 中使用
SELECT employee_id, first_name, salary, salary * 12 annual_sal
FROM employees e 
ORDER BY annual_sal;

-- WHERE 应声明在FROM之后，ORDER BY之前
SELECT employee_id, first_name, last_name, salary
FROM employees e 
WHERE department_id IN (50, 60, 70)
ORDER BY department_id DESC;

-- 二级排序
-- 显示员工信息，按department_id的降序排列，salary的升序排列
SELECT employee_id, first_name, last_name, salary, department_id 
FROM employees e 
ORDER BY department_id DESC, salary ASC;


-- 分页
-- MySQL使用limit实现数据分页显示

-- 每面显示20条记录，显示第1页
SELECT employee_id, first_name, last_name, salary
FROM employees e 
LIMIT 0, 20;

-- 每面显示20条记录，显示第2页
SELECT employee_id, first_name, last_name, salary
FROM employees e 
LIMIT 20, 20;

-- SELECT 字段名
-- FROM 表名
-- LIMIT (pageNo-1) * pageSize, pageSize

-- WHERE, ORDER BY, LIMIT声明顺序
SELECT employee_id, first_name, last_name, salary 
FROM employees e 
WHERE salary > 6000
ORDER BY salary DESC
LIMIT 0, 20;

-- MySQL 新特性： LIMIT ... OFFSET ...
SELECT employee_id, first_name, last_name, salary
FROM employees e 
LIMIT 2 OFFSET 31;
--  视图

-- 创建视图

-- 1. 针对于单表

CREATE VIEW v_empl
AS
SELECT employee_id, first_name, email, salary
FROM employees;

SELECT * FROM v_empl; 

-- 小括号内字段个数与SELECT中字段个数相同 
CREATE VIEW v_empl2(emp_id, name, monthly_salary)
AS 
SELECT employee_id, first_name, salary
FROM employees
WHERE salary > 8000;

SELECT * FROM v_empl2;

CREATE VIEW v_emp_sal
AS
SELECT department_id, AVG(salary) avg_sal
FROM employees e 
WHERE department_id IS NOT NULL 
GROUP BY department_id;

SELECT * FROM v_emp_sal;

-- 2. 针对多表
CREATE VIEW v_emp_dept
AS
SELECT e.employee_id, e.first_name, e.department_id, d.department_name  
FROM employees e JOIN departments d 
ON e.department_id = d.department_id;

SELECT * FROM v_emp_dept;

-- 场景：复用视图进行数据格式化
CREATE VIEW v_emp_info
AS
SELECT CONCAT(e.first_name, '(', d.department_name, ')') emp_info
FROM employees e JOIN departments d 
ON e.department_id = d.department_id;

SELECT * FROM v_emp_info;

-- 3. 基于视图创建视图

-- 查看视图
-- 1. 查看数据库的表对象、视图对象
SHOW TABLES;

-- 2. 查看视图结构
DESCRIBE v_emp_dept_info;

-- 3. 查看视图的属性信息
SHOW TABLE STATUS LIKE 'v_emp_dept_info';

-- 4. 查看视图的详细定义信息
SHOW CREATE VIEW v_emp_dept_info;

-- 更新视图中的数据
-- 1. 一般情况下，可以更新视图数据
SELECT * FROM v_empl;
SELECT employee_id, first_name, email, salary
FROM employees;

-- 更新视图数据，会导致基表中数据的修改
UPDATE v_empl 
SET salary = 20000
WHERE employee_id = 101;

-- 更新基表数据，视图数据同步修改
UPDATE employees 
SET salary = 17000
WHERE employee_id = 101;

-- 2. 不能更新视图中的数据
-- The target table v_emp_sal of the UPDATE is not updatable
UPDATE v_emp_sal 
SET avg_sal = 5000
WHERE department_id = 30;

-- 虽然可以更新视图数据，但总的来说，视图作为虚拟表，主要用于方便查询，不建议更新视图数据
-- 对视图数据的更改，都是通过对实际数据表里数据的操作来完成的

-- 修改视图
DESC v_emp_dept_info;

-- 方式1
CREATE OR REPLACE VIEW v_emp_dept_info 
AS 
SELECT e.employee_id, e.first_name, e.email, e.salary, d.department_name
FROM employees e JOIN departments d 
ON e.department_id = d.department_id;

SELECT * FROM v_emp_dept_info;

-- 方式2
ALTER VIEW v_empl2
AS 
SELECT employee_id, first_name, email, salary, hire_date
FROM employees;

SELECT * FROM v_empl2;

-- 删除视图

SHOW TABLES;

DROP VIEW v_epm_info;

DROP VIEW IF EXISTS v_empl2;
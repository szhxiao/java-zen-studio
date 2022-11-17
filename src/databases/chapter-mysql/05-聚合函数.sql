-- 聚合函数

-- 1. 常见的聚合函数
-- SUM() 只适用于数值类型的字段
SELECT SUM(salary) FROM employees;

-- AVG() 只适用于数值类型的字段
SELECT AVG(salary) FROM employees;

-- MAX()
SELECT MAX(salary) FROM employees;
SELECT MAX(first_name) FROM employees;
SELECT MAX(hire_date) FROM employees;

-- MIN()
SELECT MIN(salary) FROM employees;
SELECT MIN(first_name) FROM employees;
SELECT MIN(hire_date) FROM employees;

-- COUNT() 计算指定字段在查询结果中出现的个数
SELECT COUNT(employee_id) FROM employees;
SELECT COUNT(salary) FROM employees;

SELECT commission_pct 
FROM employees
WHERE commission_pct IS NOT NULL;
-- 计算指定字段出现的个数时，不计算NULL值
SELECT COUNT(commission_pct) FROM employees;

-- 使用InnoDB存储引擎时，COUNT(*)效率最高
SELECT COUNT(*) FROM employees;

SELECT AVG(commission_pct), SUM(commission_pct)/COUNT(commission_pct),
SUM(commission_pct) / COUNT(*) 
FROM employees;

-- 2. GROUP BY 的使用
-- 查询各个部门的平均工资
SELECT department_id, AVG(salary) 
FROM employees
GROUP BY department_id;

-- 查询各个job_id的平均工资
SELECT job_id, AVG(salary) 
FROM employees
GROUP BY job_id;

-- 查询各个department_id, job_id的平均工资
SELECT department_id, job_id, AVG(salary) 
FROM employees
GROUP BY department_id, job_id;
-- 或
SELECT job_id, department_id, AVG(salary) 
FROM employees
GROUP BY job_id, department_id;

-- 结论1: SELECT 中出现的非组函数的字段必须声明在GROUP BY中；
-- 反之，GROUP BY 中声明的字段可以不出现在SELECT中。
-- 结论2: GROUP BY 声明在FROM后、WHERE后，ORDER BY 前面、LIMIT 前面
-- 结论3: GROUP BY中使用WITH ROLLUP

SELECT department_id, AVG(salary) 
FROM employees
GROUP BY department_id WITH ROLLUP;

-- 3. HAVING
-- 如果过滤条件中使用了聚合函数，必须使用HAVING来替换WHERE
-- HAVING 在开发中一般配合 GROUP BY使用
-- 必须声明在 GROUP BY 的后面

-- 查询各个部门中最高工资比10000高的部门信息
SELECT department_id, MAX(salary) 
FROM employees e 
GROUP BY department_id
HAVING MAX(salary) > 10000;

-- 当过滤条件中有聚合函数时，此聚合条件必须声明在HAVING中
-- 当过滤条件中没有聚合函数时，则过滤条件声明在WHERE中或HAVING中都可以，
-- 建议声明在WHERE中

-- 查询id为10，20，30，40的部门中最高工资比10000高的部门信息
-- 方式1，推荐使用，执行效率高
SELECT department_id, MAX(salary) 
FROM employees e 
WHERE department_id IN (10, 20, 30, 40)
GROUP BY department_id
HAVING MAX(salary) > 10000;
-- 方式2
SELECT department_id, MAX(salary) 
FROM employees e 
GROUP BY department_id
HAVING MAX(salary) > 10000 AND department_id IN (10, 20, 30, 40);
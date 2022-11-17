-- 多表查询

DESC employees;

DESC locations;

-- 出现笛卡尔积的错误
SELECT employee_id, department_name
FROM employees, departments;

-- 多表查询需要有连接条件
SELECT employee_id, first_name, last_name, department_name
FROM employees, departments
WHERE employees.department_id = departments.department_id ; 

-- 如果查询语句中出现了多个表中都存在的字段，则必须指明此字段所在的表
-- SQL优化的角度，建议多表查询时，每个字段前都指明其所在表
SELECT emp.employee_id, emp.first_name, emp.department_id, dept.department_name
FROM employees emp, departments dept
WHERE emp.department_id = dept.department_id ; 

-- 如果有n个表实现多表查询，需要至少n-1个连接条件
SELECT emp.employee_id, emp.last_name, dept.department_name, l.city
FROM employees emp, departments dept, locations l
WHERE emp.department_id = dept.department_id 
AND dept.location_id = l.location_id;

-- 多表查询分类
/* 
 * 1. 等值连接与非等值连接
 * 2. 自连接和非自连接
 * 3. 内连接和外连接
 */

-- 非等值连接
SELECT *
FROM job_grades jg;

SELECT e.first_name, e.salary, jg.grade_level
FROM employees e , job_grades jg 
WHERE e.salary BETWEEN jg.lowest_sal AND jg.highest_sal
ORDER BY e.salary DESC;

-- 自连接
SELECT * FROM employees e;

-- 查询员工id、员工姓名及其管理者的id和姓名
SELECT emp.employee_id, emp.first_name Employee, mgr.employee_id, mgr.first_name Manager
FROM employees emp, employees mgr
WHERE emp.manager_id = mgr.employee_id;

-- 内连接：合并具有同一列的两个以上的表的行，结果集中不包含一个表与另一个表不匹配的行
-- 外连接：合并具有同一列的两个以上的表的行，结果集中除了包含一个表与另一个表匹配的行
--        还查询到了左表或右表中不匹配的行
-- 外连接分为：左外连接，右外连接，满外连接

-- 查询所有员工的first_name, department_name信息
SELECT emp.employee_id, emp.first_name, emp.department_id, dept.department_name
FROM employees emp, departments dept
WHERE emp.department_id = dept.department_id ;

-- SQL99语法
-- 使用JOIN ... ON 方式实现多表查询

-- SQL99实现内连接
SELECT employee_id, first_name, department_name
-- FROM employees e INNER JOIN departments d 
FROM employees e JOIN departments d 
ON e.department_id = d.department_id;

SELECT employee_id, first_name, department_name, city
FROM employees e JOIN departments d 
ON e.department_id = d.department_id 
JOIN locations l 
ON d.location_id = l.location_id;

-- SQL99实现外连接
-- 左外连接
SELECT employee_id, first_name, department_name
-- FROM employees e LEFT OUTER JOIN departments d 
FROM employees e LEFT JOIN departments d 
ON e.department_id = d.department_id;

-- 右外连接
SELECT employee_id, first_name, department_name
FROM employees e RIGHT JOIN departments d 
ON e.department_id = d.department_id;

-- 满外连接

-- MySQL不支持FULL满外连接
-- SELECT employee_id, first_name, department_name
-- FROM employees e FULL JOIN departments d 
-- ON e.department_id = d.department_id;

-- UNION 和 UNION ALL的使用
-- UNION会执行去重操作
-- UNION ALL 不会执行去重操作
-- 如果明确知道合并数据后的结果数据不存在重复数据，或者不需要去除重复数据，
-- 尽量使用UNION ALL语句，以提高查询效率

-- 内连接
SELECT employee_id, first_name, department_name
FROM employees e JOIN departments d 
ON e.department_id = d.department_id;

-- 左外连接
SELECT employee_id, first_name, department_name
FROM employees e LEFT JOIN departments d 
ON e.department_id = d.department_id;

-- 右外连接
SELECT employee_id, first_name, department_name
FROM employees e RIGHT JOIN departments d 
ON e.department_id = d.department_id;

SELECT employee_id, first_name, department_name
FROM employees e LEFT JOIN departments d 
ON e.department_id = d.department_id
WHERE d.department_id IS NULL;

SELECT employee_id, first_name, department_name
FROM employees e RIGHT JOIN departments d 
ON e.department_id = d.department_id
WHERE e.department_id IS NULL;

-- 满外连接
SELECT employee_id, first_name, department_name
FROM employees e LEFT JOIN departments d 
ON e.department_id = d.department_id
UNION ALL
SELECT employee_id, first_name, department_name
FROM employees e RIGHT JOIN departments d 
ON e.department_id = d.department_id
WHERE e.department_id IS NULL;
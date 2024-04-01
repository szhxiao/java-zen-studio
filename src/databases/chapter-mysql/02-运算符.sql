-- 运算符

-- 1. 算术运算符
-- +, -, \*, /, % =
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE employee_id % 2 = 0;

-- 2. 比较运算符
-- 2.1 = <=>, <>, !=, <, <=, >, >=
-- 字符串存在隐匿转换，如果转换数值不成功，则视为 0
SELECT 1 = 2, 1 != 2, 1 = '1', 1 = 'a', 0 = 'a'
FROM DUAL;
-- 两边都是字符串时，按照 ANSI 的比较规则进行比较
SELECT 'a' = 'a', 'ab' = 'ab', 'a' = 'b'
FROM DUAL;
-- 有 NULL 参与比较，结果为 NULL
SELECT 1 = NULL, NULL = NULL
FROM DUAL;

SELECT first_name, last_name, salary
FROM employees e
WHERE salary = 6000;
-- WHERE commission_pct = NULL;

-- <=>为 NULL 而生
SELECT 1 <=> NULL, NULL <=> NULL
FROM DUAL;

-- 练习：查询 employees 表中 commission_pct 为 NULL 的数据
SELECT first_name, last_name, salary
FROM employees e
WHERE commission_pct <=> NULL;

-- 2.2 关键字
-- IS NULL, IS NOT NULL, ISNULL
SELECT first_name, last_name, salary
FROM employees e
WHERE commission_pct IS NULL;

SELECT first_name, last_name, salary
FROM employees e
WHERE ISNULL(commission_pct);

SELECT first_name, last_name, salary
FROM employees e
WHERE commission_pct IS NOT NULL;

-- LEAST() GREATEST()
SELECT LEAST('g', 'b', 't', 'm'), GREATEST('g', 'b', 't', 'm')
FROM DUAL;

SELECT LEAST(first_name, last_name)
FROM employees;

-- BETWEEN 条件下界 AND 条件上界 (包含边界)
SELECT employee_id, first_name, last_name,salary
FROM employees e
WHERE salary BETWEEN 6000 AND 8000;

SELECT employee_id, first_name, last_name,salary
FROM employees e
WHERE salary NOT BETWEEN 6000 AND 8000;

-- IN(set), NOT IN(set)
SELECT employee_id, first_name, last_name, salary, department_id
FROM employees e
WHERE department_id IN (10, 20, 30);

SELECT employee_id, first_name, last_name, salary
FROM employees e
WHERE salary NOT IN (6000, 7000, 8000);

-- LIKE 模糊查询
-- % 代表不确定个数的字符（0， 1， 或多个）
-- 查询 last_name 中包含字符'a'的员工信息
SELECT employee_id, first_name, last_name, salary
FROM employees e
WHERE first_name LIKE '%a%';

-- 查询 last_name 中以字符'a'开头的员工信息
SELECT employee_id, first_name, last_name, salary
FROM employees e
WHERE first_name LIKE 'a%';

-- 查询 last_name 中包含字符'a'且包含字符'e'的员工信息
SELECT employee_id, first_name, last_name, salary
FROM employees e
WHERE first_name LIKE '%a%' AND first_name LIKE '%e%';

-- \_代表一个不确定的字符
-- 查询第 2 个字符是'a'的员工信息
SELECT employee_id, first_name, last_name, salary
FROM employees e
WHERE first_name LIKE '\_a%';

-- REGEXP, RLIKE 正则表达式

-- 3. 逻辑运算符
SELECT employee_id, first_name, last_name, salary, department_id
FROM employees e
WHERE department_id = 10 OR department_id = 20;

SELECT employee_id, first_name, last_name, salary, department_id
FROM employees e
WHERE department_id = 50 AND salary > 6000;

SELECT employee_id, first_name, last_name, salary, department_id
FROM employees e
WHERE department_id = 50 XOR salary > 6000;

-- 4. 位运算符

-- 子查询

-- 1. 需求：谁的工资比Abel高？
-- 方式1
SELECT last_name, salary
FROM employees
WHERE last_name = 'Abel';

SELECT employee_id, last_name, salary
FROM employees
WHERE salary > 11000;

-- 方式2
SELECT e2.employee_id, e2.last_name, e2.salary
FROM employees e1, employees e2
WHERE e2.salary > e1.salary 
AND e1.last_name = 'Abel';

-- 方式3:子查询
SELECT employee_id, last_name, salary
FROM employees
WHERE salary > (
				SELECT salary
				FROM employees
				WHERE last_name = 'Abel'
);

-- 规范：外查询（或主查询）、内查询（或子查询）
-- 子查询在主查询之前一次执行完成
-- 子查询的结果被主查询使用
-- 注意：1. 子查询要包含在括号内
-- 	    2. 将子查询放在比较条件的右侧
-- 	    3. 单行操作符对应单行子查询、多行操作符对应多行子查询
-- 子查询分类：单行子查询、多行子查询


-- 2. 单行子查询
-- 单行操作符：= > >= < <=
-- 查询工资大于149号员工工资的员工信息
SELECT employee_id, first_name, salary 
FROM employees
WHERE salary > (
				SELECT salary 
				FROM employees
				WHERE employee_id = 149
);

-- 查询job_id与141号员工相同，salary比143号员工多的员工姓名，job_id和工资
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE job_id = (
				SELECT job_id 
				FROM employees
				WHERE employee_id = 141
				) 
AND salary > (
				SELECT salary
				FROM employees
				WHERE employee_id = 143
			 );
			 
-- 查询公司工资最少的员工的last_name,job_id和salary
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary = (
				SELECT MIN(salary) 
				FROM employees
				);
				
-- 查询与141号员工的manager_id和department_id相同的其他员工的
-- employee_id, manager_id, department_id
SELECT employee_id, manager_id, department_id
FROM employees
WHERE manager_id = (
					SELECT manager_id 
					FROM employees
					WHERE employee_id = 141
					)
AND department_id = (
					 SELECT department_id 
					 FROM employees
					 WHERE employee_id = 141
					 )
AND employee_id <> 141;

-- 查询最低工资大于50号部门最低工资的部门id和其最低工资
SELECT department_id, MIN(salary) 
FROM employees
WHERE department_id IS NOT NULL 
GROUP BY department_id 
HAVING MIN(salary) > (
					  SELECT MIN(salary) 
					  FROM employees
					  WHERE department_id = 50
					  );
					  
-- 3. 多行子查询
-- 多行子查询操作符：IN ANY ALL SOME
SELECT employee_id, first_name
FROM employees
WHERE salary IN (
				 SELECT MIN(salary)
				 FROM employees
				 GROUP BY department_id
				);
				
-- 查询其他job_id中比job_id为IT_PROG部门任一工资低的
-- 员工的员工号、姓名、job_id及salary
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE salary < ANY (
					SELECT salary 
					FROM employees
					WHERE job_id = 'IT_PROG'
					)
AND job_id <> 'IT_PROG';

-- 查询其他job_id中比job_id为IT_PROG部门所有工资低的
-- 员工的员工号、姓名、job_id及salary
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE salary < ALL (
					SELECT salary 
					FROM employees
					WHERE job_id = 'IT_PROG'
					)
AND job_id <> 'IT_PROG';

-- 查询平均工资最低的部门id
-- 方式1:
SELECT department_id
FROM employees
GROUP BY department_id 
HAVING AVG(salary) = (
					  	SELECT MIN(avg_sal) 
						FROM (
							  SELECT AVG(salary) avg_sal
							  FROM employees
							  GROUP BY department_id
							  ) dept_avg_sal
					  );
					  
-- 方式2:
SELECT department_id
FROM employees
GROUP BY department_id 
HAVING AVG(salary) <= ALL (	
					  SELECT AVG(salary) avg_sal
					  FROM employees
					  GROUP BY department_id
					  );
					  
-- 4. 相关子查询

-- 查询员工中工资大于本部门平均工资的员工的last_name, salary和其department_id
SELECT employee_id, last_name, salary, department_id
FROM employees e1
WHERE salary > (
				SELECT AVG(salary)
				FROM employees e2
				WHERE department_id = e1.department_id 
);

-- 查询员工的id, first_name, salary, 按照department_name排序
SELECT employee_id, first_name, salary,  
FROM employees e
ORDER BY (
			SELECT department_name
			FROM departments d 
			WHERE e.department_id = d.department_id 
) ASC;

/*
 * 在SELECT中，除了GROUP BY 和 LIMIT之外，其他位置都可以声明子查询
 * 
 * SELECT .... (存在聚合函数)
 * FROM ... (LEFT/RIGHT)JOIN ... ON 多表连接条件
 * (LEFT / RIGHT)JOIN ... ON ...
 * GROUP BY ..., ...
 * HAVING 包含聚合函数的过滤条件
 * ORDER BY ..., ... (ASC / DESC)
 * LIMIT ..., ... 
 */

-- 若employees表中employee_id与job_history表中employee_id相同的数目不小于2
-- 输出这些相同id的员工的employee_id,last_name和其job_id
SELECT employee_id, last_name, job_id
FROM employees e 
WHERE 2 <= (
			SELECT COUNT(*)
			FROM job_history jh 
			WHERE e.employee_id = jh.employee_id 
);

/*
 * 关联子查询通常也会和EXISTS操作符一起使用，用来检查在子查询中是否存在满足条件的行
 * 如果在子查询中不存在满足条件的行，条件返回FALSE，继续在子查询中查找
 * 如果在子查询中存在满足条件的行，不在子查询中继续查找，条件返回TRUE
 */

-- 查询公司管理者的employee_id, last_name, job_id, department_id信息
-- 方式1
SELECT DISTINCT mgr.employee_id, mgr.last_name, mgr.job_id, mgr.department_id
FROM employees emp JOIN employees mgr 
ON emp.manager_id = mgr .employee_id;
-- 方式2
SELECT employee_id, last_name, job_id, department_id 
FROM employees e 
WHERE employee_id IN (
						SELECT DISTINCT manager_id
						FROM employees
);
-- 方式3
SELECT employee_id, last_name, job_id, department_id 
FROM employees e1 
WHERE EXISTS (
				SELECT *
				FROM employees e2 
				WHERE e1.employee_id = e2.manager_id 			
);

-- 查询departments表中，不存在于employees表中的部门的department_id和department_name
-- 方式1
SELECT d.department_id, department_name
FROM employees e RIGHT JOIN departments d 
ON e.department_id = d.department_id
WHERE e.department_id IS NULL;
-- 方式2
SELECT department_id, department_name
FROM departments d 
WHERE NOT EXISTS (
				SELECT *
				FROM employees e 
				WHERE d.department_id = e.department_id 
);




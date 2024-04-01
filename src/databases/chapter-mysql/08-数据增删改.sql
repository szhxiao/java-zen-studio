-- 数据处理之增删改

CREATE TABLE IF NOT EXISTS empl (
id INT,
empl_name VARCHAR(15),
hire_date DATE,
salary DOUBLE(10,2)
);

DESC empl;

-- 1. 添加数据
-- 方式1：条一条添加数据

-- 注意：一定要按照声明的字段先后顺序添加
INSERT INTO empl 
VALUES(1, 'Tom', '2020-12-21', 3400.58);
-- 没有指明的字段默认为null
INSERT INTO empl (id, hire_date, salary, empl_name)
VALUES (2, '1999-09-10', 4500, 'Jerry');
-- 同时插入多条记录
INSERT INTO empl (id, empl_name, hire_date, salary)
VALUES
(3, 'Jim', '2022-09-03', 8200),
(4, '张俊', '1988-04-10', 5600.45); 

-- 方式2：将查询结果插入到表中
SELECT * FROM empl;
SELECT * FROM employees;

-- 查询字段一定要与添加到的表的字段一一对应
INSERT INTO empl(id, empl_name, hire_date, salary)
-- 查询语句
SELECT employee_id, last_name, hire_date, salary
FROM employees 
WHERE department_id IN (50, 60);

-- 2. 更新数据
-- UPDATE ... SET ... WHERE ...
-- 可以实现批量修改
UPDATE empl 
SET empl_name = 'Jun Zhang'
WHERE id = 4;

UPDATE empl 
SET hire_date = CURDATE(), salary = 7500
WHERE id = 4;

-- 练习：将表中姓名包含字符a的提薪20%
UPDATE empl 
SET salary = salary * 1.2
WHERE empl_name LIKE '%a%';

-- 3. 删除数据
-- DELETE FROM ... WHERE ...
DELETE FROM empl 
WHERE id = 1;

-- DML操作默认情况下，执行完毕后会自动提交数据，
-- 如果希望执行完毕后不自动提交数据，需要使用SET autocommit = FALSE

-- 4. MySQL8新特性：计算列
-- 计算列，就是某一列的值是通过其他列计算得到的
CREATE TABLE test1(
a INT,
b INT,
c INT GENERATED ALWAYS AS (a+b) VIRTUAL
);

INSERT INTO test1 (a, b)
VALUES (10, 20);


-- 综合案例
-- 1. 创建数据库library
CREATE DATABASE IF NOT EXISTS library;
USE library;

-- 2. 创建表
-- 表结构：
-- id  图书编号  INT
-- name 图书名  VARCHAR(50)
-- authors 作者 VARCHAR(100)
-- price  价格  decimal
-- pubdate  出版时间 YEAR
-- note  说明  VARCHAR(100)
-- num  库存  INT

CREATE TABLE IF NOT EXISTS book (
book_id INT,
book_name VARCHAR(50),
authors VARCHAR(100),
price DECIMAL,
pubdate YEAR,
note VARCHAR(100),
num INT
);

DESC book;

-- 3. 向表中添加数据
-- 不指定字段名称，插入第一条记录
INSERT INTO book
VALUES
(1, 'Tal of AAA', 'Dickes', 23, '1995', 'novel', 11);

-- 指定所有字段名称，插入第二条记录

INSERT INTO book (book_id, book_name, authors, price, pubdate, note, num)
VALUES
(2, 'EmmaT', 'Jane Lura', 35, '1993', 'joke', 22);

-- 同时插入多条记录
INSERT INTO book (book_id, book_name, authors, price, pubdate, note, num)
VALUES
(3, 'Story of Jane', 'Jane Tim', 40, '2001', 'novel', 0),
(4, 'Lovey Day', 'George Byron', 20, '2005', 'novel', 30),
(5, 'Old Land', 'Honore Blade', 30, '2010', 'law', 0),
(6, 'The Battle', 'Upton Sara', 30, '1999', 'medicine', 40),
(7, 'Rose Hood', 'Richard Haggard', 28, '2008', 'cartoon', 28);

-- 4. 将小说类型的书的价格都增加5
UPDATE book
SET price = price + 5
WHERE note='novel';

-- 5. 将名称为EmmaT的书的价格改为40， 并将说明改为drama
UPDATE book
SET price = 40, note = 'drama'
WHERE book_name = 'EmmaT';

-- 6. 删除库存为0的记录
DELETE FROM book
WHERE num = 0;

-- 7. 统计书名中包含a字母的书
SELECT book_name FROM book
WHERE book_name LIKE '%a%'; 

-- 8. 统计书名中包含a字母的书的数量和库存总量
SELECT COUNT(*) , SUM(num)
FROM book
WHERE book_name LIKE '%a%'; 

-- 9. 找出novel类型的书，按照价格降序排列
SELECT * FROM book
WHERE note = 'novel'
ORDER BY price DESC;

-- 10. 查询图书信息，按照库存量降序排列，如果库存量相同的按照note升序排列
SELECT * FROM book
ORDER BY num DESC, note ASC;

-- 11. 按照note分类统计书的数量
SELECT note, COUNT(*) 
FROM book
GROUP BY note;

-- 12. 按照note分类统计书的库存量，显示库存量超过30本的
SELECT note, SUM(num) 
FROM book b 
GROUP BY note
HAVING SUM(num) > 30;

-- 13. 查询所有图书，每页显示5本，显示第二页
SELECT * 
FROM book b 
LIMIT 5,5;

-- 14. 按照note分类统计书的库存量，显示库存量最多的
SELECT note, SUM(num) sum_num
FROM book b 
GROUP BY note
ORDER BY sum_num DESC 
LIMIT 0, 1;

-- 15. 查询书名达到10个字符的书，不包括其中的空格
SELECT * 
FROM book b
WHERE CHAR_LENGTH(REPLACE(book_name, ' ', '')) >= 10;

-- 16. 查询书名和类型，其中note值为novel显示小说，
-- law显示法律，medicine显示医药， cartoon显示卡通，joke显示笑话
SELECT book_name, note,
CASE note WHEN 'novel' THEN '小说'
		  WHEN 'law' THEN '法律'
		  WHEN 'medicine' THEN '医药'
		  WHEN 'cartoon' THEN '卡通'
		  WHEN 'joke' THEN '笑话'
		  ELSE '其他'
		  END '类型'
FROM book b;

-- 17. 查询书名、库存，其中num值超过30本的，显示滞销，大于0并低于10的
-- 显示畅销，为0的显示需要无货
SELECT book_name AS '书名', num AS '库存',
CASE WHEN num > 30 THEN '滞销'
		 WHEN num > 0 AND num < 10 THEN '畅销'
		 WHEN num = 0 THEN '无货'
		 ELSE '正常'
		 END '销量'
FROM book b ; 

-- 18. 统计每一种note的库存量，并合计总量
SELECT IFNULL(note, '合计库存') AS '类型', SUM(num)
FROM book b 
GROUP BY note WITH ROLLUP; 

-- 19. 统计每一种note的数量，并合计总量
SELECT IFNULL(note, '合计总量') AS '类型', COUNT(*) 
FROM book b 
GROUP BY note WITH ROLLUP;

-- 20. 统计库存量前三名的图书
SELECT * 
FROM book b 
ORDER BY num DESC 
LIMIT 0, 3;

-- 21. 找出最早出版的一本书
SELECT * 
FROM book b 
ORDER BY pubdate ASC 
LIMIT 0, 1; 

-- 22. 找出novel中价格最高的一本书
SELECT * 
FROM book b 
WHERE note = 'novel'
ORDER BY price DESC 
LIMIT 0, 1; 

-- 23. 找出书名中字数最多的一本，不含空格
SELECT *
FROM book b 
ORDER BY CHAR_LENGTH(REPLACE(book_name, ' ', '')) DESC
LIMIT 0, 1;
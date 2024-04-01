-- MySQL8.0其它新特性

USE testdb;

-- 窗口函数

CREATE TABLE sales(
id INT PRIMARY KEY AUTO_INCREMENT,
city VARCHAR(15),
county VARCHAR(15),
sales_value DECIMAL
);

INSERT INTO sales(city, county, sales_value)
VALUES
('北京','海淀',10.00),
('北京','朝阳',20.00),
('上海','黄埔',30.00),
('上海', '长宁', 40.00);

SELECT * FROM sales;

CREATE TABLE goods(
id INT PRIMARY KEY AUTO_INCREMENT,
category_id INT,
category VARCHAR(15),
name varchar(30),
price DECIMAL(30),
stock INT,
upper_time DATETIME
);

INSERT INTO goods(category_id, category, name, price, stock, upper_time)
VALUES
(1, '女装/女士精品', 'T恤', 39.90, 1000, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '连衣裙', 79.90, 2500, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '卫衣', 89.90, 1500, '2020-11-10 00:00:00'),
(2, '户外运动', '自行车', 399.90, 1200, '2020-11-10 00:00:00'),
(2, '户外运动', '骑行装备', 399.90, 3500, '2020-11-10 00:00:00'),
(2, '户外运动', '运动外套', 799.90, 500, '2020-11-10 00:00:00');

SELECT * FROM goods;

-- 排序函数
-- 1. ROW_NUMBER()
-- 查询goods数据表中每个端口分类下价格降序排列的各个端口信息
SELECT ROW_NUMBER() OVER (PARTITION BY category_id ORDER BY price DESC) AS row_num,
id, category_id, category, name, price, stock
FROM goods;

-- 2. RANK()
-- 使用RANK()函数获取goods数据表中各类别的价格从高到低排序的各商品信息
SELECT RANK() OVER (PARTITION BY category_id ORDER BY price DESC) AS row_num,
id, category_id, category, name, price, stock
FROM goods;

-- 3.DENSE_RANK()
SELECT dense_RANK() OVER (PARTITION BY category_id ORDER BY price DESC) AS row_num,
id, category_id, category, name, price, stock
FROM goods;

-- 分布函数

-- 1. PERCENT_RANK()函数
-- 示例：计算goods数据表中名称为“女装/女士精品”类别下的端口的PERCENT_RANK值
SELECT RANK() OVER (PARTITION BY category_id ORDER BY price DESC) AS r,
PERCENT_RANK() OVER (PARTITION BY category_id ORDER BY price DESC) AS pr,
id, category_id, category, name, price, stock
FROM goods 
WHERE category_id = 1;

-- 2. CUME_DIST()

-- 前后函数

-- 公用表表达式
-- 普通公用表表达式
WITH cte_emp
AS (SELECT DISTINCT department_id FROM employees)

SELECT * 
FROM departments d JOIN cte_emp e 
ON d.department_id = e.department_id;

-- 递归公用表表达式
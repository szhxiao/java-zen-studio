-- 数据类型精讲

USE testdb;

-- 1. 整形数据类型

CREATE TABLE t_int(
i1 TINYINT,
i2 SMALLINT,
i3 MEDIUMINT,
i4 INTEGER,
i5 BIGINT
);

DESC t_int;

INSERT INTO t_int(i1)
VALUES (15), (-12), (-128), (127);

SELECT * FROM t_int;

-- 2. 浮点类型

CREATE TABLE t_double (
f1 FLOAT,
f2 FLOAT(5, 2),
d1 DOUBLE,
d2 DOUBLE(5, 2)
);

DESC t_double;

INSERT INTO t_double (f1, f2)
VALUES(123.45, 567.890);

SELECT * FROM t_double;

-- 存在四舍五入
INSERT INTO t_double (d1, d2)
VALUES(123.45, 234.567);
 
-- 3. 定点数类型
CREATE TABLE t_decimal(
d1 DECIMAL,
d2 DECIMAL(5, 2)
);

DESC t_decimal;

INSERT INTO t_decimal (d1)
VALUES (123), (123.45);

SELECT * FROM t_decimal;

INSERT INTO t_decimal(d2)
VALUES (999.99);

-- 存在四舍五入
INSERT INTO t_decimal (d2)
VALUES (67.567);

-- 4. 位类型

CREATE TABLE t_bit (
b1 BIT,
b2 BIT(5),
b3 BIT(64)
);

DESC t_bit;

INSERT INTO t_bit (b1)
VALUES(0), (1);

SELECT * FROM t_bit;

INSERT INTO t_bit (b2)
VALUES (31);

SELECT BIN(b1),BIN(b2), HEX(b1), HEX(b2)
FROM t_bit;

-- 5. 日期时间类型

CREATE TABLE t_date (
d1 DATE
);

DESC t_date;

INSERT INTO t_date 
VALUES ('2020-10-01'), ('2022-09-06');

SELECT * FROM t_date;

INSERT INTO t_date 
VALUES (CURDATE()), (NOW());

CREATE TABLE t_time (
t1 TIME
);

DESC t_time;

INSERT INTO t_time 
VALUES ('2 12:30:29'), ('15:37:42'), ('1 05'), ('45');

SELECT * FROM t_time ;

INSERT INTO t_time 
VALUES (NOW()), (CURRENT_TIME());

CREATE TABLE t_datetime(
dt DATETIME
);

DESC t_datetime;

INSERT INTO t_datetime
VALUES ('2021-01-01 06:50:30'), ('99-01-01 00:00:00');

SELECT * FROM t_datetime;

INSERT INTO t_datetime 
VALUES (NOW()); 

CREATE TABLE t_timestamp(
ts TIMESTAMP
);

DESC t_timestamp ; 

-- TIMESTAMP底层存储毫秒值，即距离1970-01-01 00:00:00的毫秒数值
-- TIMESTAMP在存储数据时需要对当前所在时区进行转换，查询数据时再将时间转换回当前时区
-- 使用TIMESTAMP存储的同一个时间值，在不同的时区查询时会显示不同的时间
INSERT INTO t_timestamp 
VALUES (CURRENT_TIMESTAMP());

SELECT * FROM t_timestamp; 

-- Incorrect datetime value:
-- INSERT INTO t_timestamp 
-- VALUES ('2038-01-20 03:14:07'); 

-- 6.文本字符串类型

-- CHAR类型
CREATE TABLE t_char (
c1 CHAR,
c2 CHAR(5)
);

DESC t_char;

INSERT INTO t_char 
VALUES ('a', 'hello');

SELECT * FROM t_char;

INSERT INTO t_char (c2)
VALUES ('千山鸟飞绝');

SELECT CONCAT(c2, '***') 
FROM t_char;

-- VARCHAR
CREATE TABLE t_varchar(
name VARCHAR(5)
);

DESC t_varchar;

INSERT INTO t_varchar
VALUES('摇光科技');

SELECT * FROM t_varchar; 

-- TEXT
CREATE TABLE t_text (
tx TEXT
);

INSERT INTO t_text
VALUES ('海内存知己，天涯若比邻');

SELECT * FROM t_text;

-- 7. ENUM类型
CREATE TABLE t_enum(
season ENUM('春', '夏', '秋', '冬')
);

DESC t_enum ;

INSERT INTO t_enum 
VALUES (1), ('3');

SELECT * FROM t_enum;

-- 8. SET类型

CREATE TABLE t_set (
score SET ('A', 'B', 'C', 'D')
);

INSERT INTO t_set (score)
VALUES ('A');

INSERT INTO t_set (score)
VALUES ('A,B,C,D');

SELECT * FROM t_set ;

-- 9. 二进制字符串类型
-- BINARY与VARBINARY类型

CREATE TABLE t_binary(
b1 BINARY,
b2 BINARY(3),
b3 VARBINARY(10)
);

DESC t_binary;

INSERT INTO t_binary (b1, b2)
VALUES ('A', 'abc');

SELECT * FROM t_binary;

INSERT INTO t_binary (b2, b3)
VALUES ('AB', 'ab');

-- BLOB类型
CREATE TABLE t_blob(
id INT,
image MEDIUMBLOB
);

DESC t_blob ;

INSERT INTO t_blob (id)
VALUES(1);

SELECT * FROM t_blob;

-- 10. JSON类型

CREATE TABLE t_json(
js JSON
);

DESC t_json;

INSERT INTO t_json(js)
VALUES('{"name":"yaoguang", "age":18, "address":{"province":"gansu","city":"lanzhou"}}');

SELECT * FROM t_json;

-- SELECT js->'$.name' AS name, js->'$.age' AS age, js->'$.address.province' AS province, js->'$address.city' AS city
-- FROM t_json;
-- 触发器

USE testdb;

CREATE TABLE t_trigger(
id INT PRIMARY KEY AUTO_INCREMENT,
note VARCHAR(30)
); 

CREATE TABLE t_trigger_log(
id INT PRIMARY KEY AUTO_INCREMENT,
log VARCHAR(30)
);

SELECT * FROM t_trigger;
SELECT * FROM t_trigger_log;

-- 1. 创建触发器

-- 示例1：创建名为before_insert_t_tri的触发器，向t_trigger数据表插入数据之前，
-- 向t_trigger_log数据表中插入before_insert的日志信息

DELIMITER $

CREATE TRIGGER before_insert_t_tri
BEFORE INSERT ON t_trigger
FOR EACH ROW 
BEGIN 
	INSERT INTO t_trigger_log(log)
	VALUES('before insert ...');
END $
DELIMITER ;

INSERT INTO t_trigger (note)
VALUES ('Keep Going');

SELECT * FROM t_trigger;
SELECT * FROM t_trigger_log;

-- 示例2：创建名为after_insert_t_tri的触发器，向t_trigger数据表插入数据之前，
-- 向t_trigger_log数据表中插入after_insert的日志信息
DROP TRIGGER after_insert_t_tri;

DELIMITER $

CREATE TRIGGER after_insert_t_tri
AFTER INSERT ON t_trigger
FOR EACH ROW 
BEGIN 
	INSERT INTO t_trigger_log (log)
	VALUES ('after insert...');
END $

DELIMITER ;

INSERT INTO t_trigger (note)
VALUES ('Come on');

SELECT * FROM t_trigger;
SELECT * FROM t_trigger_log;

-- 2. 查看触发器

SHOW TRIGGERS;

SHOW CREATE TRIGGER after_insert_t_tri;

SELECT * FROM information_schema.TRIGGERS;

-- 3. 删除触发器
DROP TRIGGER before_insert_t_tri;

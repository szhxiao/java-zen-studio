# 第 22 章 MyBatis

## 22.1 MyBatis 概述

MyBatis 是一个半自动化持久化层框架。

### 22.1.1 MyBatis 简介

将 SQL 和 Java 代码分开，功能边界清晰，一个专注业务、一个专注数据。

### 22.1.2 MyBatis 优势

## 22.2 MyBatis HelloWorld

### 22.2.1 MyBatis 连接并操作数据库

### 22.2.2 接口式编程

### 22.2.3 MyBatis 配置数据库连接池

## 22.3 MyBatis 核心功能

### 22.3.1 MyBatis 全局配置文件

1. properties

    使用 properties 引入外部 properties 配置文件内容，resource 引入类路径下的资源，url 引入网络或磁盘路径的资源。

    ```xml
    <properties resource="org/mybatis/example/config.properties">
    <property name="username" value="dev_user"/>
    <property name="password" value="F2Fa3!33TYyg"/>
    </properties>




    <dataSource type="POOLED">
    <property name="driver" value="${driver}"/>
    <property name="url" value="${url}"/>
    <property name="username" value="${username}"/>
    <property name="password" value="${password}"/>
    </dataSource>
    ```

2. settings

3. typeAliases

4. typeHandlers

5. objectFactory

6. plugins

7. environments

    - environment
        - transactionManager
        - dataSource

8. databaseldProvider

    支持多数据库厂商，

9. mappers

### 22.3.2 MyBatis 映射文件

1. 常用元素

    - cache
    - cache-ref
    - resultMap
    - sql
    - insert
    - update
    - delete
    - select

2. 主键生成方式

    - 支持自动生成主键数据库
    - 不支持自增型主键数据库

3. 参数传递

    - 单个参数

        一般不做特殊处理。

        如果是 Collection(List 或 Set)类型或者数组，会将参数封装在 Map 中。

        | 参数类型   | 封装后 Map 中的 key |
        | ---------- | ------------------- |
        | Collection | collection          |
        | List       | list                |
        | 数组       | array               |

    - 多个参数

        多个参数会做特殊处理，将多个参数封装成为一个 Map，key 是 param1...paramN 或者参数的索引，value 是传入的参数;

    - 命名参数

        可以使用命名参数，明确指定 Map 封装参数时的 key。

    - POJO

        如果多个业务参数正是业务逻辑的数据模型，可以直接传入 POJO，使用#{属性名}取出属性值。

    - Map

        如果多个参数不是业务模型中的数据，没有对应的 POJO，如果不经常使用，可以传入 Map，使用#{key}取出对应的值。

        如果多个参数不是业务模型数据，但使用频繁很高，推荐编写一个 TO(Transfer Object)数据传输对象。

4. 参数处理

    - #{}方式

        以预编译试，将参数设置到 sql 语句中，可以防止 sql 注入。

        可以规定参数的规则，例如可以在特定条件下设置 jdbcType 类型。

    - ${}方式

        取出参数值直接设置在 sql 语句中，存在安全问题。

    大多数情况下使用#{}方式，对于 jdbc 不支持占位符时，可以使用${}方式取值。

5. select

6. resultMap

7. association

8. Collection 集合

### 22.3.3 动态 SQL

1. if

2. choose(when, otherwise)

3. trim(where, set)

4. foreach

    - 遍历集合
    - 批量添加

5. bind

    可以将 OGNL 表达式绑定到某个变量

6. sql 标签

    抽取可重用 SQL 语句，方便引用

### 22.3.4 缓存机制

MyBatis 包含一个非常强大的查询缓存特性，可以方便地配置和定制，以极大地提升查询效率。

1. 一级缓存

    即本地缓存，与数据库同一次会话期间查询到的数据存储于本地缓存，如果需要获取相同数据，直接从缓存中取出，不需要再次查询数据库。

    一级缓存失效的情况：

    - sqlSession 不同；
    - sqlSession 相同，查询条件不同，此时一级缓存中没有待查询数据；
    - sqlSession 相同，两次查询之间执行了数据库增删改操作；
    - sqlSession 相同，手动清除了一级缓存。

    默认情况下，只有一级缓存开启。

2. 二级缓存

    即全局缓存，甚于 namespace，其工作机制是一个会话查询一条数据，该数据被存储于当前会话的一级缓存中，如果会话关闭，一级缓存中的数据将保存到二级缓存中，新的会话查询信息可以参照二级缓存内容。

    二级缓存需要手动开启和配置.

3. 整合第三方缓存

### 22.3.5 MyBatis 整合 Spring、SpringMVC

1. 依赖导入
2. 配置文件

### 22.3.6 MyBatis 逆向工程

## 22.4 MyBatis 原理

## 22.5 MyBatis 插件开发

可以使用插件为目标对象创建一个代理对象，代理对象可以拦截四大对象的特定方法。

在四大对象创建的过程中，每次创建并不是直接返回对象，而是调用了 interceptorChain.plugin

多个插件会产生多个代理，

## 22.6 MyBatis 应用

### 22.6.1 批量操作

### 22.6.2 存储过程

### 22.6.3 自定义 TypeHandler 处理枚举

## 22.7 通用 Mapper

## 22.8 MyBatisPlus

MyBatisPlus 是一个 MyBatis 的增强工具包，只做增强不做改变，为简化开发、提高生产效率而生。

### 22.8.1 环境配置

### 22.8.2 HelloMyBatisPlus

1. 通用 CRUD
2. 插入操作
3. 更新操作
4. 查询操作
5. 删除操作
6. 启动注入 SQL 原理分析

### 22.8.3 条件构造器 EntityWrapper

1. 条件查询
2. 条件修改
3. 条件删除

### 22.8.4 代码生成器

### 22.8.5 插件扩展

1. Mybatis 插件机制
2. 分页插件

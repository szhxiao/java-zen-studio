# 第 22 章 MyBatis

## 22.1 MyBatis 概述

### 22.1.1 MyBatis 简介

> MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射。MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

[MyBatis 中文网](https://mybatis.net.cn/)

### 22.1.2 MyBatis 优势

-   简单易学：本身就很小且简单。没有任何第三方依赖，最简单安装只要两个 jar 文件+配置几个 sql 映射文件
-   灵活：mybatis 不会对应用程序或者数据库的现有设计强加任何影响
-   解除 sql 与程序代码的耦合：通过提供 DAO 层，将业务逻辑和数据访问逻辑分离，使系统的设计更清晰，更易维护，更易单元测试
-   提供映射标签，支持对象与数据库的 ORM 字段关系映射
-   提供对象关系映射标签，支持对象关系组建维护
-   提供 xml 标签，支持编写动态 sql

## 22.2 HelloMyBatis

### 22.2.1 创建数据库、数据表

    ```sql
    CREATE DATABASE `mybatisdb`;

    USE `mybatisdb` ;

    DROP TABLE IF EXISTS `user` ;

    /* Structure for the table `user` */
    CREATE TABLE `user` (
    `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
    `uname` varchar(20) NOT NULL,
    `password` varchar(32) NOT NULL,
    `email` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`uname`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

    /* Data for the table `user` */
    INSERT INTO `user`(`id`,`uname`,`password`,`email`)
    VALUES
    (1,'lina','ok','lina@sina.com.cn'),
    (2,'kate','ok','hello_kate@126.com'),
    (3,'jiu','ok','jiujiu@126.com');
    ```

### 22.2.2 新建 maven 或 gradle 项目

-   导入 mybatis 依赖

    -   maven

        ```xml
        <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.11</version>
        </dependency>
        ```

    -   gradle

        ```gradle
        // https://mvnrepository.com/artifact/org.mybatis/mybatis
        implementation group: 'org.mybatis', name: 'mybatis', version: '3.5.11'
        ```

-   创建 MyBatis 配置文件 mybatis-config.xml

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE configuration
    PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-config.dtd">
    <configuration>
    <environments default="development">
        <environment id="development">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="${driver}"/>
            <property name="url" value="${url}"/>
            <property name="username" value="${username}"/>
            <property name="password" value="${password}"/>
        </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="UserMapper.xml"/>
    </mappers>
    </configuration>
    ```

-   其他依赖如日志、数据库连接自行导入，示例：

    ```gradle
    // 数据库依赖
    implementation group: 'org.mybatis', name: 'mybatis', version: '3.5.11'
    implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.31'
    implementation group: 'com.alibaba', name: 'druid', version: '1.2.15'
    // 日志依赖
    implementation group: 'org.slf4j', name: 'slf4j-api', version: '2.0.3'
    testImplementation group: 'ch.qos.logback', name: 'logback-classic', version: '1.4.4'
    // 测试依赖
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
    ```

### 22.2.3 编写 Java 业务代码

-   编写实体类

    ```java
    public class User {
        private Integer id;
        private String uname;
        private String password;
        private String email;

        // 省略构造方法和getter,setter方法...
    }
    ```

-   编写 DAO 接口

    ```java
    public interface UserMapper {
        User getUserById(Integer id);
    }
    ```

-   编写映射的 SQL 语句 UserMapper.xml

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="dao.UserMapper">
        <select id="getUserById" resultType="pojo.User">
            SELECT * FROM user WHERE id = #{id}
        </select>
    </mapper>
    ```

    **每个 Mapper.xml 都需要在 MyBatis 核心配置文件中注册**，此时注册代码为核心配置文件中的：

    ```xml
    <mappers>
        <mapper resource="UserMapper.xml"/>
    </mappers>
    ```

-   注解模式代替 Mapper.xml

    对于一些简单代码，也可使用注解模式代替：

    ```java
    public interface UserMapper {
        @Select("SELECT * FROM user WHERE id = #{id}")
        User getUserById(Integer id);
    }
    ```

    此时必须对 UserMapper 接口进行注册，代码为：

    ```java
    sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
    ```

### 22.2.4 编写 Java 测试代码

-   测试数据库连接

    ```java
    @Test
    public void testGetConnection() throws IOException {
        // 根据全局配置文件创建一个 SqlSessionFactory对象
        // 解析文件的每一个信息，保存在Configuration，
        // 返回包含ConfigurationDefaultSqlSession
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession实例
        // （sqlSession可执行已经映射的SQL语句，一个sqlSession代表和数据库的一次会话，用完关闭）
        // 返回SqlSession的实现类DefaultSqlSession，包含Executor和Configuration
        try(SqlSession session = sqlSessionFactory.openSession();) {
            System.out.println(session);
        }
    }
    ```

-   测试数据查询

    ```java
    @Test
    public void testGetUserById() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = sqlSessionFactory.openSession();) {
            // 注册UserMapper接口
            sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);

            // 获取指定的代理对象MapperProxy
            // getMapper使用MapperProxyFactory创建一个MapperProxy的代理对象
            UserMapper mapper = session.getMapper(UserMapper.class);

            // 执行增删改查操作
            // 调用DefaultSqlSession的增删改查(Executor)，
            // 会创建一个StatementHandler对象及ParameterHandler,ResultSetHandler对象
            // 调用StatementHandler的预编译参数及设置参数值，再调用增删改查方法
            // 操作结束后使用ResultSetHandler封装结果
            User user = mapper.getUserById(2);
            System.out.println(user);
        }
    }
    ```

### 22.2.5 CRUD

-   Save/Add

    ```java
    // 接口中方法声明
    Integer saveUser(User user);
    ```

    ```xml
    <insert id="saveUser" parameterType="pojo.User">
        INSERT INTO `user`(`id`,`uname`,`password`,`email`)
        VALUES(#{id}, #{uname}, #{password}, #{email})
    </insert>
    ```

    ```java
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setId(4);
        user.setUname("bilibili");
        user.setPassword("bilibili");
        user.setEmail("bilibili@163.com");
        mapper.saveUser(user);

        session.commit();
    }
    ```

    **必须提交事务！**

-   Update

    ```java
    Integer updateUser(User user);
    ```

    ```xml
    <update id="updateUser" parameterType="pojo.User">
        UPDATE `user` SET `uname`=#{uname}, `password`=#{password}, `email`=#{email}
        WHERE `id`=#{id}
    </update>
    ```

    ```java
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(3);
        user.setUname("jiuer");
        user.setPassword("jiuer");
        user.setEmail("jiuer@126.com");
        mapper.updateUser(user);
        session.commit();
    }
    ```

    **必须提交事务！**

-   Remove/Delete

    ```java
    @Delete("DELETE FROM user WHERE id=#{id}")
    void removeUser(Integer id);
    ```

    ```java
    @Test
    public void testDeleteUser() {
        mapper.removeUser(4);
        session.commit();
    }
    ```

    **必须提交事务！**

-   Select

    ```java
    @Select("SELECT * FROM user")
    List<User> getAllUsers();

    @Select("SELECT * FROM user WHERE id=#{id}")
    User getUserById(Integer id);
    ```

    ```java
    @Test
    public void testGetAllUsers(){
        List<User> userList = mapper.getAllUsers();
        logger.info(userList.toString());
    }

    @Test
    public void testGetUserById() {
        User user = mapper.getUserById(1);
        logger.info(user.toString());
    }
    ```

### 22.2.5 作用域（Scope）和生命周期

> 作用域和生命周期类别是至关重要的，因为错误的使用会导致非常严重的并发问题。

依赖注入框架可以创建线程安全的、基于事务的 SqlSession 和映射器，并将它们直接注入到你的 bean 中，因此可以直接忽略它们的生命周期。

-   SqlSessionFactoryBuilder

    这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。 因此 SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域（也就是局部方法变量）。 可以重用 SqlSessionFactoryBuilder 来创建多个 SqlSessionFactory 实例，但最好还是不要一直保留着它，以保证所有的 XML 解析资源可以被释放给更重要的事情。

-   SqlSessionFactory

    SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。 使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次，多次重建 SqlSessionFactory 被视为一种代码“坏习惯”。因此 SqlSessionFactory 的最佳作用域是应用作用域。 有很多方法可以做到，最简单的就是使用单例模式或者静态单例模式。

-   SqlSession

    每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。 绝对不能将 SqlSession 实例的引用放在一个类的静态域，甚至一个类的实例变量也不行。 也绝不能将 SqlSession 实例的引用放在任何类型的托管作用域中，比如 Servlet 框架中的 HttpSession。 如果你现在正在使用一种 Web 框架，考虑将 SqlSession 放在一个和 HTTP 请求相似的作用域中。 换句话说，每次收到 HTTP 请求，就可以打开一个 SqlSession，返回一个响应后，就关闭它。 这个关闭操作很重要，为了确保每次都能执行关闭操作，你应该把这个关闭操作放到 finally 块中。

    确保 SqlSession 关闭的标准模式：

    ```java
    try (SqlSession session = sqlSessionFactory.openSession()) {
        ...
    }
    ```

    在所有代码中都遵循这种使用模式，可以保证所有数据库资源都能被正确地关闭。

## 22.3 MyBatis 配置

> MyBatis 的配置文件包含了会深深影响 MyBatis 行为的设置和属性信息。

### 22.3.1 属性（properties）

属性可以在外部进行配置，并可以进行动态替换。你既可以在典型的 Java 属性文件中配置这些属性，也可以在 properties 元素的子元素中设置。

使用 properties 引入外部 properties 配置文件内容，resource 引入类路径下的资源，url 引入网络或磁盘路径的资源。

```xml
<properties resource="org/mybatis/example/config.properties">
    <property name="username" value="dev_user"/>
    <property name="password" value="F2Fa3!33TYyg"/>
</properties>
```

可以直接引入外部文件，也可以在`properties`中增加属性配置，如果两个文件都存在，优先使用外部配置文件。

    <dataSource type="POOLED">
    <property name="driver" value="${driver}"/>
    <property name="url" value="${url}"/>
    <property name="username" value="${username}"/>
    <property name="password" value="${password}"/>
    </dataSource>
    ```

### 22.3.2 设置（settings）

> MyBatis 中极为重要的调整设置，它们会改变 MyBatis 的运行时行为。

| 设置名                   | 描述                                                                                                                | 有效值        | 默认值 |
| ------------------------ | ------------------------------------------------------------------------------------------------------------------- | ------------- | ------ |
| cacheEnabled             | 全局性地开启或关闭所有映射器配置文件中已配置的任何缓存                                                              | true or false | true   |
| lazyLoadingEnabled       | 延迟加载的全局开关,当开启时，所有关联对象都会延迟加载。,特定关联关系中可通过设置 fetchType 属性来覆盖该项的开关状态 | true or false | false  |
| mapUnderscoreToCamelCase | 是否开启驼峰命名自动映射，即从经典数据库列名 A_COLUMN 映射到经典 Java 属性名 aColumn                                | true or false | False  |

```xml
<settings>
    <setting name="cacheEnabled" value="true"/>
    <setting name="lazyLoadingEnabled" value="true"/>
    <setting name="multipleResultSetsEnabled" value="true"/>
    <setting name="useColumnLabel" value="true"/>
    <setting name="useGeneratedKeys" value="false"/>
    <setting name="autoMappingBehavior" value="PARTIAL"/>
    <setting name="autoMappingUnknownColumnBehavior" value="WARNING"/>
    <setting name="defaultExecutorType" value="SIMPLE"/>
    <setting name="defaultStatementTimeout" value="25"/>
    <setting name="defaultFetchSize" value="100"/>
    <setting name="safeRowBoundsEnabled" value="false"/>
    <setting name="mapUnderscoreToCamelCase" value="false"/>
    <setting name="localCacheScope" value="SESSION"/>
    <setting name="jdbcTypeForNull" value="OTHER"/>
    <setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode,toString"/>
</settings>
```

### 22.3.3 类型别名（typeAliases）

> 类型别名可为 Java 类型设置一个缩写名字。 它仅用于 XML 配置，意在降低冗余的全限定类名书写。

```xml
<typeAliases>
    <typeAlias alias="Author" type="domain.blog.Author"/>
    <typeAlias alias="Blog" type="domain.blog.Blog"/>
    <typeAlias alias="Comment" type="domain.blog.Comment"/>
    <typeAlias alias="Post" type="domain.blog.Post"/>
    <typeAlias alias="Section" type="domain.blog.Section"/>
    <typeAlias alias="Tag" type="domain.blog.Tag"/>
</typeAliases>
```

> 可以指定一个包名，MyBatis 会在包名下面搜索需要的 Java Bean。

```xml
<typeAliases>
    <package name="domain.blog"/>
</typeAliases>
```

每一个在包 domain.blog 中的 Java Bean，在没有注解的情况下，会使用 Bean 的首字母小写的非限定类名来作为它的别名。 比如 domain.blog.Author 的别名为 author；若有注解，则别名为其注解值。

```java
@Alias("author")
public class Author {
...
}
```

实体类较少时，使用第一种方式；实体类很多，建议使用第二种方式。

### 22.3.4 类型处理器（typeHandlers）

### 22.3.5 对象工厂（objectFactory）

### 22.3.6 插件（plugins）

### 22.3.7 环境配置（environments）

MyBatis 可以配置成适应多种环境，这种机制有助于将 SQL 映射应用于多种数据库之中， 现实情况下有多种理由需要这么做。例如，开发、测试和生产环境需要有不同的配置；或者想在具有相同 Schema 的多个生产数据库中使用相同的 SQL 映射。还有许多类似的使用场景。

不过要记住：尽管可以配置多个环境，但每个 SqlSessionFactory 实例只能选择一种环境。

所以，如果你想连接两个数据库，就需要创建两个 SqlSessionFactory 实例，每个数据库对应一个。

```xml
<environments default="development">
    <environment id="development">
        <transactionManager type="JDBC">
        <property name="..." value="..."/>
        </transactionManager>
        <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
        </dataSource>
    </environment>
</environments>
```

### 22.3.8 数据库厂商标识（databaseIdProvider）

支持多数据库厂商，

### 22.3.9 映射器（mappers）

可以使用相对于类路径的资源引用，或完全限定资源定位符（包括 file:/// 形式的 URL），或类名和包名等。

```xml
<!-- 使用相对于类路径的资源引用 -->
<mappers>
    <mapper resource="org/mybatis/builder/AuthorMapper.xml"/>
    <mapper resource="org/mybatis/builder/BlogMapper.xml"/>
    <mapper resource="org/mybatis/builder/PostMapper.xml"/>
</mappers>
```

```xml
<!-- 使用完全限定资源定位符（URL） -->
<mappers>
    <mapper url="file:///var/mappers/AuthorMapper.xml"/>
    <mapper url="file:///var/mappers/BlogMapper.xml"/>
    <mapper url="file:///var/mappers/PostMapper.xml"/>
</mappers>
```

```xml**接口和 Mapper 配置文件必须同名且在同一个包下。**er.PostMapper"/>
</mappers>
```

**接口和 Mapper 配置文件必须同名且在同一个包下。**

```xml
<!-- 将包内的映射器接口实现全部注册为映射器 -->
<mappers>
    <package name="org.mybatis.builder"/>
</mappers>
```

**接口和 Mapper 配置文件必须同名且在同一个包下。**

## 22.4 XML 映射器

### 22.4.1 select

    - cache
    - cache-ref
    - resultMap
    - sql
    - insert
    - update
    - delete
    - select

1. 主键生成方式

    - 支持自动生成主键数据库
    - 不支持自增型主键数据库

### 22.4.2 insert, update 和 delete

### 22.4.3 参数

-   单个参数

    一般不做特殊处理。

    如果是 Collection(List 或 Set)类型或者数组，会将参数封装在 Map 中。

    | 参数类型   | 封装后 Map 中的 key |
    | ---------- | ------------------- |
    | Collection | collection          |
    | List       | list                |
    | 数组       | array               |

-   多个参数

    多个参数会做特殊处理，将多个参数封装成为一个 Map，key 是 param1...paramN 或者参数的索引，value 是传入的参数;

-   命名参数

    可以使用命名参数，明确指定 Map 封装参数时的 key。

-   POJO

    如果多个业务参数正是业务逻辑的数据模型，可以直接传入 POJO，使用#{属性名}取出属性值。

-   Map

    如果多个参数不是业务模型中的数据，没有对应的 POJO，如果不经常使用，可以传入 Map，使用#{key}取出对应的值。

    如果多个参数不是业务模型数据，但使用频繁很高，推荐编写一个 TO(Transfer Object)数据传输对象。

参数处理

    - #{}方式

        以预编译试，将参数设置到 sql 语句中，可以防止 sql 注入。

        可以规定参数的规则，例如可以在特定条件下设置 jdbcType 类型。

    - ${}方式

        取出参数值直接设置在 sql 语句中，存在安全问题。

        大多数情况下使用#{}方式，对于 jdbc 不支持占位符时，可以使用${}方式取值。

### 22.4.4 结果映射

1. resultMap

    > resultMap 元素是 MyBatis 中最重要最强大的元素。它可以让你从 90% 的 JDBC ResultSets 数据提取代码中解放出来，并在一些情形下允许你进行一些 JDBC 不支持的操作。实际上，在为一些比如连接的复杂语句编写映射代码的时候，一份 resultMap 能够代替实现同等功能的数千行代码。ResultMap 的设计思想是，对简单的语句做到零配置，对于复杂一点的语句，只需要描述语句之间的关系就行了。

    ```xml
    <resultMap id="userResultMap" type="user">
        <!-- column对应数据库中的字段，property对应实体类中的字段 -->
        <!-- 与JavaBean对应的字段可以省略 -->
        <!-- <result column="id" property="id"/> -->
        <!-- <result column="uname" property="uname"/> -->
        <result column="password" property="pwd"/>
        <!-- <result column="email" property="email"/> -->
    </resultMap>

    <!-- 使用resultMap -->
    <select id="getAllUsers" resultMap="userResultMap">
        SELECT * FROM `user`
    </select>
    ```

2. association

    ```xml
    <!-- 按照查询嵌套处理 -->
    <resultMap id="userResultMap2" type="user">
        <result column="pk_id" property="id"/>
        <result column="uk_uname" property="uname"/>
        <result column="password" property="password"/>
        <result column="email" property="email"/>
        <association column="dept_id" property="department" select="dao.DeptMapper.getDepartmentById"/>
    </resultMap>

    <select id="getAllUsers" resultMap="userResultMap2">
        SELECT * FROM `user`
    </select>
    ```

3. collection

### 22.4.5 自动映射

### 22.4.6 缓存

MyBatis 包含一个非常强大的查询缓存特性，可以方便地配置和定制，以极大地提升查询效率。

1. 一级缓存

    即本地缓存，与数据库同一次会话期间查询到的数据存储于本地缓存，如果需要获取相同数据，直接从缓存中取出，不需要再次查询数据库。

    一级缓存失效的情况：

    - sqlSession 不同；

    - sqlSession 相同，查询条件不同，此时一级缓存中没有待查询数据；

    - sqlSession 相同，两次查询之间执行了数据库增删改操作；

    - sqlSession 相同，手动清除了一级缓存。

    默认情况下，只有一级缓存开启；只在一次 SqlSession 中有效，即拿到连接到关闭连接区间内有效。

2. 二级缓存

    即全局缓存，甚于 namespace，其工作机制是一个会话查询一条数据，该数据被存储于当前会话的一级缓存中，如果会话关闭，一级缓存中的数据将保存到二级缓存中，新的会话查询信息可以参照二级缓存内容。

    二级缓存需要手动开启和配置。

3. 默认缓存策略

    可用的清除策略有：

    LRU – 最近最少使用：移除最长时间不被使用的对象
    FIFO – 先进先出：按对象进入缓存的顺序来移除它们
    SOFT – 软引用：基于垃圾回收器状态和软引用规则移除对象
    WEAK – 弱引用：更积极地基于垃圾收集器状态和弱引用规则移除对象

4. 整合第三方缓存

    - caffeine cache

        ```xml
        <dependency>
            <groupId>org.mybatis.caches</groupId>
            <artifactId>mybatis-caffeine</artifactId>
            <version>1.1.0</version>
        </dependency>
        ```

        ```gradle
        implementation group: 'org.mybatis.caches', name: 'mybatis-caffeine', version: '1.0.0'
        ```

        ```xml
        <cache type="org.mybatis.caches.caffeine.CaffeineCache"/>
        ```

## 22.5 动态 SQL

动态 SQL 是 MyBatis 的强大特性之一。

动态 SQL 就是拼接 SQL 语句，只要保证 SQL 的正确性，按照 SQL 的格式进行排列组合即可。

### 22.5.1 if

```xml
<select id="findActiveBlogWithTitleLike"
     resultType="Blog">
    SELECT * FROM BLOG
    WHERE state = ‘ACTIVE’
    <if test="title != null">
        AND title like #{title}
    </if>
</select>
```

### 22.5.2 choose(when, otherwise)

```xml
<select id="findActiveBlogLike"
     resultType="Blog">
    SELECT * FROM BLOG WHERE state = ‘ACTIVE’
    <choose>
        <when test="title != null">
            AND title like #{title}
        </when>
        <when test="author != null and author.name != null">
            AND author_name like #{author.name}
        </when>
        <otherwise>
            AND featured = 1
        </otherwise>
    </choose>
</select>
```

### 22.5.3 trim(where, set)

```xml
<select id="findActiveBlogLike"
     resultType="Blog">
    SELECT * FROM BLOG
    <where>
        <if test="state != null">
            state = #{state}
        </if>
        <if test="title != null">
            AND title like #{title}
        </if>
        <if test="author != null and author.name != null">
            AND author_name like #{author.name}
        </if>
    </where>
</select>
```

### 22.5.4 foreach

```xml
<select id="selectPostIn" resultType="domain.blog.Post">
    SELECT *
    FROM POST P
    WHERE ID in
    <foreach item="item" index="index" collection="list"
        open="(" separator="," close=")">
            #{item}
    </foreach>
</select>
```

-   遍历集合
-   批量添加

### 22.5.6 bind

    可以将 OGNL 表达式绑定到某个变量

### 22.5.6 sql 标签

抽取可重用 SQL 语句，方便复用。

-   使用`<sql>`标签抽取公共部分

    ```xml
    <sql id="if-conditions">
            <if test="title != null">
                title LIKE #{title}
            </if>
            <if test="author != null">
                AND author LIKE #{author}
            </if>
        </sql>
    ```

-   使用`<include>` 标签引用

    ```xml
    <select id="getBlogByConditions" parameterType="map" resultMap="blogResultMap">
        SELECT * FROM `blog`
        <where>
            <include refid="if-conditions"></include>
        </where>
    </select>
    ```

-   注意事项

    -   最好甚于单表来定义 sql 片段
    -   不在存在 where 标签

## 22.7 MyBatis 其他应用

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

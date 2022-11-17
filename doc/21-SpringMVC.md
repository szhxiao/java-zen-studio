# 第 21 章 SpringMVC

## 21.1 SpringMVC 简介

### 21.1.1 MVC

MVC 是一种软件架构思想，将软件按照模型、视图、控制器划分。

1. Model

    模型层，主要用于处理数据，一般为 JavaBean

    - 实体类 JavaBean，专业存储业务数据，每个实体类对应数据库中的一张表；
    - 业务处理 JavaBean，Service 或 DAO 对象，专门处理业务逻辑和数据访问；

2. View

    视图层，项目中的 html 或 jsp 页面，与用户进行交互，显示数据。

3. Controller

    控制层，接收请求和响应浏览器。

### 21.1.2 SpringMVC

SpringMVC 是 Spring 为表示层开发提供的一套解决方案。

1. SpringMVC 特点

    - 与 IOC 容器等基础设施无缝对接
    - 甚于原生的 Servlet，通过功能强大的前端 DispatcherServlet，对请求和响应进行统一处理
    - 代码清晰乘法，大幅提升效率
    - 内部组件化程度高，可插拔式组件，即插即用
    - 性能卓著

Spring MVC 天生与 Spring 框架集成，可以帮助我们进行更简洁的 Web 层的开发。Spring MVC 下我们一般把后端项目分为 Service 层（处理业务）、Dao 层（数据库操作）、Entity 层（实体类）、Controller 层(控制层，返回数据给前台页面)。

## 21.2 SpringMVC 工作原理

### 21.2.1 HelloSpringMVC

1. 创建工程，引入依赖
2. 配置 web.xml 文件
3. 配置 SpringMVC 配置文件
4. 创建请求控制器
5. 测试页面

浏览器发送请求，若请求地址符合前端控制器的 url-pattern，该请求就会被前端控制器 DispatcherServlet 处理。前端控制器会读取 SpringMVC 的核心配置文件，通过扫描组件找到控制器，将请求地址和控制器中@RequestMapping 注解的 value 属性值进行匹配，若匹配成功，该注解所标识的控制器方法就是处理请求的方法。处理请求的方法需要返回一个字符串类型的视图名称，该视图名称会被视图解析器解析，加上前缀和后缀组成视图的路径，通过 Thymeleaf 对视图进行渲染，最终转发到视图所对应页面。

### 21.2.2 原理及执行流程

1. Spring MVC 原理

2. 流程说明

    1. 客户端（浏览器）发送请求，直接请求到 `DispatcherServlet`。
    2. `DispatcherServlet` 根据请求信息调用 `HandlerMapping`，解析请求对应的 `Handler`。
    3. 解析到对应的 `Handler`（也就是我们平常说的 `Controller` 控制器）后，开始由 `HandlerAdapter` 适配器处理。
    4. `HandlerAdapter` 会根据 `Handler`来调用真正的处理器开处理请求，并处理相应的业务逻辑。
    5. 处理器处理完业务后，会返回一个 `ModelAndView` 对象，`Model` 是返回的数据对象，`View` 是个逻辑上的 `View`。
    6. `ViewResolver` 会根据逻辑 `View` 查找实际的 `View`。
    7. `DispaterServlet` 把返回的 `Model` 传给 `View`（视图渲染）。
    8. 把 `View` 返回给请求者（浏览器）

### 21.2.3 处理常见的 HTTP 请求

1. HTTP 请求类型

    - **GET** ：请求从服务器获取特定资源。举个例子：`GET /users`（获取所有学生）
    - **POST** ：在服务器上创建一个新的资源。举个例子：`POST /users`（创建学生）
    - **PUT** ：更新服务器上的资源（客户端提供更新后的整个资源）。举个例子：`PUT /users/12`（更新编号为 12 的学生）
    - **DELETE** ：从服务器删除特定的资源。举个例子：`DELETE /users/12`（删除编号为 12 的学生）
    - **PATCH** ：更新服务器上的资源（客户端提供更改的属性，可以看做作是部分更新），使用的比较少，这里就不举例子了。

## 21.3 SpringMVC 核心技术

### 21.3.1 @RequestMapping 注解

1. @RequestMapping 注解功能

    @RequestMapping 注解是将请求和处理请求的控制器关联起来，建立映射关系。SpringMVC 接收到指定请求，找到映射关系中对应的控制器方法来处理请求。

2. @RequestMapping 注解位置

    - 标识类：设置映射请求的请求路径的初始信息
    - 标识方法：设置映射请求请求路径的具体信息

3. @RequestMapping 注解的属性

    - value

        value 属性通过请求地址匹配请求映射，它是一个字符串类型的数组，表示请求映射能够匹配多个地址所对应的请求。

        value 属性必须设置。

    - method

        method 属性通过请求方式匹配请求映射，它是一个 RequestMethod 类型的数组，表示该请求映射能够匹配多种请求方式。

    - params

        通过请求参数匹配请求映射，它是一个字符串类型数组。

        - param：要求映射所匹配的请求必须携带 param 参数
        - !param：要求请求映射所匹配的请求必须不能携带 param 参数
        - param=value：要求请求映射所匹配的请求必须携带 param 参数，且值必须为 value
        - param!=value：要求请求映射所匹配的请求必须携带 param 参数但是值必须不是 value

    - head

4. 路径中的占位符

### 21.3.2 SpingMVC 获取请求参数

1. 通过 ServletAPI 获取
2. 通过控制器方法的形参获取请求参数
3. `@RequestParam`和`@PathVariable`

    `@PathVariable`用于获取路径参数，`@RequestParam`用于获取查询参数。

4. @RequestHeader
5. @CookieValue
6. 通过 POJO 获取请求参数

### 21.3.3 域对象共享数据

1. 使用 ServletAPI 向 request 域对象共享数据
2. 使用 ModelAndView 向 request 域对象共享数据

3. 使用 Mode 向 request 域对象共享数据
4. 使用 Map 向 request 域对象共享数据
5. 使用 ModelMap 向 request 域对象共享数据
6. Mode、ModelMap、Map 的关系
7. 向 session 域共享数据
8. 向 application 域共享数据

### 21.3.4 SpringMVC 的视图

SpringMVC 中的视图是 View 接口，渲染数据，将模型 Model 中的数据展示给用户，默认有转发视图(InternalResourceView)和重定向视图(RedirectView)。

1. ThymeleafView

    控制器方法中设置的视图名称没有任何前缀时，视图名称被 SpringMVC 配置文件中所配置的视图解析器解析，视图名称拼接视图前缀和后缀提到最终路径，通过转发方式实现跳转。

2. InternalResourceView
3. RedirectView

### 21.3.5 RESTful

1. RESTful 简介

    REST 即 Representational State Transfer，表现层资源状态转移。

    - 资源

        服务器内万物皆资源。

    - 资源表述

        资源的表述是一段对于资源在某个特定时刻的状态描述，可以有多种格式。

    - 状态转移

        状态转移是指在客户端和服务器端之间转移代表状态状态的表述，通过转移和操作资源的表述，间接实现操作资源的目的。

2. RESTful 的实现

    HTTP 协议中，四个表示操作方式的动词：GET 对应的基本操作是获取资源，POST 用来新建资源，PUT 用来更新资源，DELETE 用来删除资源。

    | 操作     | 传统方式         | REST 风格                |
    | -------- | ---------------- | ------------------------ |
    | 查询操作 | getUserById?id=1 | user/1-->get 请求方式    |
    | 保存操作 | saveUser         | user-->post 请求方式     |
    | 删除操作 | deleteUser?id=1  | user/1-->delete 请求方式 |
    | 更新操作 | updateUser       | user-->put 请求方式      |

### 21.3.6 HttpMessageConverter

HttpMessageConverter 即报文信息转换器，将请求报文转换为 Java 对象，或将 Java 对象转换为响应报文。

1. @RequestBody
2. RequestEntity
3. @ResponseBody
4. SpringMVC 处理 json
5. SpringMVC 处理 ajax

### 21.3.7 文件下载上传

1. 下载文件
2. 上传文件

### 21.3.8 拦截器

1. 拦截器的配置
2. 拦截器的三个抽象方法
3. 多个拦截器的执行顺序

### 21.3.9 异常处理器

### 21.3.10 注解配置 SpringMVC

### 21.3.11 SpringMVC 执行流程

1. SpringMVC 常用组件
2. DispatcherServlet 初始化过程

    DispatcherServlet 本质是一个 Servlet，遵循 Servlet 的生命周期。

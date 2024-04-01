# 第 19 章 servlet

## 19.1 Servlet 技术

### 19.1.1 Servlet 概述

Servlet 是 JavaEE 规范之一，JavaWeb 三磊组织是 Servlet 程序、Fileter 过滤器及 Listener 监听器。

Servlet 可以接收客户端发送的的请求，并响应数据到客户端。

## 19.1.2 Servlet 体系结构

1. Servlet 的继承关系

    javax.servlet.Servlet 接口

    javax.servlet.GenericServlet 抽象类

    javax.servlet.http.HttpServlet 抽象子类

2. 方法

-   void init(config) 初始化
-   void service(req, resp) 服务

    当有请求时，service()方法自动响应，根据请求方式不同，调用不同的 do 方法，

-   void destroy() 销毁

### 19.1.3 Servlet 生命周期

Servlet 从初始化到销毁的过程，它的生命周期由 tomcat 服务器管理，对应 init,service 和 destroy 三个方法。

默认情况下，第一次接收请求时，servlet 会进行实例化、初始化，再进行服务，容器关闭时销毁。

servlet 初始化时机：默认第一次请求时进行初始化，可通过<load-on-startup>设置 servlet 启动顺序，数字越小，启动越早。

servlet 在容器中是单例的，线程不安全的。

### 19.1.4 实现 Servelt 程序

-   编写 Java 类实现 Servlet 接口
-   实现 service 方法，处理请求，并响应数据
-   在 web.xml 中配置 servlet 的响应地址
-

## 19.2 HTTP 协议

HTTP 即 Hyper Text Transfer Protocol, 超文本传输协议。

### 19.2.1 HTTP 请求

请求包含三个部分：请求行、请求消息头、请求主体。

1. 请求行

    包含请求方式、请求 URL 及请求协议(一般都是 HTTP1.1),

2. 请求消息头
3. 请求主体

    - get 方式，没有请求体，有一个 queryString
    - post 方式，有请求体，form data
    - JSON 格式，有请求体，request payload

### 19.2.2 HTTP 响应

响应包含三个部分：响应行、响应消息头及响应体。

1. 响应行

    包含协议、响应状态码、响应状态。

    | 响应状态码 | 说明           |
    | ---------- | -------------- |
    | 200        | 正常响应       |
    | 404        | 找不到资源     |
    | 405        | 请求方式不支持 |
    | 500        | 服务器内部错误 |

2. 响应消息头

    包含服务器的信息，服务器发送给浏览器的信息。

3. 响应体

    响应的实际内容。

## 19.3 session 会话

HTTP 是无状态的，即服务器无法区分多次请求是同一个客户端发送的还是不同客户端发送的。通过会话跟踪技术解决无状态问题。

### 19.3.1 session

### 19.3.2 服务器内部转发与客户端重定向

### 19.3.3 保存作用域

常用作用域主要有：

-   request

    一次请求响应范围

-   session

    一次会话范围有效

-   application

    一次应用程序范围有效

## 19.4 Thymeleaf

### 19.4.1 MVC

-   M(Model)模型

    分为多种，有值对象 pojo，有业务模型组件，有数据访问层组件。

    -   pojo：值对象模型
    -   DAO：数据访问模型
    -   BO：业务逻辑模型

-   V(View)视图

    数据展开及用户交互界面。

-   C(Controller)控制器

    接受客户端请求，具体业务功能由模型组件完成。

软件设计应当高内聚低耦合，内部组成应当高度聚合，层与层之间应该低耦合。

### 19.4.2 Thymeleaf 视图模板技术

-   添加 thymeleaf 依赖 jar 包
-   在 web.xml 文件中添加配置
-   新建 ViewBaseServlet（包含两个方法）
-   servlet 继承 ViewBaseServlet

控制反转

依赖注入

## 19.5 过滤器

### 19.5.1 Filter

过滤器 Filter 也属于 Servlet 规范

开发步骤：

-   新建类实现 Filter 接口
-   实现 init, doFilter,destroy 方法
-   配置 Filter，可使用注解@WebFilter，也可以使用 xml 文件<filter><filter-mapping>
-   Filter 配置时，也可以配置通配符

过滤器链：

如果采用注解进行配置，过滤器链的拦截顺序是全类名的先后顺序；如果采用 xml 文件配置，按照配置的先后顺序进行排序。

### 19.5.2 事务管理

### 19.5.3 监听器

1. ServletContextListener
2. HttpSessionListener
3. ServletRequestListener
4. ServletContextAttributeListener
5. HttpSessionAttributeListener
6. ServletRequestAttributeListener
7. HttpSessionBindingListener
8. HttpSessionActivationListener

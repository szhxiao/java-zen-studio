# 第 23 章 Shiro

### 23.1 Shiro 概述

Apache Shiro 是 Java 的一个安全（权限）框架，可以使用在 JavaSE 和 JavaEE 环境，完成认证、授权、加密、会话管理、与 Web 集成、缓存等功能。

### 23.1.1 Shiro 功能

1. Authentication

    身份认证登录，验证用户是否拥有相应的身份。

2. Authorization

    授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能进行什么操作。

3. Session Manager

    会话管理，即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中，会话可以是普通 JavaSE 环境，也可以是 Web 环境的。

4. Cryptography

    加密，保护数据的安全性。

5. Web Support

    Web 支持，集成到 Web 环境。

6. Caching

    缓存，如用户登录后其用户信息、拥有的角色/权限不必每次去查，以提高效率。

7. Concurrency

    支持多线程应用的并发验证。

8. Testing

    提供测试支持。

9. Run As

    允许一个用户在另一个用户同意的情况下以它的身份进行访问。

10. Remember Me

    记住我，即一次登录后，下次再来的话不用重新登录。

### 23.1.2 Shiro 架构

## 23.2 HelloShiro

### 23.2.1 导入 maven 依赖

// TODO: 明确 Shiro 的 maven 依赖，截取 maven 依赖关系图

### 23.2.2 QuickStart

## 23.3 Shiro 整合 Spring

### 23.3.1 maven 依赖

### 23.3.2 ShiroFilter

1. 默认过滤器
2. URL 匹配模式

    URL 匹配模式使用 Ant 风格，支持`?` `*`及`**`，但不包括目录分隔符"/"

    | 通配符 | 含义                       | 示例                                            |
    | ------ | -------------------------- | ----------------------------------------------- |
    | ?      | 匹配一个字符               | /admin? 将匹配/admin1，但不匹配/admin 或/admin/ |
    | \*     | 匹配零个或多个字符串       | /admin\* 将匹配/admin、/admin123 等等           |
    | \*\*   | 匹配路径中的零个或多个路径 | /admin/\*\* 将匹配/admin/a 或/admin/a/b 等      |

3. URL 匹配顺序

    URL 权限采取第一次匹配优先的方式，即从头开始使用第一个匹配的 URL 模式对应的拦截器链。

## 23.4 认证

## 23.5 授权

授权，即访问控制，在应用中控制允许访问的资源。

## 23.6 会话管理

Shiro 提供了完整的企业级会话管理，不依赖于底层容器，提供了会话管理、会话事件监听、会话存储/持久化、容器无关的集群、失效/过期支持、对 Web 的透明支持、SSO 单点登录支持等功能。
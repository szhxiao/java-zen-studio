# 第 25 章 SpringCloud

## 25.1 微服务概述

### 25.1.1 微服务概述

1. 微服务

    [微服务](https://martinfowler.com/articles/microservices.html)

    优点：

    - 每个服务足够内聚，足够小
    - 开发简单、开发效率提高
    -

2. 微服务架构

    微服务架构是一种架构模式或架构风格，提倡将单一应用程序划分成一组小的服务，每个服务运行在其独立的进程中，服务之间互相协调、互相配合，为用户提供最终价值。服务之间采用轻量级通信机制互相沟通。

### 25.1.2 微服务技术栈

| 微服务项目                             | 技术                                                            |
| -------------------------------------- | --------------------------------------------------------------- |
| 服务开发                               | Springboot、Spring、SpringMVC                                   |
| 服务配置与管理                         | Netflix 公司的 Archaius、阿里的 Diamond 等                      |
| 服务注册与发现                         | Eureka、Consul、Zookeeper 等                                    |
| 服务调用                               | Rest、RPC、gRPC                                                 |
| 服务熔断器                             | Hystrix、Envoy 等                                               |
| 负载均衡                               | Ribbon、Nginx 等                                                |
| 服务接口调用(客户端调用服务的简化工具) | Feign 等                                                        |
| 消息队列                               | Kafka、RabbitMQ、ActiveMQ 等                                    |
| 服务配置中心管理                       | SpringCloudConfig、Chef 等                                      |
| 服务路由（API 网关）                   | Zuul 等                                                         |
| 服务监控                               | Zabbix、Nagios、Metrics、Spectator 等                           |
| 全链路追踪                             | Zipkin，Brave、Dapper 等                                        |
| 服务部署                               | Docker、OpenStack、Kubernetes 等                                |
| 数据流操作开发包                       | SpringCloud Stream（封装与 Redis,Rabbit、Kafka 等发送接收消息） |
| 事件消息总线                           | Spring Cloud Bus......                                          |

## 25.2 SpringCloud 概述

# WeMQ - 物联网调试管理平台
[![mqttlogo.png](https://img.nicholasld.cn/i/2023/04/08/6430b2aff1b11.png)](https://img.nicholasld.cn/i/2023/04/08/6430b2aff1b11.png)
## 1. 项目介绍

### 1.1 项目简介

**MQTT调试管理平台是一款基于Spring + Spring MVC + Mybatis开发的一款物联网设备调试管理平台。**

其功能主要是对客户MQTT调试页面进行集中管理（连接信息、发送信息），系统管理员可在后台添加客户和调试页面，并设置调试页面的连接信息、发送消息和对应的发送按钮文字，并设置分享链接以及页面的开启状态，用户可通过分享链接打开配置好对应信息的页面，实现对自己设备的管理调试。

### 1.2 技术选型

##### 1. 系统环境

- Java 11
- Servlet 3.0
- Apache Maven 3

##### 2. 主框架

- Spring Framework 5.3.x
- Spring MVC 5.3.x

##### 3. 持久层

- Mybatis 3.5.x
- Alibaba Druid 1.2.x
- Hibernate Validation 6.0.x
- Java MySQL Connector 8.0.x

##### 4. 视图层

- Thymeleaf 3.x
- Bootstrap 5.x

##### 5. 工具类

- Apache Commons
- Hutool 5.x

### 1.3 主要功能

- 系统管理员管理
- 客户管理
- 调试页面管理
- 对接Nmqs（NicholasLD's Message Queue Service）
- 客户调试页面
- 登录日志

### 1.4 项目负责人

**组长：**

李任任、龙政宇

**组员：**

罗猷力、常浩哲、纪雨佳、李宇航、梁晓惠、袁祎阳

### 1.5 项目结构
```
cn.mmanager
├── mm-common            // 工具类
│       └── annotation                    // 自定义注解
│       └── constant                      // 通用常量
│       └── core                          // 核心控制
│       └── enums                         // 通用枚举
│       └── exception                     // 通用异常
├── mm-framework         // 框架核心
│       └── aspectj                       // 注解实现
│       └── interceptor                   // 拦截器
│       └── manager                       // 异步处理
│       └── web                           // 前端控制
├── mm-web       	 // Web服务
├── mm-dao      	 // 数据访问层
├── mm-service     // 业务层
├── mm-model       // 模型
```

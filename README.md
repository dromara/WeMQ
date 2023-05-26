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

### 1.4 项目结构
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

### 1.5 数据库结构
![https://img.nicholasld.cn/i/2023/05/19/646712f025150.png](https://img.nicholasld.cn/i/2023/05/19/646712f025150.png)

## 2. 部署文档

### 2.1 如何部署

首先导入项目根目录的 WeMQ.sql 文件到数据库，数据库名为 `WeMQ`，然后对数据库连接信息进行配置，在`mm-web`模块的`/src/main/resources/database.properties`文件中进行数据库连接信息的配置，然后就可以导入到Tomcat中进行运行

### 2.2 如何修改 Nmqs服务地址

本项目依赖于我的另一个开源项目 Nmqs 来实现对MQTT的转发和连接，如需部署Nmqs，[请访问](https://gitee.com/nicholasld/Nmqs/)。

在`mm-web/src/main/webapp/statics/system/common.js`中修改第一行的url变量，如果需要https，则修改第三行的http为https

# WeMQ - 物联网调试管理平台
<img src="https://img.nicholasld.cn/i/2023/09/22/650d382ad4e66.png" width="700">

>####  WeMQ 目前已加入 [Dromara 社区 ](https://gitee.com/dromara) 孵化项目

## 📂 1. 项目介绍

### 1.1 项目简介

**MQTT调试管理平台是一款基于SpringBoot开发的一款物联网设备调试管理平台。**

其功能主要是对客户MQTT调试页面进行集中管理（连接信息、发送信息），系统管理员可在后台添加客户和调试页面，并设置调试页面的连接信息、发送消息和对应的发送按钮文字，并设置分享链接以及页面的开启状态，用户可通过分享链接打开配置好对应信息的页面，实现对自己设备的管理调试。

![GitHub](https://img.shields.io/github/license/NicholasLD/WeMQ)
[![star](https://gitee.com/nicholasld/WeMQ/badge/star.svg?theme=dark)](https://gitee.com/nicholasld/WeMQ/stargazers)
[![fork](https://gitee.com/nicholasld/WeMQ/badge/fork.svg?theme=dark)](https://gitee.com/nicholasld/WeMQ/members)

#### 项目截图：
控制台
![D7CCC3CA-0B97-4A0F-8A03-8DC8A91F58A2.png](https://img.nicholasld.cn/i/2023/09/22/650d5384475a7.jpg)
用户调试界面
![QQ20230531-024439@2x.png](https://img.nicholasld.cn/i/2023/09/22/650d538510281.jpg)
调试页面参数
![QQ20230531-024618@2x.png](https://img.nicholasld.cn/i/2023/09/22/650d5384a35f5.jpg)

### 1.2 技术选型

##### 1. 系统环境

- Java 8
- Servlet 3.0
- Apache Maven 3

##### 2. 主框架

- Spring Boot 2.7.x
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
- Layui 2.x

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

## ⚙️ 2. 部署文档

### 2.1 如何部署

首先导入项目根目录的 WeMQ.sql 文件到数据库，数据库名为 `WeMQ`，然后对数据库连接信息进行配置，在`mm-web`模块的`/src/main/resources/application.yml`文件中进行数据库连接信息的配置

### 2.2 如何修改 Nmqs服务地址

本项目依赖于另一个开源项目 Nmqs 来实现对MQTT的转发和连接，如需部署Nmqs，[请访问](https://gitee.com/nicholasld/nmqs)。

在`application.yml`中修改wemq下的属性即可，根据WeMQ项目地址自动适配http或https、ws或wss

```yaml
wemq:
  nmqs:
    host: localhost
    port: 8081
```

### 2.3 启动项目
启动`mm-web`中的`WeMQApplication`，访问`http://<你的项目地址>:8080`即可

初始账号密码为`admin`/`admin`

## 💡 Issues & Pull Requests
欢迎提交Issues和Pull Requests，开源大门永远向所有人敞开。

## ✉️ 联系作者
- Email: 878639947@qq.com
- QQ: 878639947
- WeChat: NicholasLD505

## 🔰 License(开源许可证)
Apache License Version 2.0 see http://www.apache.org/licenses/LICENSE-2.0.html

## ©️ 版权使用说明
WeMQ遵循Apache2.0开源协议，可用于个人学习、毕设、公司项目、商业产品等，但必须保留版权信息。

## 🪐 知识星球
![img_1.png](img_1.png)


## 🎉 特别鸣谢
感谢 **JetBrains** 为本项目提供的免费开源许可证支持。

<a href="https://jb.gg/OpenSourceSupport">
  <img src="https://user-images.githubusercontent.com/8643542/160519107-199319dc-e1cf-4079-94b7-01b6b8d23aa6.png" align="left" height="150" width="150" alt="JetBrains">
</a>

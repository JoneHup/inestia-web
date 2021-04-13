# 琴智官网

inestia-web 是基于 Spring Boot 2.0 + Mybatis  的轻量级工程，项目分为官网系统(inestia-web)和后台管理系统(inestia-manage)两部分。
官网系统主要为琴智官网页面展示，后台管理系统作为数据管理和采集，支持按钮级别的权限控制，系统具有最基本的用户管理、角色管理、权限管理等通用性功能.

### 后端技术

技术 | 名称 | 版本 | 官网
----|------|----|----
Spring Boot | 应用框架 | 2.0.0.RELEASE | [https://projects.spring.io/spring-boot/](https://projects.spring.io/spring-boot/)
MyBatis | ORM框架 | 3.2.1 |  [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)
Mapper | MyBatis 通用 Mapper4 | 4.0.0 |  [https://gitee.com/free/Mapper](https://gitee.com/free/Mapper)
PageHelper | MyBatis 分页插件 | 5.1.2 |  [https://gitee.com/free/Mybatis_PageHelper](https://gitee.com/free/Mybatis_PageHelper)
Maven | 项目构建管理 | 4.0.0 |  [http://maven.apache.org](http://maven.apache.org/)
MyBatis Generator | 代码生成 | 1.3.5 |  [http://www.mybatis.org/generator/index.html](http://www.mybatis.org/generator/index.html)
Thymeleaf | 模板引擎 | 3.0.9.RELEASE |  [https://www.thymeleaf.org/](https://www.thymeleaf.org/)
Apache Shiro | 安全框架 | 1.2.2 |  [http://shiro.apache.org](http://www.mybatis.org/generator/index.html)
Logback | 日志组件 | 1.1.3 |  [https://logback.qos.ch](https://logback.qos.ch/)
Druid | 数据库连接池 | 0.2.23 |  [https://github.com/alibaba/druid](https://github.com/alibaba/druid)
Hibernate Validator | 后端校验框架 | 5.4.2.Final | [http://hibernate.org/validator/](http://hibernate.org/validator/)

### 前端技术

技术 | 名称 | 版本 |  官网
----|------|----|----
jQuery | 优秀的Javascript库 | 3.2.1 |  [http://jquery.com/](http://jquery.com/)
Admin-LTE| 基于Bootstrap的前端框架 | 3.0.0 |  [https://adminlte.io/](https://adminlte.io/)
Bootstrap Table | 数据表格 | 1.10.16 |  [http://bootstrap-table.wenzhixin.net.cn/zh-cn/getting-started/](http://bootstrap-table.wenzhixin.net.cn/zh-cn/getting-started/)
Layer | jQuery弹出层插件 | 3.1.0 |  [http://layer.layui.com/](http://layer.layui.com/)
ZTree | jQuery树插件 | 3.5.29 |  [http://www.treejs.cn](http://www.treejs.cn)

## 软件需求

- JDK1.8+
- MySQL5.6+
- Maven3.0+

## 本地部署

- 通过git下载源码
- 创建数据库qinzhi_db，数据库编码为UTF-8
- 依次执行后台管理工程下的script/db/sql/schema.sql和script/db/sql/data.sql文件，初始化数据
- 修改application-dev.properties文件，更新MySQL账号和密码
- 运行Maven命令mvn install
- 运行InestiaManageApplication/InestiawebApplication分别启动官网系统和后台管理系统
- 项目访问路径：
    官网系统：http://localhost:9000
    后台管理系统：http://localhost:9000/inestia-manage
- 后台管理系统密码：admin/1234@qwer

## 获取源码

     [https://github.com/JoneHup/inestia-web.git]
官网系统:   切换分支v2.0-manage
后台管理系统: 切换分支v2.0-web



